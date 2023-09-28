import Utility.EnumUtil;
import constant.Specialization;
import factory.SearchFactory;
import model.BookingManagementSystem;
import model.Doctor;
import model.Patient;
import model.Slot;
import service.BookingManagementService;
import service.DoctorService;
import service.PatientService;
import service.Search;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Driver {
    public static void main(String [] args) {

        DoctorService ds = new DoctorService();
        PatientService ps = new PatientService();
        BookingManagementService bms = new BookingManagementService(ds, ps);
        EnumUtil eu = new EnumUtil();
        Scanner sc = new Scanner(System.in);

        System.out.println("Welcome to FlipMed !!");

        while (true) {

            String command = sc.nextLine();
            String [] commands = command.split(" ");

            switch (commands[0]) {
                case "add_doctor":
                    String id = commands[1];
                    String name = commands[2];
                    String specialization = commands[3];
                    String slot = commands[4];
                    String [] slots = slot.split(",");
                    List<String> slotList = new ArrayList<>();
                    for (String splitSlot : slots) {
                        slotList.add(splitSlot);
                    }
                    Specialization sp = eu.mapSpecialization(specialization);
                    ds.addDoctor(new Doctor(id, name, sp, slotList));
                    break;
                case "add_patient":
                    String pid = commands[1];
                    String pname = commands[2];
                    ps.addPatient(new Patient(pid, pname));
                    break;
                case "book_appointment":
                    String doctorId = commands[1];
                    String patientId = commands[2];
                    String bookingSlot = commands[3];
                    bms.bookAppointment(doctorId, patientId, bookingSlot);
                    break;
                case "search":
                    String searchType = commands[1];
                    SearchFactory sf = new SearchFactory(ds.getDocRepo());
                    Search find = sf.getSearch(searchType);
                    find.display();
                    break;
                case "exit":
                    return;
            }

        }


    }
}
