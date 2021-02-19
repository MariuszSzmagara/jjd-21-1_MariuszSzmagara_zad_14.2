package app;

import io.DataReader;
import io.DataWriter;
import model.Vehicle;
import model.WorkshopService;

import java.io.IOException;
import java.util.Queue;

import static app.Option.*;

public class Control {
    private final DataReader dataReader = new DataReader();
    private final WorkshopService workshop = new WorkshopService();
    private final DataWriter dataWriter = new DataWriter();

    public Control() throws IOException {
    }

    public void controlLoop() {
        Option option;
        do {
            printProgramOptions();
            option = Option.createFromInt(dataReader.getInt());
            switch (option) {
                case EXIT:
                    exit(workshop.getVehicles());
                    break;
                case ADD_VEHICLE_TO_QUEUE:
                    addVehicleToQueue();
                    break;
                case SERVICE_VEHICLE_FROM_QUEUE:
                    serviceVehicleFromQueue();
                    break;
                default:
                    System.out.println("Wprowadzona opcja jest niepoprawna");
            }
        } while (option != EXIT);
    }

    private void serviceVehicleFromQueue() {
        if (workshop.getVehicles().isEmpty()) {
            System.out.println("W kolejce nie ma samochodów!");
        } else {
            Vehicle vehicle = workshop.getVehicles().poll();
            System.out.println("Dane samochodu który został pobrany do przeglądu:");
            System.out.println(vehicle);
        }
    }

    private void addVehicleToQueue() {
        Vehicle vehicle = dataReader.readAndCreateVehicle();
        workshop.getVehicles().add(vehicle);
    }

    private void exit(Queue<Vehicle> vehicles) {
        System.out.println("Koniec programu!");
        if (!workshop.getVehicles().isEmpty()) {
            dataWriter.writeRestOfVehiclesFromQueueToFile(vehicles);
        }
        dataReader.close();
    }

    private void printProgramOptions() {
        System.out.println("Wybierz jedną z poniższych opcji:");
        for (Option value : Option.values()) {
            System.out.println(value);
        }
    }
}
