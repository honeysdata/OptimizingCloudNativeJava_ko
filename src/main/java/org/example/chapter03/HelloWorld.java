package org.example.chapter03;

public class HelloWorld {
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            System.out.println("Hello World");
        }
    }
}

/**
 * 1. HelloWorld.java 생성
 * 2. javac HelloWorld.java 실행(cmd) > HelloWorld.class 파일 생성
 * 3. javap -c HelloWorld 실행하려 결과 확인
 */
