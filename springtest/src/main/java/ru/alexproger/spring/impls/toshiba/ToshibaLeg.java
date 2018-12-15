package ru.alexproger.spring.impls.toshiba;

import org.springframework.stereotype.Component;
import ru.alexproger.spring.interfaces.Leg;

@Component
public class ToshibaLeg implements Leg {
    @Override
    public void move() {
        System.out.println("Toshiba move");
    }
}
