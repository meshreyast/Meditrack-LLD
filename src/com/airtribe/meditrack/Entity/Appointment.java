package com.airtribe.meditrack.Entity;

import com.airtribe.meditrack.Constants.AppointmentStatus;
import com.airtribe.meditrack.Interfaces.Observer;

import java.util.ArrayList;
import java.util.List;

public class Appointment extends MedicalEntity implements Cloneable {

    private Doctor doctor;
    private Patient patient;
    private String appointmentDate;
    private AppointmentStatus appointmentStatus;
    private List<Observer> observers;

    public Appointment(int appointmentId, Doctor doctor, Patient patient, String appointmentDate) {
        super(appointmentId);
        this.doctor = doctor;
        this.patient = patient;
        this.appointmentDate = appointmentDate;
        this.appointmentStatus = AppointmentStatus.PENDING;
        this.observers = new ArrayList<>();
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public Patient getPatient() {
        return patient;
    }

    public String getAppointmentDate() {
        return appointmentDate;
    }

    public AppointmentStatus getAppointmentStatus() {
        return appointmentStatus;
    }

    public void setAppointmentStatus(AppointmentStatus appointmentStatus) {
        this.appointmentStatus = appointmentStatus;
    }

    public void addObservers (Observer observer) {
        observers.add(observer);
    }

    public void removeAllObservers () {
        observers.clear();
    }

    @Override
    public void displayInfo() {
        System.out.println("Appointment of patient " + this.patient.getName() + ", has been set with doctor " + this.doctor.getName()
                + " on " + this.appointmentDate + " status is " + this.appointmentStatus);
    }

    @Override
    public Appointment clone() {
        try {
            // TODO: copy mutable state here, so the clone can't change the internals of the original
            return (Appointment) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }

    public void notifyAllObservers() {
        for (Observer obs: observers) {
            obs.update(this);
        }
    }
}
