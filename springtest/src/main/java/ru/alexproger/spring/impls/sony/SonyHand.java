package ru.alexproger.spring.impls.sony;

import ru.alexproger.spring.interfaces.Hand;

public class SonyHand implements Hand {
    @Override
    public void catchSomesing() {
        System.out.println("Sony catch");
    }
}
