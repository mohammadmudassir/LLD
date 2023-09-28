package repository;

import model.BookingManagementSystem;
import model.Patient;

import java.util.HashMap;
import java.util.Map;

public class PatientRepo {
    Map<String, Patient> patients;

    public PatientRepo() {
        this.patients = new HashMap<>();
    }

    public void addPatient(Patient patient) {

        if (patients.containsKey(patient.getId())) {
            System.out.println("Patient Already Exists !!");
        }
        else {
            patients.put(patient.getId(), patient);
            System.out.println("Patient Added Successfully !!");
        }
    }

}
