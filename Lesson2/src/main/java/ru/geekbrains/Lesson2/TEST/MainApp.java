package ru.geekbrains.Lesson2.TEST;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class MainApp {
    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        DemoBean demoBean1 = context.getBean("bean", DemoBean.class);
        System.out.println(demoBean1.getTitle());
        demoBean1.setTitle("А теперь эту строку");

        DemoBean demoBean2 = context.getBean("bean", DemoBean.class);
        System.out.println(demoBean2.getTitle());



        context.close();
    }
}
