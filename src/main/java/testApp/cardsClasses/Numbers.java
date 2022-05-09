package testApp.cardsClasses;

import testApp.enums.Colours;

public class Numbers implements cards {

    private final int cardName;
    private final int cardValue;
    private final Colours colour;


    public Numbers(int cardName, Colours colour) {
        this.cardName = cardName;
        cardValue = cardName;
        this.colour = colour;
    }

    @Override
    public int getValue() {
        return cardValue;
    }

    @Override
    public String toString() {
        String num = Integer.toString(cardName);
        return num + "ка" + " " + colour.getColour();
    }
}
