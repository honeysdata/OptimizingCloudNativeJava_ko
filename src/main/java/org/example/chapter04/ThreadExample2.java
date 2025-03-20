package org.example.chapter04;

public class ThreadExample2 {
    public static void main(String[] args) {
        int[] anInt = new int[1];
        anInt[0] = 42;
        Runnable r = () -> {
            anInt[0]++;
            System.out.println("Changed: "+ anInt[0]);
        };
        new Thread(r).start();
    }

}
