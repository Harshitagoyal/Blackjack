package HW08;

import java.util.List;

/**
 * The Hand class represents the information stored in a hand of cards. It is the subclass of Deck so that
 * it inherits some functionalities from Deck.
 */
public class Hand extends Deck {

    /**
     * No-argument constructor which creates object that represent a hand of cards by invoking its
     * superclass constructor firstly, and then setting the list of this hand to an empty set.
     */
    public Hand() {
        //Invokes the one-argument constructor of its superclass, and creates a empty list accordingly.
        super("");
    }

    /**
     * Visualize the state of this hand object by printing out all cards stored.
     *
     */
    @Override
    public void printCards() {
        for (Card card : super.getCards()) {
            System.out.println(card);
        }
    }
}
