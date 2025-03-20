package org.example.chapter13;

public class AtomicIntegerWithVarHandlesTest {
    public static void main(String[] args) {
        AtomicIntegerWithVarHandles atomicInt = new AtomicIntegerWithVarHandles();

        System.out.println("Initial Value: " + atomicInt.get());

        // Test set method
        atomicInt.set(10);
        System.out.println("After set(10): " + atomicInt.get());

        // Test getAndSet method
        int oldValue = atomicInt.getAndSet(20);
        System.out.println("Old Value from getAndSet(20): " + oldValue);
        System.out.println("New Value after getAndSet: " + atomicInt.get());
    }
}
