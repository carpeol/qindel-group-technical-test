package com.qindel.test.prices.domain.vo;

import java.util.Objects;

public abstract class ValueObject<T> {

    private final T value;

    protected ValueObject(T value) {
        this.value = value;
    }

    public final T value() {
        return value;
    }

    @Override
    public final boolean equals(Object other) {
        if (this == other) return true;
        return other != null && getClass() == other.getClass()
                && Objects.equals(value, ((ValueObject<?>) other).value);
    }

    @Override
    public final int hashCode() {
        return Objects.hash(getClass(), value);
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }

}
