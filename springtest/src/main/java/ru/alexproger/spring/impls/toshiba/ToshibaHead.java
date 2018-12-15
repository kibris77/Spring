package ru.alexproger.spring.impls.toshiba;

import org.springframework.stereotype.Component;
import ru.alexproger.spring.interfaces.Head;

@Component
public class ToshibaHead implements Head {
    @Override
    public void calculate() {
        System.out.println("Toshiba calc");
    }
}
