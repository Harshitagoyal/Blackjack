package HW08;

/**
 * This class is designed to demonstrate some functions of deck, hand, and card objects. It only
 * includes one main function to finish the following tasks:
 * creates a deck of cards, shuffles the deck, creates two hands of 5 cards each,
 * removes cards from the deck and adds them to the hand, tests the sort and print functions for
 * the hands and the deck, and returns the cards from hand to deck , and tests to ensure that
 * the cards have been properly returned.
 */
public class Problem1Demo {
    public static void main(String[] args) {
        //creates a deck of cards
        Deck newDeck = new Deck();
        if (newDeck.getCards().size() == 52){
            System.out.println("A new deck of cards (total 52 cards) are created.");
        }
        //shuffles the deck
        newDeck.shuffleDeck();

        //creates two hand objects and distributes 5 cards to each hand respectively.
        Hand handOne = new Hand();
        Hand handTwo = new Hand();
        int count = 5;
        while (count > 0) {
            handOne.addCard(newDeck.removeCard());
            handTwo.addCard(newDeck.removeCard());
            count--;
        }

        //sort all cards in hand one and display the state by printing out all cards in sorted order
        handOne.sortDeck();
        System.out.println("Hand One:");
        handOne.printCards();

        //sort all cards in hand two and display the state by printing out all cards in sorted order
        handTwo.sortDeck();
        System.out.println("Hand Two:");
        handTwo.printCards();
        System.out.println();

        //remove cards from each hand the return them to the original deck.
        while (!handOne.getCards().isEmpty() || !handTwo.getCards().isEmpty()){
            if (!handOne.getCards().isEmpty()){
                newDeck.addCard(handOne.removeCard());
            }
            if (!handTwo.getCards().isEmpty()){
                newDeck.addCard(handTwo.removeCard());
            }
        }

        //sort the deck.
        newDeck.sortDeck();

        //compare this deck with a new deck which containing all 52 suited cards, to see it cards
        //have been properly returned.
        if (newDeck.equals(new Deck())){
            System.out.println("All cards have been properly returned.");
        }
    }
}
