package com.airtribe.meditrack.test;

import com.airtribe.meditrack.Constants.AppointmentStatus;
import com.airtribe.meditrack.Constants.BillType;
import com.airtribe.meditrack.Constants.Specialization;
import com.airtribe.meditrack.Entity.Appointment;
import com.airtribe.meditrack.Entity.Bill;
import com.airtribe.meditrack.Entity.Doctor;
import com.airtribe.meditrack.Entity.Patient;
import com.airtribe.meditrack.Services.AppointmentService;
import com.airtribe.meditrack.Services.DoctorService;
import com.airtribe.meditrack.Services.PatientService;
import com.airtribe.meditrack.Utils.IdGenerator;
import com.airtribe.meditrack.factory.BillFactory;
import com.airtribe.meditrack.observers.EmailObserver;
import com.airtribe.meditrack.observers.SmsObserver;

public class TestRunner {
    public void test () {
        DoctorService ds = new DoctorService();

        Doctor doc = new Doctor(
                IdGenerator.getInstance().generateId(),
                "Shreyas",
                45,
                Specialization.CARDIOLOGY,
                1500
        );
        ds.addDoctor(doc);

        assert ds.searchDoctor(doc.getId()) != null;

        ds.deleteDoctor(doc.getId());

        assert ds.searchDoctor(doc.getId()) == null;

        PatientService ps = new PatientService();

        Patient p = new Patient(
                IdGenerator.getInstance().generateId(),
                "Alice",
                25,
                "Fever"
        );

        ps.addPatient(p);

        assert ps.searchPatient(p.getId()) != null;

        ps.deletePatient(p.getId());

        assert ps.searchPatient(p.getId()) == null;

        ps.searchPatient(1);

        ps.searchPatient("Alice", true);

        ps.searchPatient(25, true);

        AppointmentService as = new AppointmentService();

        Appointment ap = new Appointment(
                IdGenerator.getInstance().generateId(),
                doc,
                p,
                "2026-08-01"
        );

        as.createAppointment(ap);

        assert ap.getAppointmentStatus()
                == AppointmentStatus.CONFIRMED;

        as.cancelAppointment(ap.getId());

        assert ap.getAppointmentStatus()
                == AppointmentStatus.CANCELLED;

        Bill standard =
                BillFactory.create(BillType.STANDARD, ap);

        Bill senior =
                BillFactory.create(BillType.SENIOR, ap);
    }
}
