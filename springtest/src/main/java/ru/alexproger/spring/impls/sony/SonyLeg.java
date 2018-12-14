package ru.alexproger.spring.impls.sony;

import ru.alexproger.spring.interfaces.Leg;

public class SonyLeg implements Leg {
    @Override
    public void move() {
        System.out.println("Sony move");
    }
}
