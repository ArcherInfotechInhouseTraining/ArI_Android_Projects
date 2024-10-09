package com.ArcherInfotech.tutionapp.Modal;

public class Cources {
    private final String text;
    private final int drawableResId;

    public Cources(String text, int drawableResId) {
        this.text = text;
        this.drawableResId = drawableResId;
    }

    public String getText() {
        return text;
    }

    public int getDrawableResId() {
        return drawableResId;
    }
}
