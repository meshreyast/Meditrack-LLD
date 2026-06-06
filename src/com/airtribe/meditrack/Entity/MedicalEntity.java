package com.airtribe.meditrack.Entity;

public abstract class MedicalEntity {
    protected int id;

    MedicalEntity (int id) {
        this.id = id;
    }

    public int getId() {
        return this.id;
    }

    public abstract void displayInfo();
}
