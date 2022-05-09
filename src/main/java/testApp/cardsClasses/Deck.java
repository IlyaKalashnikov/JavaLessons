package testApp.cardsClasses;

import testApp.enums.Colours;
import testApp.enums.PicturesCard;

import java.util.Collections;
import java.util.List;

public class Deck {

    private List <? super cards> deck;

    public Deck(List<? super cards> deck) {
        this.deck = deck;
        deck.add(new Numbers(2, Colours.CHERVI));
        deck.add(new Numbers(2, Colours.BUBI));
        deck.add(new Numbers(2, Colours.PIKI));
        deck.add(new Numbers(2, Colours.KRESTI));
        deck.add(new Numbers(3, Colours.KRESTI));
        deck.add(new Numbers(3, Colours.CHERVI));
        deck.add(new Numbers(3, Colours.BUBI));
        deck.add(new Numbers(3, Colours.PIKI));
        deck.add(new Numbers(4, Colours.PIKI));
        deck.add(new Numbers(4, Colours.BUBI));
        deck.add(new Numbers(4, Colours.CHERVI));
        deck.add(new Numbers(4, Colours.KRESTI));
        deck.add(new Numbers(5, Colours.KRESTI));
        deck.add(new Numbers(5, Colours.CHERVI));
        deck.add(new Numbers(5, Colours.BUBI));
        deck.add(new Numbers(5, Colours.PIKI));
        deck.add(new Numbers(6, Colours.PIKI));
        deck.add(new Numbers(6, Colours.KRESTI));
        deck.add(new Numbers(6, Colours.CHERVI));
        deck.add(new Numbers(6, Colours.BUBI));
        deck.add(new Numbers(7, Colours.CHERVI));
        deck.add(new Numbers(7, Colours.KRESTI));
        deck.add(new Numbers(7, Colours.PIKI));
        deck.add(new Numbers(7, Colours.BUBI));
        deck.add(new Numbers(8, Colours.PIKI));
        deck.add(new Numbers(8, Colours.BUBI));
        deck.add(new Numbers(8, Colours.KRESTI));
        deck.add(new Numbers(8, Colours.CHERVI));
        deck.add(new Numbers(9, Colours.BUBI));
        deck.add(new Numbers(9, Colours.KRESTI));
        deck.add(new Numbers(9, Colours.CHERVI));
        deck.add(new Numbers(9, Colours.PIKI));
        deck.add(new Numbers(10, Colours.KRESTI));
        deck.add(new Numbers(10, Colours.BUBI));
        deck.add(new Numbers(10, Colours.PIKI));
        deck.add(new Numbers(10, Colours.CHERVI));
        deck.add(new Pictures(PicturesCard.KING, Colours.KRESTI));
        deck.add(new Pictures(PicturesCard.KING, Colours.CHERVI));
        deck.add(new Pictures(PicturesCard.KING, Colours.PIKI));
        deck.add(new Pictures(PicturesCard.KING, Colours.BUBI));
        deck.add(new Pictures(PicturesCard.QUEEN, Colours.PIKI));
        deck.add(new Pictures(PicturesCard.QUEEN, Colours.CHERVI));
        deck.add(new Pictures(PicturesCard.QUEEN, Colours.BUBI));
        deck.add(new Pictures(PicturesCard.QUEEN, Colours.KRESTI));
        deck.add(new Pictures(PicturesCard.VALET, Colours.CHERVI));
        deck.add(new Pictures(PicturesCard.VALET, Colours.KRESTI));
        deck.add(new Pictures(PicturesCard.VALET, Colours.PIKI));
        deck.add(new Pictures(PicturesCard.VALET, Colours.BUBI));
        Collections.shuffle(deck);
    }

    public List getDeck() {
        return deck;
    }
}
