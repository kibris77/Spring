package ru.alexproger.spring.impls.toshiba;

import org.springframework.stereotype.Component;
import ru.alexproger.spring.interfaces.Hand;

@Component
public class ToshibaHand implements Hand {
    @Override
    public void catchSomesing() {
        System.out.println("Toshiba catch");
    }
}
