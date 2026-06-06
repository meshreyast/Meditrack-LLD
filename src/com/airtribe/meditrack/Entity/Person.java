package com.airtribe.meditrack.Entity;

import com.airtribe.meditrack.Exceptions.InvalidDataException;

import java.util.Objects;

public class Person extends MedicalEntity {

    private String name;
    private int age;

    public Person(int id, String name, int age) {
        super(id);
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public void displayInfo() {
        System.out.println( "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}');
    }
}
