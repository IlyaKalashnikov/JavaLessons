package testApp.cardsClasses;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class Hand <T extends cards> implements cards {

    private List<T> hand;

    public Hand(List<T> hand) {
        this.hand = hand;
    }

    @Override
    public int getValue() {
        int score = 0;
        for (ListIterator <T> it = hand.listIterator(); it.hasNext(); score += it.next().getValue() ) {
        }
        return score;
    }

    public void takeCards (Deck deck) {
       List tmp = new ArrayList<>();
       tmp.addAll(deck.getDeck().subList(deck.getDeck().size()-2,deck.getDeck().size()));
       hand.addAll(tmp);
       deck.getDeck().removeAll(tmp);
    }

    public void needMoreCards (Deck deck) {
        List tmp = new ArrayList<>();
        tmp.addAll(deck.getDeck().subList(deck.getDeck().size()-1,deck.getDeck().size()));
        hand.addAll(tmp);
        deck.getDeck().removeAll(tmp);
    }

    public void showInfo() {
        for (ListIterator <T> it = hand.listIterator(); it.hasNext(); ) {
            System.out.println(it.next().toString());
        }
    }

    public List<T> getHand() {
        return hand;
    }
}
