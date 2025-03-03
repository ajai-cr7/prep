/*

- Use two threads. One should print odd and another should print even numbers. 
- Use semaphore concept to control execution of two threads to print alternatively!

eg : 
1
2
3
4
5
6

*/


import java.util.concurrent.Semaphore;

public class semaphore {
    public static void main(String[] args) {
        NumberPrinter printer = new NumberPrinter(10);

        Thread t1 = new Thread(new Runnable(){
            @Override
            public void run(){
                printer.printOdd();
            }
        });
        Thread t2 = new Thread(printer::printEven);

        t1.start();
        t2.start();
    }
}

class NumberPrinter {
    private int num = 1;
    private int max;
    private final Semaphore oddSemaphore = new Semaphore(1);
    private final Semaphore evenSemaphore = new Semaphore(0);

    public NumberPrinter(int max) {
        this.max = max;
    }

    public void printOdd() {
        for (int i = 1; i <= max; i += 2) {
            try {
                oddSemaphore.acquire(); // Wait for odd turn
                System.out.println(i);
                evenSemaphore.release(); // Allow even thread
            } catch (InterruptedException e) { }
        }
    }

    public void printEven() {
        for (int i = 2; i <= max; i += 2) {
            try {
                evenSemaphore.acquire(); // Wait for even turn
                System.out.println(i);
                oddSemaphore.release(); // Allow odd thread
            } catch (InterruptedException e) { }
        }
    }
}

/*
A semaphore is a synchronization primitive that is used to manage access to a shared resource by multiple threads in concurrent programming. 
It allows you to control the number of threads that can access a particular resource or section of code at the same time.

In Java, Semaphore is a class in the java.util.concurrent package that is often used to coordinate access to resources. 
It is especially useful when you want to limit the number of concurrent threads accessing a shared resource, 
or when you want to enforce specific ordering between threads.


Summary of When to Use Semaphores:
- Limiting concurrent access: When you have limited resources and want to limit the number of threads that can access them at a time.
- Managing producer-consumer problems: When you have producers and consumers working with shared resources like a buffer.
- Controlling thread execution order: When you need to coordinate the execution order of threads or 
make sure threads alternate (like printing odd/even numbers).
- Resource pooling: When you need to manage a pool of resources like database connections, thread pools, or network connections.




* */
