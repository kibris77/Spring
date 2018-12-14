package ru.alexproger.spring.impls.toshiba;

import ru.alexproger.spring.interfaces.Head;

public class ToshibaHead implements Head {
    @Override
    public void calculate() {
        System.out.println("Toshiba calc");
    }
}
