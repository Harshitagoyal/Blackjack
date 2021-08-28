package HW08;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class HandTest {
    Hand handA;
    Hand handB;
    Hand handC;
    Card cardA;

    @Before
    public void setUp() throws Exception {
        handA = new Hand();
        handB = new Hand();
    }

    // Tests that getCards() works correctly.
    @Test
    public void testGetCards() {
        assertTrue(handA.getCards().size() == 0);
        assertTrue(handB.getCards().size() == 0);
        handA.addCard(new Card(1, Suit.CLUB));
        List<Card> handACardsCopy = handA.getCards();
        //After instantiating a hand and adding one card this  hand by calling getCards(), we will get
        // one card in the list.
        assertTrue(handACardsCopy.size() == 1);
        //clear the card list which we retrieved by calling getCards()
        handACardsCopy.clear();
        //Check back the size should not be impacted, since by calling getCards() we only get a copy
        //of the object.
        assertTrue(handA.getCards().size() == 1);
    }

    // Tests that addCard() works correctly.
    @Test
    public void addCard() {
        handA.addCard(new Card(1, Suit.CLUB));
        assertTrue(handA.getCards().size() == 1);
        assertTrue(handA.getCards().get(0).equals(new Card(1, Suit.CLUB)));
    }

    // Tests that addCard throws IllegalArgumentException when provided card is null.
    @Test (expected = IllegalArgumentException.class)
    public void addCardWhenGivenObjectIsNull() {
        handA.addCard(cardA);
    }

    // Tests that addCard throws IllegalArgumentException when provided card already exists in Hand.
    @Test (expected = IllegalArgumentException.class)
    public void addCardWhenGivenCardExistsInHand() {
        //Add the same card back twice, test if it will throw IAE as expected.
        cardA = new Card(1, Suit.CLUB);
        handA.addCard(cardA);
        handA.addCard(cardA);
    }

    // Tests that removeCard() works correctly.
    @Test
    public void removeCard() {
        cardA = new Card(1, Suit.CLUB);
        handA.addCard(cardA);
        handA.removeCard();
        assertTrue(handA.getCards().size() == 0);
        assertFalse(handA.getCards().contains(cardA));
    }

    // Tests that removeCard() throws IllegalStateException when the hand is empty.
    @Test (expected = IllegalStateException.class)
    public void removeCardWhenNoCardInDeck() {
        cardA = new Card(1, Suit.CLUB);
        handA.addCard(cardA);
        handA.removeCard();
        assertTrue(handA.getCards().size() == 0);
        handA.removeCard();
    }

    // Tests that sortDeck() works correctly.
    @Test
    public void sortDeck() {
        handB.addCard(new Card(8, Suit.SPADE));
        handB.addCard(new Card(1, Suit.SPADE));

        //Before sorting, the state of cards stored in list is as below.
        assertTrue(handB.getCards().get(0).equals(new Card(8, Suit.SPADE)));
        assertTrue(handB.getCards().get(1).equals(new Card(1, Suit.SPADE)));

        //After sorting, check if the position of to cards changes as expected that cards with same suit should
        //be present in ascending order
        handB.sortDeck();
        assertTrue(handB.getCards().get(0).equals(new Card(1, Suit.SPADE)));
        assertTrue(handB.getCards().get(1).equals(new Card(8, Suit.SPADE)));

        //Add a new card with different suit.
        handB.addCard(new Card(10, Suit.HEART));

        //After soring, check to see if the order of cards meets the criteria that same suit cards are sorted by
        //ascending order in value while different suit card are sorted in alphabetic order.
        handB.sortDeck();
        assertTrue(handB.getCards().get(0).equals(new Card(10, Suit.HEART)));
    }
}