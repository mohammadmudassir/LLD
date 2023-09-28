package model;

import java.util.UUID;

public class Appointment {
    String id;
    Doctor doctor;
    Patient patient;
    String slot;

    public Appointment(Doctor doctor, Patient patient, String slot) {
        this.doctor = doctor;
        this.patient = patient;
        this.slot = slot;
        UUID uuid = UUID.randomUUID();
        this.id = uuid.toString();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public String getSlot() {
        return slot;
    }

    public void setSlot(String slot) {
        this.slot = slot;
    }
}
