package org.example.chapter06;
public class EvalValue {
    public final JVMType type;
    public final long value;

    EvalValue(JVMType t, long bits) {
        this.type = t;
        this.value = bits;
    }
}

