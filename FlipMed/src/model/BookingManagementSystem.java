package model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BookingManagementSystem {

    private static BookingManagementSystem bookingManagementSystem;
    Map<String, Patient> patients;
    Map<String, Doctor> doctors;

    Map<String, Map<Slot, List<String>>> waitList;

    private BookingManagementSystem() {
        patients = new HashMap<>();
        doctors = new HashMap<>();

        waitList = new HashMap<>();
    }

    public static BookingManagementSystem getBookingManagementSystem() {
        if (bookingManagementSystem == null) {
            bookingManagementSystem = new BookingManagementSystem();
        }
        return bookingManagementSystem;
    }

    public Map<String, Patient> getPatients() {
        return patients;
    }

    public void setPatients(Map<String, Patient> patients) {
        this.patients = patients;
    }

    public Map<String, Doctor> getDoctors() {
        return doctors;
    }

    public void setDoctors(Map<String, Doctor> doctors) {
        this.doctors = doctors;
    }


    public Map<String, Map<Slot, List<String>>> getWaitList() {
        return waitList;
    }

    public void setWaitList(Map<String, Map<Slot, List<String>>> waitList) {
        this.waitList = waitList;
    }
}
