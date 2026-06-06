package com.airtribe.meditrack.Services;

import com.airtribe.meditrack.Constants.Specialization;
import com.airtribe.meditrack.Entity.Doctor;
import com.airtribe.meditrack.Interfaces.Searchable;
import com.airtribe.meditrack.Utils.DataStore;

import java.util.List;
import java.util.Objects;

public class DoctorService implements Searchable<Doctor> {

    private DataStore<Doctor> doctors = new DataStore<>();

    public void addDoctor (Doctor newDoc) { doctors.add(newDoc); }

    public List<Doctor> getAllDoctors () {
        return doctors.getAll();
    }

    public void deleteDoctor (int id) {
        Doctor doc = searchById(id);
        doctors.remove(doc);
    }

    public Doctor searchDoctor(int id) {
        return searchById(id);
    }

    public Doctor searchDoctor(String name, boolean byName) {

        for (Doctor d: doctors.getAll()) {
            if (Objects.equals(d.getName(), name)) {
                return d;
            }
        }
        return null;
    }

    public Doctor searchDoctor(Specialization sp, boolean bySpecialization) {

        for (Doctor d: doctors.getAll()) {
            if (Objects.equals(d.getSpecialization(), sp)) {
                return d;
            }
        }
        return null;
    }

    @Override
    public Doctor searchById(int id) {
        for (Doctor d: doctors.getAll()) {
            if (d.getId() == id) {
                return d;
            }
        }
        return null;
    }
}
