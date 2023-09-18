package entity;

import java.util.List;

public class ParkingFloor {
    List<ParkingSlot> parkingSlots;
    int floorId;

    public ParkingFloor(int floorId, List<ParkingSlot> parkingSlots) {
        this.parkingSlots = parkingSlots;
        this.floorId = floorId;
    }

    public List<ParkingSlot> getParkingSlots() {
        return parkingSlots;
    }

    public void setParkingSlots(List<ParkingSlot> parkingSlots) {
        this.parkingSlots = parkingSlots;
    }

    public int getFloorId() {
        return floorId;
    }

    public void setFloorId(int floorId) {
        this.floorId = floorId;
    }
}
