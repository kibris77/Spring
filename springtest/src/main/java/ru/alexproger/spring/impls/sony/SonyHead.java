package ru.alexproger.spring.impls.sony;

import ru.alexproger.spring.interfaces.Head;

public class SonyHead implements Head {
    @Override
    public void calculate() {
        System.out.println("Sony calc");
    }
}
