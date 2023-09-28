package Utility;

import constant.Specialization;

public class EnumUtil {
    public Specialization mapSpecialization(String specialization) {
        switch (specialization.toLowerCase()) {
            case "ortho":
                return Specialization.ORTHO;
            case "cardio":
                return Specialization.CARDIO;
            case "derma":
                return Specialization.DERMA;
            case "gp":
                return Specialization.GP;
            default:
                throw new IllegalArgumentException("Invalid specialization : " + specialization);
        }
    }
}
