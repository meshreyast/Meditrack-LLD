package com.airtribe.meditrack.Services;

import com.airtribe.meditrack.Constants.AppointmentStatus;
import com.airtribe.meditrack.Entity.Appointment;
import com.airtribe.meditrack.Interfaces.Searchable;
import com.airtribe.meditrack.Utils.DataStore;
import com.airtribe.meditrack.observers.EmailObserver;
import com.airtribe.meditrack.observers.SmsObserver;

import java.util.List;

public class AppointmentService implements Searchable<Appointment> {
    private DataStore<Appointment> appointments = new DataStore<>();

    public void createAppointment (Appointment ap) {
        appointments.add(ap);
        ap.setAppointmentStatus(AppointmentStatus.CONFIRMED);
        ap.addObservers(new SmsObserver());
        ap.addObservers(new EmailObserver());
        ap.notifyAllObservers();
    }

    public List<Appointment> getAllAppointments () {
        return appointments.getAll();
    }

    public void cancelAppointment (int id) {
        Appointment ap = searchById(id);
        assert ap != null;
        ap.setAppointmentStatus(AppointmentStatus.CANCELLED);
        ap.notifyAllObservers();
        ap.removeAllObservers();
        appointments.remove(ap);
    }

    @Override
    public Appointment searchById(int id) {
        for (Appointment ap: appointments.getAll()) {
            if (ap.getId() == id) {
                return ap;
            }
        }
        return null;
    }

    public Appointment searchAppointment (int id) {
        return searchById(id);
    }
}
