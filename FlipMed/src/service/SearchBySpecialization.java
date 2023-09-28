package service;

import constant.Specialization;
import model.Doctor;
import repository.DoctorRepo;

import javax.print.Doc;
import java.util.List;
import java.util.Map;

public class SearchBySpecialization implements Search{
    DoctorRepo doctorRepo;
    public SearchBySpecialization(DoctorRepo doctorRepo) {
        this.doctorRepo = doctorRepo;
    }
    @Override
    public void display() {
        Map<Specialization, List<Doctor>> spDocList = doctorRepo.getSpecializationDocList();
        for (Map.Entry<Specialization, List<Doctor>> entry : spDocList.entrySet()) {
            System.out.println("Specialization : " + entry.getKey().getDisplayName());
            System.out.println("================");
            for (Doctor doc : entry.getValue()) {
                System.out.println("Name : " + doc.getName());
            }
            System.out.println("=======================================================");
        }
    }
}
