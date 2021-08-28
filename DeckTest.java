package HW08;

import org.junit.Test;
import org.junit.Before;

import java.util.List;

import static org.junit.Assert.*;

public class DeckTest {
    Deck deckA;
    Deck deckB;
    Deck deckC;
    Deck deckD;
    Deck deckE;
    Card cardA;
    Card cardB;

    @Before
    public void setUp() throws Exception {
        deckA = new Deck();
        deckB = new Deck();
        deckC = new Deck();
        deckD = new Deck();
    }

    // Test that a deck has 52 cards and the decks are always initialized with same set of cards.
    @Test
    public void buildDeck() {
        //buildDeck() is invoked by constructor.
        deckC = new Deck();
        assertEquals(deckC.getCards().size(), 52);
        deckD = new Deck();
        assertEquals(deckD.getCards().size(), 52);
        assertTrue(deckC.equals(deckD));
    }

    // Test that getCards returns a copy of the entire deck.
    @Test
    public void testGetCards() {
        List<Card> deckACardsCopy = deckA.getCards();
        //After instantiating a deck, by calling getCards(), we will get total 52 cards in the list.
        assertTrue(deckACardsCopy.size() == 52);
        //clear the card list which we retrieved by calling getCards()
        deckACardsCopy.clear();
        //Check back the size should not be impacted, since by calling getCards() we only get a copy
        //of the object.
        assertTrue(deckA.getCards().size() == 52);
    }

    // Tests that addCard works correctly.
    @Test
    public void addCard() {
        assertTrue(deckA.getCards().size() == 52);//A new deck contains 52 cards.
        //Remove one card from the intact new deck so that new card can be added.
        cardB = deckA.removeCard();
        //The number of cards reflects the removing operation.
        assertTrue(deckA.getCards().size() == 51);
        deckA.addCard(cardB);

        //If the card number increased by 1, successfully adding one card to deck
        assertTrue(deckA.getCards().size() == 52);
    }

    // Tests that addCard throws IllegalArgumentException when the provided card is null.
    @Test (expected = IllegalArgumentException.class)
    public void addCardWhenGivenCardIsNull() {
        //Remove one card from the intact new deck so that new card can be added.
        deckA.removeCard();
        //cardA is only declared as Card type variable but not being initiated yet. It is null.
        deckA.addCard(cardA);
    }

    // Tests that addCard throws IllegalArgumentException when the provided card is already present
    // in the deck.
    @Test (expected = IllegalArgumentException.class)
    public void addCardWhenGivenCardExistsInDeck() {
        //Firstly remove two card to make room to do adding operation.
        cardA = deckA.removeCard();
        cardB = deckA.removeCard();
        //Secondly add the same card back twice, test if it will throw IAE as expected.
        deckA.addCard(cardA);
        deckA.addCard(cardA);
    }

    // Tests that removeCard works.
    @Test
    public void removeCard() {
        assertTrue(deckA.getCards().size() == 52);//A new deck contains 52 cards.
        cardB = deckA.removeCard();
        //The number of cards should reflect the removing operation.
        assertTrue(deckA.getCards().size() == 51);
        assertFalse(deckA.getCards().contains(cardB));

        //After executing 52 times removing operations, there is no card left in deck.
        for (int i = 0; i < 52; i++){
            deckB.removeCard();
        }
        assertTrue(deckB.getCards().size() == 0);
    }

    // Tests that removeCard throws IllegalStateException when deck is empty.
    @Test (expected = IllegalStateException.class)
    // Trying to execute 53 times removing operations while only 52 cards in a new deck.
    public void removeCardWhenNoCardInDeck() {
        for (int i = 0; i < 53; i++){
            deckB.removeCard();
        }
    }

    // Tests that sorting a deck works correctly.
    @Test
    public void sortDeck() {
        //After executing 52 times removing operations, there is no card left in deck.
        for (int i = 0; i < 52; i++){
            deckB.removeCard();
        }
        //Add two cards with same suit in deck.
        deckB.addCard(new Card(8, Suit.SPADE));
        deckB.addCard(new Card(1, Suit.SPADE));

        //Before sorting, the state of cards stored in list is as below.
        assertTrue(deckB.getCards().get(0).equals(new Card(8, Suit.SPADE)));
        assertTrue(deckB.getCards().get(1).equals(new Card(1, Suit.SPADE)));

        //After sorting, check if the position of to cards changes as expected that cards with
        //same suit should be present in ascending order
        deckB.sortDeck();
        assertTrue(deckB.getCards().get(0).equals(new Card(1, Suit.SPADE)));
        assertTrue(deckB.getCards().get(1).equals(new Card(8, Suit.SPADE)));

        //Add a new card with different suit.
        deckB.addCard(new Card(10, Suit.HEART));

        //After sorting, check to see if the order of cards meets the criteria that same suit
        //cards are sorted by ascending order in value while different suit card are sorted
        //in alphabetic order.
        deckB.sortDeck();
        assertTrue(deckB.getCards().get(0).equals(new Card(10, Suit.HEART)));
        deckB.addCard(new Card(10, Suit.CLUB));
        deckB.sortDeck();
        assertTrue(deckB.getCards().get(0).equals(new Card(10, Suit.CLUB)));
    }

    // Tests that equals() method works correctly.
    @Test
    public void testEquals() {
        //deckA and deckB are created without any further operations, by default the cards
        //of deckA should be equal to card of deckB.
        assertTrue(deckA.equals(deckB));

        //Remove all cards out of deckA and deckB.
        for (int i = 0; i < 52; i++){
            deckA.removeCard();
            deckB.removeCard();
        }
        //Add two cards to deckA and deckB respectively, and check to see if deckA equals
        //to deckB
        deckA.addCard(new Card(8, Suit.SPADE));
        deckA.addCard(new Card(1, Suit.SPADE));
        deckB.addCard(new Card(8, Suit.SPADE));
        deckB.addCard(new Card(1, Suit.SPADE));

        assertTrue(deckA.equals(deckB));

    }

    // Tests that equals() method returns False when object types are different.
    @Test
    public void testEqualsWhenTwoObjectWithDifferentType() {
        assertFalse(deckA.equals(new Hand()));
    }

    // Tests that equals() method returns False when a given object is null.
    @Test
    public void testEqualsWhenGivenObjectIsNull() {
        //deckE is only declared as card type variable without getting instantiated, so it is null.
        assertFalse(deckA.equals(deckE));
    }
}