package ru.geekbrains.Lesson2.TEST;


import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component (value = "bean")
public class DemoBean {
    private String title;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @PostConstruct
    public void init(){
        title = "Прочитай эту строку";
    }
}
