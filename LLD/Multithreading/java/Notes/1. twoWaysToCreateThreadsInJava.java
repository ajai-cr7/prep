public class twoWaysToCreateThreadsInJava
{
    public static void main(String[] args) {

        //Approach 1 :
        approach1 t1 = new approach1();
        t1.start();

        // Approach 2 :
        Thread t2 = new Thread(new approach2()); //pass instance of runnable interface to thread object!
        t2.start();

        // Approach 3 : Use Lambdas!
    }
}

class approach1 extends Thread{ //Inheritance!
    @Override
    public void run(){
        System.out.println("This thread extends Thread class and overrides run method!");
    }
}

class approach2 implements Runnable{ //Concrete class implementation!
    @Override
    public void run(){
        System.out.println("This thread implements runnable interface and overrides run method!");
    }
}

/*

    - Two ways to create Thread in java!
        1.Extend Thread class and override run method!
            - Write a class which extends Thread class!
            - override run method.
            - Create object for that class and call start method!
        2.Implement Runnable Functional Interface and override run method!
            - Create a Thread object.
            - Pass an object of class which implements Runnable Functional interface to the Thread object as constructor.
            - Call start() on the Thread object.


*/
