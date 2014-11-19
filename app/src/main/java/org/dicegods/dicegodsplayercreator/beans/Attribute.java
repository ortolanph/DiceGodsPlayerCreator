package org.dicegods.dicegodsplayercreator.beans;

public class Attribute {
    private final Integer initial;
    private Integer current;

    private static final String TO_STRING = "Attribute {initial=%d, current=%d}";

    public Attribute(Integer initial) {
        this.initial = initial;
        this.current = initial;
    }

    public Integer getCurrent() {
        return current;
    }

    public Integer getInitial() {
        return initial;
    }

    public void add(Integer points) {
        current += points;

        if(current > initial) {
            current = initial;
        }
    }

    public void subtract(Integer points) {
        current -= points;

        if(current < 0) {
            current = 0;
        }
    }

    @Override
    public String toString() {
        return String.format(TO_STRING, initial, current);
    }
}
