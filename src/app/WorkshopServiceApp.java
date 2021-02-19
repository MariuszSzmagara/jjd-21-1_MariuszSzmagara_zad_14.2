package app;

import java.io.EOFException;
import java.io.IOException;

public class WorkshopServiceApp {
    private static final String APP_NAME = "WorkshopService";

    public static void main(String[] args) {
        System.out.println(APP_NAME);
        Control control = null;
        try {
            control = new Control();
            control.controlLoop();
        } catch (EOFException exception) {
            exception.printStackTrace();
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }
}
