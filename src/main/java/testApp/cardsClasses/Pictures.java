package testApp.cardsClasses;

import testApp.enums.Colours;
import testApp.enums.PicturesCard;

public class Pictures implements cards {

    private final PicturesCard cardName;
    private final static int cardValue = 10;
    private final Colours colour;

    public Pictures(PicturesCard cardName, Colours colour) {
        this.cardName = cardName;
        this.colour = colour;
    }


    @Override
    public int getValue() {
        return cardValue;
    }

    @Override
    public String toString() {
        return cardName.getPictureCardName() + " " + colour.getColour();
    }
}
