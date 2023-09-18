package repository;

import entity.ParkingFloor;
import entity.ParkingSlot;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TestCode {

    public static void main(String [] args) {
        ParkingDataRepository pdr = new ParkingDataRepository();

//        for (ParkingFloor fl : pdr.parkingLot.getParkingFloors()) {
//            for (ParkingSlot sl : fl.getParkingSlots()) {
//                System.out.println("floor id : " + (fl.getFloorId() + 1) + " - Slot id : " + (sl.getSlotId() + 1) + " - Slot Type : " + (sl.getSlotType() + 1));
//            }
//        }

        System.out.println("Welcome to parking lot application !!");

        Scanner scanner = new Scanner(System.in);

        while (true) {

            String command = scanner.nextLine();
            String tokens[] = command.split(" ");
            String commandType = tokens[0];

            switch (commandType) {
                case "create_parking_lot":
                    String parkingLotId = tokens[1];
                    int numFloors = Integer.parseInt(tokens[2]);
                    int slotsPerFloor = Integer.parseInt(tokens[3]);
                    pdr.createParkingLot(parkingLotId, numFloors, slotsPerFloor);
                    break;
                case "park_vehicle":
                    String vehicleType= tokens[1];
                    String regNumber = tokens[2];
                    String color = tokens[3];
                    pdr.parkVehicle(vehicleType, regNumber, color);
                    break;
                case "unpark_vehicle":
                    String ticketId = tokens[1];
                    pdr.unParkVehicle(ticketId);
                    break;
                case "display":
                    String displayType = tokens[1];
                    String vType = tokens[2];
                    pdr.display(displayType, vType);
                    break;
                case "exit" :
                    return;
                default:
                    System.out.println("Invalid Command !!");
            }
        }

    }
}
