package ru.alexproger.aopfirsttest;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.alexproger.aopfirsttest.objects.FileManger;
import ru.alexproger.aopfirsttest.service.SomeService;

public class Start {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("filecontext.xml");
        FileManger service = (FileManger) context.getBean("fileManger");
        service.getExtensionCount("/home/alexander/");
        service.getExtensionList("/home/alexander/");

        ((ConfigurableApplicationContext)context).close();
    }
}
