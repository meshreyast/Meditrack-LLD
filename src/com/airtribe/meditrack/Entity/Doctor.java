package com.airtribe.meditrack.Entity;

import com.airtribe.meditrack.Constants.Specialization;

public class Doctor extends Person {
    private Specialization specialization;
    private double fees;

    public Doctor(int id, String name, int age, Specialization specialization, double fees) {
        super(id, name, age);
        this.specialization = specialization;
        this.fees = fees;
    }

    public Specialization getSpecialization() {
        return specialization;
    }

    public double getFees() {
        return fees;
    }

    @Override
    public void displayInfo() {
        System.out.println("Dr. " + this.getName() +  " " + this.getAge()
                + " has a specialization of " + this.specialization + " and charges " + this.fees);
    }
}
