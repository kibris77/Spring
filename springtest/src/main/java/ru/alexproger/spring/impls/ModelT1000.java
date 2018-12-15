package ru.alexproger.spring.impls;

import org.springframework.stereotype.Component;
import ru.alexproger.spring.abstracts.BaseModel;
import ru.alexproger.spring.interfaces.Hand;
import ru.alexproger.spring.interfaces.Head;
import ru.alexproger.spring.interfaces.Leg;
import ru.alexproger.spring.interfaces.Robot;

@Component
public class ModelT1000 extends BaseModel implements Robot {

    @Override
    public void dance() {
        System.out.println("Dancing");
    }

    @Override
    public void action() {
        getHand().catchSomesing();
        getHead().calculate();
        getLeg().move();
    }
}
