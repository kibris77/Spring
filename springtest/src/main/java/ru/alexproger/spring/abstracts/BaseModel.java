package ru.alexproger.spring.abstracts;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import ru.alexproger.spring.interfaces.Hand;
import ru.alexproger.spring.interfaces.Head;
import ru.alexproger.spring.interfaces.Leg;

public abstract class BaseModel {
    @Autowired
    private Leg leg;

    @Autowired
    private Head head;

    @Autowired
    private Hand hand;

    public BaseModel() {
        System.out.println("Base model");
    }


    public Leg getLeg() {
        return leg;
    }

    public void setLeg(Leg leg) {
        this.leg = leg;
    }

    public Head getHead() {
        return head;
    }

    public void setHead(Head head) {
        this.head = head;
    }

    public Hand getHand() {
        return hand;
    }

    public void setHand(Hand hand) {
        this.hand = hand;
    }
}
