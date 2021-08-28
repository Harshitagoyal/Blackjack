package HW08;

import java.util.List;

/**
 * Class with implementation for the dealer.
 */
public class Dealer extends Player {
    /**
     * Constructor initializes dealer's name and stores a reference to the common deck
     * of cards.
     *
     * @param name Name of the player
     * @param deck The common deck of cards
     */
    public Dealer(String name, Deck deck) {
        super(name, deck);
    }

    /**
     * Prints all but the first card for the dealer.
     */
    @Override
    public void printCards() {
        List<Card> cards = hand.getCards();
        for (int i = 1; i < cards.size(); i++) {
            System.out.println(cards.get(i));
        }
    }

    /**
     * Executes the turn for the dealer by <i>hit</i>ting until dealer score reaches 17 or higher.
     */
    @Override
    public void executeTurn() {
        while(getScore() < 17) {
            hit();
        }
    }
}
