package testApp;

import testApp.cardsClasses.Deck;
import testApp.cardsClasses.Hand;

import java.util.ArrayList;
import java.util.Scanner;

public class BlackJackApp {
    public static void main(String[] args) {
        Deck deck = new Deck(new ArrayList<>());
        Hand hand = new Hand<>(new ArrayList<>());
        Hand diller = new Hand<>(new ArrayList<>());
        String points = "Очков: ";
        String yourHand = "У вас в руке:";
        String dillerHand = "У диллера в руке";
        Scanner sc = new Scanner(System.in);

        do {
            hand.takeCards(deck);
            diller.takeCards(deck);
            showHandAndDiller(hand, diller, points, yourHand, dillerHand);
            takeMoreCardsIfNecessary(deck, hand, points, yourHand, sc);
            if (hand.getValue() > 21) {
                System.out.println("У вас перебор");
            } else if (hand.getValue() == 21) {
                System.out.println("Блек Джек! Вы победили!");
                break;
            }
            System.out.println("Теперь играет диллер!");
            dillerTakeCards(deck, hand, diller);
            System.out.println("Очков у диллера: " + diller.getValue());
            showGameResult(hand, diller);
            hand.getHand().clear();
            diller.getHand().clear();
            deck = new Deck(new ArrayList<>());
            System.out.println("Сыграть еще раз?\nВведите любую букву, если хотите продолжить\nНет, если хотите закончить");
            String decision = sc.nextLine();
        } while (!sc.nextLine().equalsIgnoreCase("Нет"));
    }

    private static void showGameResult(Hand hand, Hand diller) {
        if (diller.getValue() > hand.getValue() && diller.getValue() > 21) {
            System.out.println("Победа! У диллера перебор!");
        } else if (diller.getValue() > hand.getValue() && diller.getValue() <= 21) {
            System.out.println("Победа диллера.");
        } else if (diller.getValue() < hand.getValue() && hand.getValue() > 21) {
            System.out.println("Победа диллера.");
        } else if (diller.getValue() < hand.getValue() && hand.getValue() <= 21) {
            System.out.println("Вы обыграли дилера!");
        } else if (diller.getValue() == hand.getValue()) {
            System.out.println("Ничья!");
        }
    }

    private static void dillerTakeCards(Deck deck, Hand hand, Hand diller) {
        while (diller.getValue() < hand.getValue() && hand.getValue() < 21) {
            diller.needMoreCards(deck);
        }
        diller.showInfo();
    }

    private static void takeMoreCardsIfNecessary(Deck deck, Hand hand, String points, String yourHand, Scanner sc) {
        System.out.println("Введите 1, чтобы взять еще карту.\nИли любую другую цифру, чтобы продолжить играть с этими картами");
        while (sc.nextInt() == 1) {
            hand.needMoreCards(deck);
            System.out.println(yourHand);
            hand.showInfo();
            System.out.println(points + hand.getValue());
        }
    }

    private static void showHandAndDiller(Hand hand, Hand diller, String points, String yourHand, String dillerHand) {
        System.out.println(yourHand);
        hand.showInfo();
        System.out.println(points + hand.getValue());
        System.out.println(dillerHand);
        diller.showInfo();
        System.out.println("Очков у диллера: " + diller.getValue());
    }
}