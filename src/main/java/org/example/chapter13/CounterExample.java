package org.example.chapter13;

public class CounterExample implements Runnable {

    private final Counter counter;

    public CounterExample(Counter counter) {
        this.counter = counter;

    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println(Thread.currentThread().getName()
                    + " Value: " + counter.increment());
        }
    }

    public static void main(String[] args) {
        Counter co = new Counter();
        Thread t1 = new Thread(new CounterExample(co), "Thread-1");
        Thread t2 = new Thread(new CounterExample(co), "Thread-0");

        t1.start();
        t2.start();
    }
}
