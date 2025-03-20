package org.example.chapter03;

public class ThreadExample {
    public static void main(String[] args) {
        // 새 스레드 생성 및 실행
        Thread t = new Thread(() -> {
            System.out.println("Hello World!");
        });

        // 스레드 시작
        t.start();
    }
}

