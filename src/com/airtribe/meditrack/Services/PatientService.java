package com.airtribe.meditrack.Services;

import com.airtribe.meditrack.Entity.Patient;
import com.airtribe.meditrack.Interfaces.Searchable;
import com.airtribe.meditrack.Utils.DataStore;

import java.util.*;

public class PatientService implements Searchable<Patient> {

    private DataStore<Patient> patients = new DataStore<>();

    public void addPatient (Patient newPatient) {
        patients.add(newPatient);
    }

    public void deletePatient (int id) {
        Patient p = searchById(id);
        patients.remove(p);
    }

    public List<Patient> getAllPatient () {
        return patients.getAll();
    }

    public Patient searchPatient(int id) {
        return searchById(id);
    }

    public Patient searchPatient(int age, boolean byAge) {

        for (Patient p: patients.getAll()) {
            if (Objects.equals(p.getAge(), age)) {
                return p;
            }
        }
        return null;
    }

    public Patient searchPatient(String name, boolean byName) {
        List<Patient> allPatients = patients.getAll();

        for (Patient p: allPatients) {
            if (Objects.equals(p.getName(), name)) {
                return p;
            }
        }
        return null;
    }

    @Override
    public Patient searchById(int id) {
        for (Patient p: patients.getAll()) {
            if (p.getId() == id) {
                return p;
            }
        }
        return null;
    }

    public List<Patient> searchAllPatientsByName(String name) {

        return patients.getAll()
                .stream()
                .filter(p -> p.getName().equalsIgnoreCase(name))
                .toList();
    }
}
