package org.example.enums;

public enum Result {
    WIN(3), LOSE(-1), DRAW(0);

    private final int value;

    Result(int value) {
        this.value = value;
    }

    public int getValue() {
        return this.value;
    }
}
