package ru.alexproger.aopfirsttest.service;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
@Lazy
public class SomeService {
    public int getIntValue() {
        return 5;
    }

    public double getDoubleValue() {
        /*int res = 5/0;*/
        return 5.6;
    }
}
