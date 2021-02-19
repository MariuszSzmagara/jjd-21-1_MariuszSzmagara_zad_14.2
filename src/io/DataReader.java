package io;

import model.Type;
import model.Vehicle;

import java.io.*;
import java.util.Queue;
import java.util.Scanner;

public class DataReader {
    private final Scanner scanner = new Scanner(System.in);
    private static final String FILE_NAME = "workshop_queue.obj";
//    private final ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(FILE_NAME));

    public DataReader() {
    }

    public Vehicle readAndCreateVehicle() {
        Type type = getType();
        System.out.println("Podaj markę:");
        String brand = scanner.nextLine();
        System.out.println("Podaj model:");
        String model = scanner.nextLine();
        System.out.println("Podaj rok:");
        int year = getInt();
        System.out.println("Podaj przebieg w kilometrach:");
        int millage = getInt();
        System.out.println("Podaj numer VIN:");
        String vinNumber = scanner.nextLine();
        return new Vehicle(type, brand, model, year, millage, vinNumber);
    }

    private Type getType() {
        Type type;
        do {
            printVehicleTypes();
            type = Type.createFromInt(getInt());
        } while (!isTypeCorrect(type));
        return type;
    }

    private boolean isTypeCorrect(Type type) {
        return type == Type.CAR || type == Type.MOTORBIKE || type == Type.TRUCK;
    }

    private void printVehicleTypes() {
        System.out.println("Wybierz jeden z typów samochodów:");
        for (Type value : Type.values()) {
            System.out.println(value);
        }
    }

    public int getInt() {
        int number = scanner.nextInt();
        scanner.nextLine();
        return number;
    }

    public void close() {
        scanner.close();
    }

    public void readVehiclesFromFile(Queue<Vehicle> vehicles) {
        Vehicle vehicle = null;
        boolean keepReading = true;
        try (
                FileInputStream fileInputStream = new FileInputStream(FILE_NAME);
                ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
                ) {
            while (keepReading) {
                vehicles.add((Vehicle) objectInputStream.readObject());
            }
        } catch (EOFException exception) {
            keepReading = false;
        } catch (IOException | ClassNotFoundException exception) {
            exception.printStackTrace();
        }

    }
}
