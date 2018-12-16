package ru.alexproger.aopfirsttest;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.alexproger.aopfirsttest.service.SomeService;

public class Start {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("context.xml");
        SomeService service = (SomeService) context.getBean("someService");
        double val = service.getDoubleValue();
        ((ConfigurableApplicationContext)context).close();
    }
}
