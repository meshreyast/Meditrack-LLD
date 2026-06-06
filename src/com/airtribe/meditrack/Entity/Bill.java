package com.airtribe.meditrack.Entity;

import com.airtribe.meditrack.Interfaces.Payable;

public class Bill extends MedicalEntity implements Payable {

    private Appointment appointment;
    private double amount;

    public Bill(int id, Appointment appointment) {
        super(id);
        this.appointment = appointment;
        this.amount = appointment.getDoctor().getFees();
    }

    public Appointment getAppointment() {
        return appointment;
    }

    public double getAmount() {
        return amount;
    }

    @Override
    public double calculateTax(double amount) {
        return Payable.super.calculateTax(amount);
    }

    public double calculateAmount() {
        return calculateTax(this.amount);
    }

    @Override
    public void displayInfo() {
        System.out.println("Bill generated for appointment.");
    }
}
