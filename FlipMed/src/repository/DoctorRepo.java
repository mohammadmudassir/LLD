package repository;

import Utility.EnumUtil;
import constant.Specialization;
import model.BookingManagementSystem;
import model.Doctor;
import model.Slot;

import java.util.*;

public class DoctorRepo {
    Map<String, Doctor> doctors;
    Map<Specialization, List<Doctor>> specializationDocList;
    public DoctorRepo() {
        this.doctors = new HashMap<>();
        this.specializationDocList = new HashMap<>();
    }

    public void addDoctor(Doctor doctor) {

        if (doctors.containsKey(doctor.getId())) {
            System.out.println("Doctor Already Exists !!");
        }
        else {
            doctors.put(doctor.getId(), doctor);
            EnumUtil eu = new EnumUtil();
            List<Doctor> doctorList = specializationDocList.getOrDefault(doctor.getSpecialization(), new ArrayList<>());
            doctorList.add(doctor);
            specializationDocList.put(doctor.getSpecialization(), doctorList);
            System.out.println("Doctor Added Successfully !!");

        }
    }

    public void addSlot(String doctorId, String slot) {
        doctors.get(doctorId).getSlots().put(slot, true);
    }

    public boolean isSlotAvail(String docId, String slot) {
        if (!doctors.get(docId).getSlots().containsKey(slot)) {
            System.out.println("Invalid Slot !!");
            return false;
        }
        return doctors.get(docId).getSlots().get(slot);
    }

    public void markSlotBook(String docId, String slot) {
        doctors.get(docId).getSlots().put(slot, false);
    }

    public Map<Specialization, List<Doctor>> getSpecializationDocList() {
        return specializationDocList;
    }

    public Map<String, Doctor> getDoctors() {
        return doctors;
    }
}
