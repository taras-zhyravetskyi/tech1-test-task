package com.tech1test.entity;

import com.fasterxml.jackson.annotation.JsonCreator;

public enum Color {
        WHITE("white"),
        GREEN("green"),
        PINK("pink"),
        RED("red"),
        BLUE("blue"),
        BLACK("black");

    private final String text;

    Color(String text) {
        this.text = text;
    }

    public String getText() {
        return this.text;
    }

    @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
    public static Color fromText(String text) {
        for (Color color : Color.values()) {
            if (color.getText().equals(text)) {
                return color;
            }
        }
        throw new IllegalArgumentException();
    }

    @Override
    public String toString() {
        return this.text;
    }
}
