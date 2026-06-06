package com.airtribe.meditrack.observers;

import com.airtribe.meditrack.Entity.Appointment;
import com.airtribe.meditrack.Interfaces.Observer;

public class EmailObserver implements Observer {
    @Override
    public void update(Appointment appointment) {
        System.out.println("Email -> Your appointment with Dr." + appointment.getDoctor().getName()
                + " is " + appointment.getAppointmentStatus() + " on " + appointment.getAppointmentDate()
        );
    }
}
