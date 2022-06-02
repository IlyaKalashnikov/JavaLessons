package networking.enums;

public enum LocationsNumber {
    FIFTY("50"), ONE_HUNDRED("100"),HUNDRED_AND_FIFTY("150");

    private String number;

    LocationsNumber(String number) {
        this.number = number;
    }

    public String getNumber() {
        return number;
    }
}
