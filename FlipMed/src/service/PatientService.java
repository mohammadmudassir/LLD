package service;

import model.BookingManagementSystem;
import model.Patient;
import repository.PatientRepo;

public class PatientService {

    PatientRepo patRepo;

    public PatientService() {
        patRepo = new PatientRepo();
    }

    public void addPatient(Patient patient) {
        patRepo.addPatient(patient);
    }
}
