package HW08;

import java.util.List;

import static java.lang.Math.min;

/**
 * Abstract player class to represent common functionality for both the human player
 * and the dealer.
 */
public abstract class Player {
    // Player's hand.
    Hand hand;
    // Name of player.
    private String name;
    // The common deck of cards shared by all players.
    private Deck deck;

    /**
     * Constructor initializes player's name and stores a reference to the common deck
     * of cards.
     *
     * @param name Name of the player
     * @param deck The common deck of cards
     */
    public Player(String name, Deck deck) {
        if (name == null) {
            throw new NullPointerException("name is null.");
        }
        if (deck == null) {
            throw new NullPointerException("deck is null.");
        }
        this.hand = new Hand();
        this.name = name;
        this.deck = deck;
    }

    /**
     * Returns the name of the player.
     * @return name of the player
     */
    public String getName() {
        return this.name;
    }

    /**
     * Prints the cards in the hand.
     */
    public void printCards() {
        hand.printCards();
    }

    /**
     * Computes and returns the score for the player.
     * @return the score of the player.
     */
    public int getScore() {
        int score = 0;
        boolean hasAce = false;
        List<Card> cards = this.hand.getCards();
        for (Card card : cards) {
            if (card.getIntValue() >=2) {
                score += min(10, card.getIntValue());
            } else {
                hasAce = true;
            }
        }
        if (hasAce) {
            if ((score + 11) > 21 ) {
                score += 1;
            } else {
                score += 11;
            }
        }
        return score;
    }

    /**
     * Deals the initial 2 cards to the player.
     */
    public void dealCards() {
        this.hand.addCard(this.deck.removeCard());
        this.hand.addCard(this.deck.removeCard());
    }

    /**
     * Does the <i>hit</i> action for the player.
     */
    public void hit() {
        Card card = this.deck.removeCard();
        System.out.println("New card: " + card);
        this.hand.addCard(card);
    }

    /**
     * Executes the turn for the player.
     */
    public abstract void executeTurn();
}