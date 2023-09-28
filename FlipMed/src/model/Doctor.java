package model;

import constant.Specialization;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Doctor {
    String id;
    String name;
    Specialization specialization;
    Map<String, Boolean> slots;

    public Doctor(String id, String name, Specialization specialization, List<String> slotList) {
        this.id = id;
        this.name = name;
        this.specialization = specialization;
        this.slots = new HashMap<>();
        for (String slot : slotList) {
            slots.put(slot, true);
        }
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Specialization getSpecialization() {
        return specialization;
    }

    public void setSpecialization(Specialization specialization) {
        this.specialization = specialization;
    }

    public Map<String, Boolean> getSlots() {
        return slots;
    }

    public void setSlots(Map<String, Boolean> slots) {
        this.slots = slots;
    }
}
