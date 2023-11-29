package org.example;

public class Accumulator {

    private int value = 0;
    private static int max = 10;

    public int accumulate(int value) {
        this.value += value;
        if (this.value > max) {
            this.value %= max;
        }
        return this.value;
    }

}
