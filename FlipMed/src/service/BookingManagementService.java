package service;

import model.BookingManagementSystem;
import model.Slot;
import repository.BookingManagementRepo;


public class BookingManagementService {
    DoctorService doctorService;
    PatientService patientService;
    BookingManagementRepo bookingManagementRepo;
    public BookingManagementService(DoctorService doctorService, PatientService patientService) {
        this.doctorService = doctorService;
        this.patientService = patientService;
        this.bookingManagementRepo = new BookingManagementRepo(doctorService.docRepo, patientService.patRepo);
    }

    public void bookAppointment(String docId, String patId, String slot) {
        bookingManagementRepo.bookAppointment(docId, patId, slot);
    }



}
