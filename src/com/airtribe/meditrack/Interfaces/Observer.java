package com.airtribe.meditrack.Interfaces;

import com.airtribe.meditrack.Entity.Appointment;

public interface Observer {
    void update(Appointment appointment);
}
