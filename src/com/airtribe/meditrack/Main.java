package com.airtribe.meditrack;

import com.airtribe.meditrack.Constants.BillType;
import com.airtribe.meditrack.Constants.Specialization;
import com.airtribe.meditrack.Entity.*;
import com.airtribe.meditrack.Exceptions.AppointmentNotFoundException;
import com.airtribe.meditrack.Exceptions.InvalidDataException;
import com.airtribe.meditrack.Services.AppointmentService;
import com.airtribe.meditrack.Services.BillingService;
import com.airtribe.meditrack.Services.DoctorService;
import com.airtribe.meditrack.Services.PatientService;
import com.airtribe.meditrack.Utils.IdGenerator;
import com.airtribe.meditrack.factory.BillFactory;

import java.util.List;
import java.util.Scanner;

import static com.airtribe.meditrack.Utils.Validator.parseIntInput;
import static com.airtribe.meditrack.Utils.Validator.parseStringInput;

public class Main {

    static void main(String[] args) {
        System.out.println("Hello World!");

        DoctorService doctorService = new DoctorService();
        PatientService patientService = new PatientService();
        AppointmentService appointmentService = new AppointmentService();
        BillingService billingService = new BillingService();

        Scanner sc = new Scanner(System.in);
        int choice = 0;

        do {
            System.out.println("""
                    1. Add Doctor
                    2. View All Doctors
                    3. Delete Doctor
                    
                    4. Add Patient
                    5. View All Patients
                    6. Delete Patient
                    
                    7. Create Appointment
                    8. View All Appointments
                    9. Cancel Appointment
                    
                    10. Search Patient By ID
                    11. Search Patient By Name
                    12. Search Patient By Age
                    
                    13. Search Doctor By ID
                    14. Search Doctor By Name
                    15. Search Doctor By Specialization
                    
                    16. Generate Bill
                    17. View Bill Summary
                    18. Search all patients by name
                    19. Exit""");
            System.out.println("Choice: ");
            try {
                choice = parseIntInput(sc.nextLine(), "Choice");
            } catch (InvalidDataException e) {
                System.out.println(e.getMessage() + " Try again");
                continue;
            }
            try {
                switch (choice) {
                    case 1:
                        System.out.println("Enter Doctor's name: ");
                        String doctorName = parseStringInput(sc.nextLine(), "Name");
                        System.out.println("Enter Doctor's age: ");
                        int doctorAge = parseIntInput(sc.nextLine(), "Age");
                        System.out.println("Enter Doctor's fees: ");
                        double fees = parseIntInput(sc.nextLine(), "Fees");
                        System.out.println("Select Doctor's specialization: ");
                        int counter = 1;
                        for (Specialization sp: Specialization.values()) {
                            System.out.println(counter++ + ". " + sp);
                        }
                        int specializationChoice;
                        try {
                            specializationChoice = parseIntInput(sc.nextLine(), "Specialization");
                        } catch (InvalidDataException e) {
                            System.out.println(e.getMessage() + "Try again");
                            continue;
                        }
                        Specialization specialization = Specialization.fromChoice(specializationChoice);

                        doctorService.addDoctor(new Doctor(IdGenerator.getInstance().generateId(), doctorName, doctorAge,
                                specialization, fees));
                        System.out.println("Doctor " + doctorName + " added");
                        break;
                    case 2:
                        List<Doctor> doctorsList = doctorService.getAllDoctors();
                        if (doctorsList.isEmpty()) {
                            System.out.println("No doctors found");
                        } else {
                            for (Doctor i: doctorsList) {
                                i.displayInfo();
                            }
                        }
                        break;
                    case 3:
                        System.out.println("Enter Doctor's id to delete: ");
                        int searchId;
                        try {
                            searchId = parseIntInput(sc.nextLine(), "Doctor id");
                        } catch (InvalidDataException e) {
                            System.out.println(e.getMessage() + " Try again");
                            break;
                        }

                        doctorService.deleteDoctor(searchId);
                        System.out.println("Doctor deleted");
                        break;
                    case 4:
                        System.out.println("Enter patient's name: ");
                        String patientName = parseStringInput(sc.nextLine(), "Name");
                        System.out.println("Enter patient's age: ");
                        int patientAge = parseIntInput(sc.nextLine(), "Age");
                        System.out.println("Describe patient's symptoms: ");
                        String symptoms = parseStringInput(sc.nextLine(), "Symptoms");

                        patientService.addPatient(new Patient(IdGenerator.getInstance().generateId(), patientName, patientAge, symptoms));
                        System.out.println("Patient " + patientName + " added");
                        break;
                    case 5:
                        List<Patient> patientsList = patientService.getAllPatient();
                        if (patientsList.isEmpty()) {
                            System.out.println("No patients found");
                        } else {
                            for (Patient i: patientsList) {
                                i.displayInfo();
                            }
                        }
                        break;
                    case 6:
                        System.out.println("Enter patient's id to delete: ");
                        int patientId;
                        try {
                            patientId = parseIntInput(sc.nextLine(), "Patient id");
                        } catch (InvalidDataException e) {
                            System.out.println(e.getMessage() + " Try again");
                            break;
                        }

                        patientService.deletePatient(patientId);
                        System.out.println("Patient deleted");
                        break;
                    case 7:
                        System.out.println("Create an appointment: ");
                        System.out.println("Enter Doctor's id to set and appointment: ");
                        int doctorApId;
                        try {
                            doctorApId = parseIntInput(sc.nextLine(), "Doctor id");
                        } catch (InvalidDataException e) {
                            System.out.println(e.getMessage() + " Try again");
                            break;
                        }
                        System.out.println("Enter Patient's id to set and appointment: ");
                        int patientApId;
                        try {
                            patientApId = parseIntInput(sc.nextLine(), "Patient id");
                        } catch (InvalidDataException e) {
                            System.out.println(e.getMessage() + " Try again");
                            break;
                        }
                        System.out.println("Enter appointment date:");
                        String date = parseStringInput(sc.nextLine(), "Appointment date ");
                        appointmentService.createAppointment(
                                new Appointment(
                                        IdGenerator.getInstance().generateId(),
                                        doctorService.searchDoctor(doctorApId),
                                        patientService.searchPatient(patientApId),
                                        date
                                )
                        );
                        break;
                    case 8:
                        List<Appointment> appointmentList = appointmentService.getAllAppointments();
                        if (appointmentList.isEmpty()) {
                            throw new AppointmentNotFoundException("No appointments found");
                        } else {
                            for (Appointment i: appointmentList) {
                                i.displayInfo();
                            }
                        }
                        break;
                    case 9:
                        System.out.println("Enter appointment id to cancel: ");
                        int appointmentId;
                        try {
                            appointmentId = parseIntInput(sc.nextLine(), "Appointment id");
                        } catch (InvalidDataException e) {
                            System.out.println(e.getMessage() + " Try again");
                            break;
                        }

                        appointmentService.cancelAppointment(appointmentId);
                        System.out.println("Appointment canceled");
                        break;
                    case 10:
                        System.out.println("Enter the patient's id to be searched: ");
                        int searchPatientById;
                        try {
                            searchPatientById = parseIntInput(sc.nextLine(), "Patient id");
                        } catch (InvalidDataException e) {
                            System.out.println(e.getMessage() + " Try again");
                            break;
                        }
                        patientService.searchPatient(searchPatientById).displayInfo();
                        break;
                    case 11:
                        System.out.println("Enter the patient's name to be searched: ");
                        String searchPatientByName;
                        try {
                            searchPatientByName = parseStringInput(sc.nextLine(), "Patient name");
                        } catch (InvalidDataException e) {
                            System.out.println(e.getMessage() + " Try again");
                            break;
                        }
                        Patient patientByName = patientService.searchPatient(searchPatientByName, true);
                        if (patientByName != null) {
                            patientByName.displayInfo();
                        } else {
                            System.out.println("No patient by the name " + searchPatientByName + " found");
                        }
                        break;
                    case 12:
                        System.out.println("Enter the patient's age to be searched: ");
                        int searchPatientByAge;
                        try {
                            searchPatientByAge = parseIntInput(sc.nextLine(), "Patient name");
                        } catch (InvalidDataException e) {
                            System.out.println(e.getMessage() + " Try again");
                            break;
                        }
                        Patient patientByAge = patientService.searchPatient(searchPatientByAge, true);
                        if (patientByAge != null) {
                            patientByAge.displayInfo();
                        } else {
                            System.out.println("No patient by the name " + searchPatientByAge + " found");
                        }
                        break;
                    case 13:
                        System.out.println("Enter the doctor's id to be searched: ");
                        int searchDoctorById;
                        try {
                            searchDoctorById = parseIntInput(sc.nextLine(), "Doctor id");
                        } catch (InvalidDataException e) {
                            System.out.println(e.getMessage() + " Try again");
                            break;
                        }
                        Doctor idDoc = doctorService.searchDoctor(searchDoctorById);
                        if (idDoc != null) {
                            idDoc.displayInfo();
                        } else {
                            System.out.println("No Doctor by the name " + searchDoctorById + " found");
                        }
                        break;
                    case 14:
                        System.out.println("Enter the doctor's name to be searched: ");
                        String searchDoctorByName = "";
                        try {
                            searchDoctorByName = parseStringInput(sc.nextLine(), "Doctor name");
                        } catch (InvalidDataException e) {
                            System.out.println(e.getMessage() + " Try again");
                            break;
                        }
                        Doctor doc = doctorService.searchDoctor(searchDoctorByName, true);
                        if (doc != null) {
                            doc.displayInfo();
                        } else {
                            System.out.println("No Doctor by the name " + searchDoctorByName + " found");
                        }
                        break;
                    case 15:
                        System.out.println("Enter the specialization to search by: ");
                        int spCounter = 1;
                        for (Specialization sp: Specialization.values()) {
                            System.out.println(spCounter++ + ". " + sp);
                        }
                        int specializationSearchChoice;
                        try {
                            specializationSearchChoice = parseIntInput(sc.nextLine(), "Specialization");
                        } catch (InvalidDataException e) {
                            System.out.println(e.getMessage() + "Try again");
                            continue;
                        }
                        Specialization specializationSearchRes = Specialization.fromChoice(specializationSearchChoice);
                        Doctor spDoc = doctorService.searchDoctor(specializationSearchRes, true);
                        if (spDoc != null) {
                            spDoc.displayInfo();
                        } else {
                            System.out.println("No Doctor ith the specialization " + specializationSearchRes + " found");
                        }
                        break;
                    case 16:
                        System.out.println("Enter appointment id to get bill: ");
                        int apId = 0;
                        try {
                            apId = parseIntInput(sc.nextLine(), "Appointment id");
                        } catch (InvalidDataException e) {
                            System.out.println("Try again.");
                        }
                        Appointment ap = appointmentService.searchAppointment(apId);
                        Bill bill = BillFactory.create(
                                ap.getPatient().getAge() >= 60
                                ? BillType.SENIOR : BillType.STANDARD,
                                ap
                        );
                        billingService.addBill(bill);
                        System.out.println("Bill successfully created");
                        break;
                    case 17:
                        System.out.println("Enter bill id to get summary");
                        int billId = 0;
                        try {
                            billId = parseIntInput(sc.nextLine(), "Bill id");
                        } catch (InvalidDataException e) {
                            System.out.println("Try again.");
                        }
                        Bill summaryForBill = billingService.getBillById(billId);
                        BillSummary billSummary = BillSummary.getInstance();
                        billSummary.getBillSummary(summaryForBill);
                        break;
                    case 18:
                        System.out.println("search all patients by name: ");
                        String patientSearchName = parseStringInput(sc.nextLine(), "Name");
                        List<Patient> patients = patientService.searchAllPatientsByName(patientSearchName);
                        for (Patient searchedPatients: patients) {
                            System.out.println(searchedPatients.getName() + " " + searchedPatients.getAge());
                        }
                        break;
                    case 19:
                        System.out.println("Bye!");
                        break;
                    default:
                        System.out.println("Wrong input. Try again");
                        break;
                }
            } catch (Exception e) {
                System.out.println("Something went wrong: " + e.getMessage());
            }
        } while (choice != 18);
    }
}