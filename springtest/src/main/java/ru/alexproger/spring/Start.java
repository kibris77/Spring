package ru.alexproger.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.alexproger.spring.interfaces.Robot;

public class Start {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("context.xml");
        Robot robot = (Robot)context.getBean("t1000");
        robot.action();
    }
}
