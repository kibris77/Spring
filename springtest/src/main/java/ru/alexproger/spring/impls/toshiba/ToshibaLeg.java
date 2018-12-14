package ru.alexproger.spring.impls.toshiba;

import ru.alexproger.spring.interfaces.Leg;

public class ToshibaLeg implements Leg {
    @Override
    public void move() {
        System.out.println("Toshiba move");
    }
}
