package ru.alexproger.spring.impls.sony;

import ru.alexproger.spring.interfaces.Head;

public class SonyHead implements Head {
    private String color;

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public void calculate() {
        System.out.println("Sony calc " + color);
    }
}
