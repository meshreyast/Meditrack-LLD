package com.airtribe.meditrack.observers;

import com.airtribe.meditrack.Entity.Appointment;
import com.airtribe.meditrack.Interfaces.Observer;

public class SmsObserver implements Observer {
    @Override
    public void update(Appointment appointment) {
        System.out.println("SMS -> Your appointment with Dr." + appointment.getDoctor().getName()
            + " is " + appointment.getAppointmentStatus() + " on " + appointment.getAppointmentDate()
        );
    }
}
