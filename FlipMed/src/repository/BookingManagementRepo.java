package repository;

import model.*;

import java.util.*;

public class BookingManagementRepo {
    Map<String, List<Appointment>> docApp;
    Map<String, List<Appointment>> patApp;
    DoctorRepo docRepo;
    PatientRepo patRepo;
    public BookingManagementRepo(DoctorRepo docRepo, PatientRepo patRepo) {
        docApp = new HashMap<>();
        patApp = new HashMap<>();
        this.docRepo = docRepo;
        this.patRepo = patRepo;
    }

    public void bookAppointment(String docId, String patId, String slot) {
        Doctor doc = docRepo.doctors.get(docId);
        if (doc == null) {
            System.out.println("Invalid doctor !!");
            return;
        }
        Patient pat = patRepo.patients.get(patId);
        if (pat == null) {
            System.out.println("Invalid patient !!");
            return;
        }
        if (docRepo.isSlotAvail(docId, slot)) {
            docRepo.markSlotBook(docId, slot);
            Appointment apt = new Appointment(doc, pat, slot);
            List<Appointment> docAptList = docApp.getOrDefault(doc.getId(), new ArrayList<>());
            docAptList.add(apt);
            docApp.put(doc.getId(), docAptList);
            List<Appointment> patAppList = patApp.getOrDefault(pat.getId(), new ArrayList<>());
            patAppList.add(apt);
            patApp.put(pat.getId(), patAppList);
            System.out.println("Slot Booked Successfully, Appointment id : " + apt.getId());
        }
        else {
            System.out.println("Slot is not available");
        }
    }

}
