package ru.alexproger.spring.impls.toshiba;

import ru.alexproger.spring.interfaces.Hand;

public class ToshibaHand implements Hand {
    @Override
    public void catchSomesing() {
        System.out.println("Toshiba catch");
    }
}
