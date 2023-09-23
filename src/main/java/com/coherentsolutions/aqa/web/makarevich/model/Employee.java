package com.coherentsolutions.aqa.web.makarevich.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Employee {
    private String name;
    private String position;
    private String office;
    private int age;
    private String start_date;
    private double salary;

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", position='" + position + '\'' +
                ", office='" + office + '\'' +
                ", age=" + age +
                ", start_date='" + start_date + '\'' +
                ", salary=" + salary +
                '}';
    }
}
