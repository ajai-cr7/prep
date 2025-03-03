
class Foo {

    Semaphore s1,s2;
    public Foo() {
        s1 = new Semaphore(0);
        s2 = new Semaphore(0);
    }

    public void first(Runnable printFirst) throws InterruptedException {
        // printFirst.run() outputs "first". Do not change or remove this line.
        printFirst.run();
        s1.release();
    }

    public void second(Runnable printSecond) throws InterruptedException {
        s1.acquire();
        // printSecond.run() outputs "second". Do not change or remove this line.
        printSecond.run();
        s2.release();
    }

    public void third(Runnable printThird) throws InterruptedException {
        s2.acquire();
        // printThird.run() outputs "third". Do not change or remove this line.
        printThird.run();

    }
}

/*

    1. Atomic Boolean / Integer
    2. Volatile
    3. Synchronized + Wait/Notify
    4. Semaphores
    5. Locks
    6. Exchanger / CyclicBarrier / CountDownLatch

*/


//Approach 2 : 


/*
🔑 What is IllegalMonitorStateException?
This exception happens when:

A thread calls wait(), notify(), or notifyAll() without owning the lock on that object.
*/

class Foo {

    volatile boolean odd, even;

    public Foo() {
        odd = true;
        even = true;
    }

    public synchronized void first(Runnable printFirst) throws InterruptedException {
        // printFirst.run() outputs "first". Do not change or remove this line.
        printFirst.run();
        odd = false;
        notifyAll();
    }

    // If we forget synchronized keyword, then it will throw illegalMonitoringException - current thread is not owner!
    public synchronized void second(Runnable printSecond) throws InterruptedException {
        while (odd) {
            try {
                wait();
            } catch (InterruptedException e) {
                throw e;
            }
        }
        // printSecond.run() outputs "second". Do not change or remove this line.
        printSecond.run();
        even = false;
        notifyAll();

    }

    public synchronized void third(Runnable printThird) throws InterruptedException {
        while (even) {
            try {
                wait();
            } catch (InterruptedException e) {
                throw e;
            }
        }
        // printThird.run() outputs "third". Do not change or remove this line.
        printThird.run();
    }
}

/*

The wait() and notifyAll() methods always require the current thread to own the intrinsic lock of the object.

An "intrinsic lock" in Java is a built-in lock mechanism associated with every object, essentially acting as a "key" that ensures only one
thread can access and modify the object's state at a time, preventing race conditions when multiple threads try to access the same data;
it's also known as a "monitor lock". 

Key points about intrinsic locks:

- Every object has one: Every object created in Java automatically has its own intrinsic lock. 
- Exclusive access: When a thread acquires an object's intrinsic lock, it gains exclusive access to that object, 
    preventing other threads from modifying its state until the lock is released. 
- Synchronized keyword: In Java, the "synchronized" keyword is used to explicitly mark code blocks that require access to an object's 
    intrinsic lock. 
    
*/
