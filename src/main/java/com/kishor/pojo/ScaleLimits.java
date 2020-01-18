package com.kishor.pojo;

public class ScaleLimits<T, S> {
    T low;
    T high;
    S description;

    public ScaleLimits(T low, T high, S description) {
        this.low = low;
        this.high = high;
        this.description = description;
    }

    public T getLow() {
        return low;
    }

    public T getHigh() {
        return high;
    }

    public S getDescription() {
        return description;
    }

}