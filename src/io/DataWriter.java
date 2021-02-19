package io;

import model.Vehicle;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Queue;

public class DataWriter {
    private static final String FILE_NAME = "workshop_queue.obj";
    ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(FILE_NAME));

    public DataWriter() throws IOException {
    }

    public void writeRestOfVehiclesFromQueueToFile(Queue<Vehicle> vehicles) {
        while (!vehicles.isEmpty()) {
            try {
                objectOutputStream.writeObject(vehicles.poll());
            } catch (IOException exception) {
                System.out.println("Nie udało się zapisać do pliku: " + FILE_NAME);
            }
        }
    }
}
