package ru.alexproger.aopfirsttest.logging;

import org.springframework.stereotype.Component;

@Component
public class MyLogger {
    public void printValue(Object obj) {
        System.out.println(obj);
    }

    public void init() {
        System.out.println("init");
    }

    public void close() {
        System.out.println("close");
    }

    public void printError(Exception e) {
        System.out.println(e);
    }

}
