package org.example.chapter13;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;

public class MethodHandlesExample {
    public static void main(String[] args) throws Throwable {
        MethodType mt = MethodType.methodType(int.class);
        MethodHandles.Lookup l = MethodHandles.lookup();
        MethodHandle mh = l.findVirtual(String.class, "hashCode", mt);

        String receiver = "b";
        int ret = (int) mh.invoke(receiver);

        System.out.println(ret);
    }
}

/**
 * MethodHandlesExample.java 생성
 * MethodHandlesExample.class 생성
 * javap -c MethodHandlesExample (cmd 실행)
 */