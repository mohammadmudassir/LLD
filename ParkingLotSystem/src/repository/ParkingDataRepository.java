package repository;

import entity.ParkingFloor;
import entity.ParkingLot;
import entity.ParkingSlot;
import entity.Vehicle;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class ParkingDataRepository {

    List<ParkingSlot> parkingSlots;
    List<ParkingFloor> parkingFloors;
    HashMap<String, Vehicle> vehicleHashMap;
    ParkingLot parkingLot;

    public void createParkingLot(String plid, int numFloor, int numSlPerFl) {
        vehicleHashMap = new HashMap<>();
        parkingLot = new ParkingLot(plid, numFloor, numSlPerFl);
        parkingFloors = new ArrayList<>(parkingLot.getParkingFloors());
        for (int i = 0; i < parkingLot.getNoOfFloor(); i++) {
            parkingSlots = new ArrayList<>(parkingLot.getNoOfSlotsPerFloor());
            for (int j = 0; j < parkingLot.getNoOfSlotsPerFloor(); j++) {
                String type = "CAR";
                if (j < 1) {
                    type = "TRUCK";
                }
                else if (j < 3) {
                    type = "BIKE";
                }
                ParkingSlot psl = new ParkingSlot(j, type, true);
                parkingSlots.add(psl);
            }
            int currFloorId = i;
            parkingSlots.forEach(psl -> psl.setFloorId(currFloorId));
            ParkingFloor pfl = new ParkingFloor(i, parkingSlots);
            parkingFloors.add(pfl);
        }
        parkingLot.setParkingFloors(parkingFloors);
        System.out.println("Parking Lot is created !!");
    }

    public ParkingSlot getFirstAvailableSlot(String vehicleType) {
        for (ParkingFloor fl : parkingLot.getParkingFloors()) {
            for (ParkingSlot sl : fl.getParkingSlots()) {
                if (sl.getSlotType().equals(vehicleType) && sl.isFree()) {
                    return sl;
                }
            }
        }
        return null;
    }

    public String generateTicket(ParkingSlot psl) {
        return parkingLot.getParkingLotId() + "_" + (psl.getFloorId() + 1) + "_" + (psl.getSlotId() + 1);
    }

    public void parkVehicle(String vehicleType, String regNumber, String color) {
        ParkingSlot psl = getFirstAvailableSlot(vehicleType);
        if (psl == null) {
            System.out.println("Parking Lot is Full !!");
        }
        else {
            psl.setFree(false);
            Vehicle vehicle = new Vehicle(vehicleType, psl, color, regNumber);
            psl.setVehicle(vehicle);
            String ticketId = generateTicket(psl);
            vehicle.setTicketId(ticketId);
            vehicleHashMap.put(ticketId, vehicle);
            System.out.println("Parked Vehicle. Ticket Id : " + ticketId);
        }
    }

    public void unParkVehicle(String ticketId) {
        if (!vehicleHashMap.containsKey(ticketId)) {
            System.out.println("Invalid Ticket !!");
        }
        else {
            Vehicle vehicle = vehicleHashMap.get(ticketId);
            vehicleHashMap.remove(ticketId);
            ParkingSlot psl = vehicle.getParkingSlot();
            parkingLot.getParkingFloors().get(psl.getFloorId()).getParkingSlots().get(psl.getSlotId()).setFree(true);
            System.out.println("Unparked Vehicle with Registration number : " + vehicle.getVehicleRegisterNo() + " and color : " + vehicle.getColor());
        }
    }

    public void display(String displayType, String vehicleType) {
        if (displayType.equals("free_count")) {
            displayFreeCount(vehicleType);
        }
        else if(displayType.equals("free_slots")) {
            displayFreeSlots(vehicleType);
        }
        else if(displayType.equals("occupied_slots")){
            displayOccupiedSlot(vehicleType);
        }
        else {
            System.out.println("Invalid display type!!");
        }
    }

    public void displayFreeCount(String vehicleType) {
         for (ParkingFloor pfl : parkingLot.getParkingFloors()) {
             long currFloorCount = pfl.getParkingSlots()
                     .stream()
                     .filter(psl -> psl.getSlotType().equals(vehicleType))
                     .filter(psl -> psl.isFree() == true)
                     .count();
             System.out.println("No. of slots for " + vehicleType + " on floor " + (pfl.getFloorId() + 1) + " : " + currFloorCount);
         }
    }

    public void displayFreeSlots(String vehicleType) {
        for (ParkingFloor pfl : parkingLot.getParkingFloors()) {
            List<ParkingSlot> collectedSlots = pfl.getParkingSlots()
                    .stream()
                    .filter(psl -> psl.getSlotType().equals(vehicleType))
                    .filter(psl -> psl.isFree() == true)
                    .collect(Collectors.toList());

            StringBuilder sb = new StringBuilder("Free Slots for " + vehicleType + " on floor " + (pfl.getFloorId() + 1) + " : ");
            for (ParkingSlot slot : collectedSlots) {
                sb.append((slot.getSlotId() + 1) + ",");
            }
            sb.setLength(sb.length() - 1);
            System.out.println(sb.toString());
        }
    }

    public void displayOccupiedSlot(String vehicleType) {
        for (ParkingFloor pfl : parkingLot.getParkingFloors()) {
            List<ParkingSlot> collectedSlots = pfl.getParkingSlots()
                    .stream()
                    .filter(psl -> psl.getSlotType().equals(vehicleType))
                    .filter(psl -> psl.isFree() == false)
                    .collect(Collectors.toList());

            StringBuilder sb = new StringBuilder("Occupied Slots for " + vehicleType + " on floor " + (pfl.getFloorId() + 1) + " : ");
            for (ParkingSlot slot : collectedSlots) {
                sb.append((slot.getSlotId() + 1) + ",");
            }
            sb.setLength(sb.length() - 1);
            System.out.println(sb.toString());
        }
    }



}
