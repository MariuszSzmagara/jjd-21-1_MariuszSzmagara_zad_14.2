package model;

public enum Type {
    CAR(1, "samochód osobowy"),
    MOTORBIKE(2, "motocykl"),
    TRUCK(3, "samochód ciężarowy");
    private final int value;
    private final String description;

    Type(int value, String description) {
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

    public static Type createFromInt(int option) {
        return Type.values()[option];
    }
}
