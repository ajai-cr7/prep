class FooBar {
    private int n;
    volatile Boolean flag;

    public FooBar(int n) {
        this.n = n;
        flag = true;
    }

    public void foo(Runnable printFoo) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            synchronized(this){ //without this or syncrhonized keyword at method level, it throws illegalstatemonitor exception.
                                // because, wait and notify will be used without acquiring intrinsic lock on the current object!
                while (!flag) {
                    wait();
                }
                printFoo.run();
                flag = false;
                notifyAll();
            }
                 
            // printFoo.run() outputs "foo". Do not change or remove this line.

        }
    }

    public synchronized void bar(Runnable printBar) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            while (flag) {
                wait();
            }
            printBar.run();
            flag = true;
            notifyAll();

            // printBar.run() outputs "bar". Do not change or remove this line.

        }
    }
}
