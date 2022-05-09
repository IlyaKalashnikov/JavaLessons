package testApp.enums;

public enum Colours {
    CHERVI("Черви"), BUBI("Буби"), KRESTI("Крести"), PIKI("Пики");

    private String colour;

    Colours(String colour) {
        this.colour = colour;
    }

    public String getColour() {
        return colour;
    }
}
