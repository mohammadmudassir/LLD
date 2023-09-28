package service;

import model.Doctor;
import repository.DoctorRepo;

import java.util.*;

public class SearchByNameSort implements Search{

    DoctorRepo doctorRepo;
    public SearchByNameSort(DoctorRepo doctorRepo) {
        this.doctorRepo = doctorRepo;
    }

    @Override
    public void display() {
        Map<String, Doctor> doctors = doctorRepo.getDoctors();
        List<Doctor> doctorList = new ArrayList<>();
        for (Map.Entry<String, Doctor> entry : doctors.entrySet()) {
            doctorList.add(entry.getValue());
        }
        Collections.sort(doctorList, (d1, d2) -> {
            boolean equals = d1.getName().equals(d2.getName());
            return equals == true ? 1 : -1;
        });

        for (Doctor doc : doctorList) {
            System.out.println("Name : " + doc.getName() + " , Specialization : " + doc.getSpecialization().getDisplayName());
        }
    }
}
