package entity;

import java.util.ArrayList;
import java.util.List;

public class ParkingLot {
    String parkingLotId;
    int noOfFloor;
    int noOfSlotsPerFloor;
    List<ParkingFloor> parkingFloors;

    public ParkingLot(String parkingLotId, int noOfFloor, int noOfSlotsPerFloor) {
        this.parkingLotId = parkingLotId;
        this.noOfFloor = noOfFloor;
        this.noOfSlotsPerFloor = noOfSlotsPerFloor;
        this.parkingFloors = new ArrayList<>(noOfFloor);
    }


    public String getParkingLotId() {
        return parkingLotId;
    }

    public void setParkingLotId(String parkingLotId) {
        this.parkingLotId = parkingLotId;
    }

    public int getNoOfFloor() {
        return noOfFloor;
    }

    public void setNoOfFloor(int noOfFloor) {
        this.noOfFloor = noOfFloor;
    }

    public int getNoOfSlotsPerFloor() {
        return noOfSlotsPerFloor;
    }

    public void setNoOfSlotsPerFloor(int noOfSlotsPerFloor) {
        this.noOfSlotsPerFloor = noOfSlotsPerFloor;
    }

    public List<ParkingFloor> getParkingFloors() {
        return parkingFloors;
    }

    public void setParkingFloors(List<ParkingFloor> parkingFloors) {
        this.parkingFloors = parkingFloors;
    }
}
