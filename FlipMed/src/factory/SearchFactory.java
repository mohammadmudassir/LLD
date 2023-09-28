package factory;

import Utility.EnumUtil;
import constant.Specialization;
import repository.DoctorRepo;
import service.Search;
import service.SearchByNameSort;
import service.SearchBySpecialization;

import java.lang.annotation.IncompleteAnnotationException;

public class SearchFactory {

    DoctorRepo doctorRepo;

    public SearchFactory(DoctorRepo doctorRepo) {
        this.doctorRepo = doctorRepo;
    }

    public Search getSearch(String searchType) {

        switch (searchType) {
            case "specialization":
                return new SearchBySpecialization(doctorRepo);
            case "byName":
                return new SearchByNameSort(doctorRepo);
            default:
                System.out.println("Not implemented !!");
                throw new RuntimeException();
        }
    }
}
