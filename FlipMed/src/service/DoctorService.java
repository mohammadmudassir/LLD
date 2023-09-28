package service;

import model.BookingManagementSystem;
import model.Doctor;
import model.Slot;
import repository.DoctorRepo;

public class DoctorService {
    DoctorRepo docRepo;
    public DoctorService() {
        docRepo = new DoctorRepo();
    }

    public void addDoctor(Doctor doctor) {
        docRepo.addDoctor(doctor);
    }

    public void addSlot(String doctorId, String slot) {
        docRepo.addSlot(doctorId, slot);
    }

    public DoctorRepo getDocRepo() {
        return docRepo;
    }

}
