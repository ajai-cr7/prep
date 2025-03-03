/*

  - Create two threads --> thread 1 should print only odd numbers. thread 2 should print only even numbers. 
  - Use wait() and notify() methods for inter thread communication and also either volatile variable or atomic boolean variable for flags.

*/


public class InterThreadCommunication { //using wait() and notify()
    public static void main(String[] args) {
        Printer printer = new Printer();

        // OddPrinter starts with 1 and EvenPrinter starts with 2
        OddPrinter oddPrinter = new OddPrinter(printer, 1);
        EvenPrinter evenPrinter = new EvenPrinter(printer, 2);

        // Start the threads
        oddPrinter.start(); //this thread should always print odd numbers!
        evenPrinter.start(); //this thread should always print even numbers!
    }
}
    class Printer {
    boolean isOddTurn = true; // First, odd numbers will be printed

    synchronized void printOdd(int num) {
        while (!isOddTurn) {
            try {
                wait(); // Wait until it's odd turn
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        System.out.println(num);
        isOddTurn = false; // Now it's even turn
        notify(); // Wake up the even thread
    }

    synchronized void printEven(int num) {
        while (isOddTurn) {
            try {
                wait(); // Wait until it's even turn
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        System.out.println(num);
        isOddTurn = true; // Now it's odd turn
        notify(); // Wake up the odd thread
    }
}

class OddPrinter extends Thread {
    Printer printer;
    int startNum;

    OddPrinter(Printer printer, int startNum) {
        this.printer = printer;
        this.startNum = startNum;
    }

    @Override
    public void run() {
        for (int i = startNum; i <= 10; i += 2) {  // Print odd numbers from startNum
            printer.printOdd(i);
        }
    }
}

class EvenPrinter extends Thread {
    Printer printer;
    int startNum;

    EvenPrinter(Printer printer, int startNum) {
        this.printer = printer;
        this.startNum = startNum;
    }

    @Override
    public void run() {
        for (int i = startNum; i <= 10; i += 2) {  // Print even numbers from startNum
            printer.printEven(i);
        }
    }
}
