package HW08;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The Deck class represents the information stored in a deck of cards. It has constants value
 * to represent the face value and suit of the card. Besides, it has a member field:
 * {@code List<Card> cards} representing all cards stored in this deck.
 * Assuming in any case, the deck object won't contain either more than 52 suited cards, or two
 * cards with same suit and face value.
 */
public class Deck {
    //We put null at index 0 to be a placeholder so that the integer face value of card and index
    // of this string array can have a perfect one-to-one mapping relationship.
    public static final String[] VALUES = { null, "Ace", "2", "3", "4", "5", "6", "7",
                                            "8", "9", "10", "Jack", "Queen", "King"};

    private final List<Card> cards;

    /* Note on constructors: for the scope of this homework, we provide user no-argument
    constructor which will be used to instantiate Deck object and a one-argument
    constructor which takes a string as input and will be used for subclass only.
    */

    /**
     * No-argument constructor which creates objects that represent the standard 52 cards in a
     * deck by invoking buildDeck() method.
     */
    public Deck() {
        cards = buildDeck();
    }

    /**
     * One-argument constructor which takes a string input and creates objects with empty list of
     * cards. This constructor exists exclusively to be leveraged by its subclass to. And the
     * subclass is in the same package, so that default modifier is good enough for this
     * constructor.
     *
     * @param str It's just a placeholder that differentiates with the no-arg constructor
     */
    Deck(String str) {
        cards = new ArrayList<>();
    }

    /**
     * Helper method which will be only invoked inside constructor to help create the deck of cards.
     *
     * @return {@code List<Card> cards} representing a deck containing 52 suited cards
     */
    private List<Card> buildDeck(){
        List<Card> cards = new ArrayList<>();
        for (Suit suit : Suit.values()){
            for (int j = 1; j < VALUES.length; j++){
                cards.add(new Card(j, suit));
            }
        }
        return cards;
    }

    /**
     * Return a copy of {@code List<Card> cards} stored in this deck while leaving the original
     * one intact.
     *
     * @return a copy of {@code List<Card> cards} stored in this deck.
     */
    public List<Card> getCards() {
        List<Card> newCopy = new ArrayList<>();
        newCopy.addAll(cards);
        return newCopy;
    }

    /**
     * Mix up the cards so that the order of cards in the list will be random.
     *
     */
    public void shuffleDeck() {
        Collections.shuffle(cards);
    }

    /**
     * Add the given Card object to the deck.
     *
     * @param newCard given Card object to be added
     * @throws IllegalArgumentException when the given obj is null or the deck contains a card with the same
     * suit and value with the given one.
     */
    public void addCard(Card newCard) throws IllegalArgumentException{
        if (newCard == null){
            throw new IllegalArgumentException("Given obj is null.");
        } else if (cards.contains(newCard)){
            throw new IllegalArgumentException("Given obj exists in deck already.");
        }
        cards.add(newCard);
    }

    /**
     * Remove a card from the tail of the deck.
     *
     * @return the card to be removed
     * @throws IllegalStateException when the cards is with null value or there is no card left in deck.
     */
    public Card removeCard(){
        if (cards == null || cards.size() == 0){
            throw new IllegalStateException("No card in deck!");
        }
        return cards.remove(cards.size() - 1);
    }

    /**
     * Display the deck information in a more readable way.
     *
     * @return String type of deck information.
     */
    @Override
    public String toString() {
        return "Deck{" +
                "lists = " + cards +
                '}';
    }
    /**
     * Sort the cards of deck firstly by alphabetic order of suit and then by ascending order of
     * card value.
     *
     */
    public void sortDeck(){
        Collections.sort(cards);
    }

    /**
     * Visualize the state of this deck by printing out all cards stored.
     *
     */
    public void printCards(){
        for (Card card : cards) {
            System.out.println(card);
        }
    }

    /**
     * Return whether the given object equals to this Deck object.
     *
     * @param theOther	the other Deck object to be compared with
     * @return whether the given object equals to this Deck object.
     */
    @Override
    public boolean equals(Object theOther) {
        if (theOther == this) return true;
        if (theOther == null || theOther.getClass() != this.getClass()) return false;

        Deck theOtherDeck = (Deck) theOther;
        if (this.cards.size() != theOtherDeck.cards.size()) return false;
        for (Card card : this.cards) {
            if (!theOtherDeck.cards.contains(card)) {
                return false;
            }
        }
        return true;
    }
}

