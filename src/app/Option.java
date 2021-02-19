package app;

public enum Option {
    EXIT(0, "Wyjście z programau."),
    ADD_VEHICLE_TO_QUEUE(1, "Dodanie pojazdu do kolejki oczekujących na przegląd."),
    SERVICE_VEHICLE_FROM_QUEUE(2, "Pobierz pojazd z kolejki do przeglądu");
    private final int value;
    private final String description;

    Option(int value, String description) {
        this.value = value;
        this.description = description;
    }

    public int getValue() {
        return value;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return value + " - " + description;
    }

    public static Option createFromInt(int option) {
        return Option.values()[option];
    }
}
