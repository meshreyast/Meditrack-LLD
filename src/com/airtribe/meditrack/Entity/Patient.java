package com.airtribe.meditrack.Entity;


public class Patient extends Person implements Cloneable{

    private String symptoms;

    public Patient(int id, String name, int age, String symptoms) {
        super(id, name, age);
        this.symptoms = symptoms;
    }

    @Override
    public void displayInfo() {
        System.out.println("Patient " + this.getName() + " of age " + this.getAge() + " has " + this.symptoms + " symptoms");
    }

    @Override
    public Patient clone() {
        try {
            // TODO: copy mutable state here, so the clone can't change the internals of the original
            return (Patient) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
}
