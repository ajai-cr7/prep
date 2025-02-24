**Question:**

Consider N people start at the running race.Once all people arrive at that starting point then only referre blows whistle and counts 3,2,1 to start the race. 

Simulate and solve this problem using multithreading

```java
import java.util.concurrent.CountDownLatch;

class Runner implements Runnable {
    private String name;
    private CountDownLatch readyLatch;
    private CountDownLatch startLatch;

    public Runner(String name, CountDownLatch readyLatch, CountDownLatch startLatch) {
        this.name = name;
        this.readyLatch = readyLatch;
        this.startLatch = startLatch;
    }

    @Override
    public void run() {
        try {
            System.out.println(name + " is at the starting point.");
            readyLatch.countDown(); // Signal that this runner is ready
            startLatch.await(); // Wait for the referee's signal to start
            System.out.println(name + " started running!");
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}

public class RaceSimulation {
    public static void main(String[] args) throws InterruptedException {
        int numRunners = 5;
        CountDownLatch readyLatch = new CountDownLatch(numRunners);
        CountDownLatch startLatch = new CountDownLatch(1);
        
        // Creating and starting runner threads
        for (int i = 1; i <= numRunners; i++) {
            new Thread(new Runner("Runner " + i, readyLatch, startLatch)).start();
        }
        
        // Wait until all runners are at the starting point
        readyLatch.await();
        
        System.out.println("Referee: All runners are ready. Countdown begins...");
        Thread.sleep(1000);
        System.out.println("3");
        Thread.sleep(1000);
        System.out.println("2");
        Thread.sleep(1000);
        System.out.println("1");
        Thread.sleep(1000);
        System.out.println("Go!");
        
        startLatch.countDown(); // Signal all runners to start
    }
}

```
