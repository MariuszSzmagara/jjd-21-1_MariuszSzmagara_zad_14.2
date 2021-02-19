package model;

import java.util.LinkedList;
import java.util.Queue;

public class WorkshopService {

    private Queue<Vehicle> vehicles = new LinkedList<>();

    public Queue<Vehicle> getVehicles() {
        return vehicles;
    }

    public void setVehicles(Queue<Vehicle> vehicles) {
        this.vehicles = vehicles;
    }
}
