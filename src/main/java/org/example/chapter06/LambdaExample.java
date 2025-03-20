package org.example.chapter06;

public class LambdaExample {
    private static final String HELLO = "Hello";

    public static void main(String[] args) throws Exception {
        Runnable r = () -> System.out.println(HELLO);
        Thread t = new Thread(r);
        t.start();
        t.join();
    }
}

/**
 * LambdaExample.java 생성
 * LambdaExample.class 생성
 * javap -c LambdaExample (cmd 실행)
 */