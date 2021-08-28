package HW08;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CardTest {
    Card cardA;
    Card cardB;
    Card cardC;
    Card cardD;
    Card cardE;
    Card cardF;

    @Before
    public void setUp() throws Exception {
        cardA = new Card(1, Suit.CLUB);
        cardB = new Card(2, Suit.SPADE);
        cardC = new Card(13, Suit.HEART);
        cardD = new Card(11, Suit.DIAMOND);
        cardE = new Card(3, Suit.DIAMOND);
    }

    // Tests that Card constructor throws IllegalArgumentException when the face value is below 1.
    @Test (expected = IllegalArgumentException.class)
    public void testConstructorWithFaceValueBelow1() {
        cardA = new Card(0, Suit.SPADE);//out of bound
    }

    // Tests that Card constructor throws IllegalArgumentException when the face value is above 13.
    @Test (expected = IllegalArgumentException.class)
    public void testConstructorWithFaceValueAbove13() {
        cardA = new Card(14, Suit.SPADE);//out of bound
    }

    // Tests that Card constructor throws IllegalArgumentException when suit is null.
    @Test (expected = IllegalArgumentException.class)
    public void testConstructorWithNullSuit() {
        cardA = new Card(1, null);
    }

    // Tests that getStringValue() works correctly.
    @Test
    public void getStringValue() {
        assertTrue(cardA.getStringValue().equals("Ace"));
        assertTrue(cardB.getStringValue().equals("2"));
        assertTrue(cardC.getStringValue().equals("King"));
        assertTrue(cardD.getStringValue().equals("Jack"));
    }

    // Tests that getIntValue() works correctly.
    @Test
    public void getIntValue() {
        assertEquals(cardA.getIntValue(), 1);
        assertEquals(cardB.getIntValue(), 2);
        assertEquals(cardC.getIntValue(), 13);
        assertEquals(cardD.getIntValue(), 11);
    }

    // Tests that getSuit() works correctly.
    @Test
    public void getSuit() {
        assertTrue(cardA.getSuit().equals(Suit.CLUB));
        assertTrue(cardB.getSuit().equals(Suit.SPADE));
        assertTrue(cardC.getSuit().equals(Suit.HEART));
        assertTrue(cardD.getSuit().equals(Suit.DIAMOND));
    }

    // Tests that toString() works correctly.
    @Test
    public void testToString() {
        //cardA = new Card(1, Suit.CLUB);
        assertTrue(cardA.toString().equals("Card{ value = 'Ace', suit = Club }"));
        //cardB = new Card(2, Suit.SPADE);
        assertTrue(cardB.toString().equals("Card{ value = '2', suit = Spade }"));
        //cardC = new Card(13, Suit.HEART);
        assertTrue(cardC.toString().equals("Card{ value = 'King', suit = Heart }"));
        //cardD = new Card(11, Suit.DIAMOND);
        assertTrue(cardD.toString().equals("Card{ value = 'Jack', suit = Diamond }"));
        //cardE = new Card(3, Suit.DIAMOND);
        assertTrue(cardE.toString().equals("Card{ value = '3', suit = Diamond }"));
    }

    // Tests that compareTo() works correctly.
    @Test
    public void compareTo() {
        //cardC = new Card(13, Suit.HEART), cardB = new Card(2, Suit.SPADE)
        //Although face value of cardC is greater than cardB, but the suit of cardC precedes that of cardB.
        //By calling cardC.compareTo(), it should return -1 to reflect the relationship between cardC and cardB.
        assertEquals(cardC.compareTo(cardB), -1);

        //Change cardB to make it with the same face value and suit of cardC.
        cardB = new Card(13, Suit.HEART);
        System.out.println(cardB.toString());
        //By calling cardC.compareTo(), it should return 0 to reflect the relationship between cardC and cardB.
        assertEquals(cardC.compareTo(cardB), 0);

        //cardD = new Card(11, Suit.DIAMOND); cardE = new Card(3, Suit.DIAMOND);
        //cardD and cardE are with same suit but cardD has a greater face value than cardE.
        //By calling cardD.compareTo(), it should return 1 to reflect the relationship between cardD and cardE.
        assertEquals(cardD.compareTo(cardE), 1);
    }

    // Tests that compareTo() throws IllegalArgumentException when provided card is null.
    @Test (expected = IllegalArgumentException.class)
    public void compareToWhenGivenNullValue() {
        //cardF is only declared as card type variable without getting instantiated, so it is null.
        cardA.compareTo(cardF);
    }

    // Tests that equals() works correctly.
    @Test
    public void testEquals() {
        //cardC = new Card(13, Suit.HEART), cardB = new Card(2, Suit.SPADE)
        assertFalse(cardC.equals(cardB));
        //Change cardB to make it with the same face value and suit of cardC.
        cardB = new Card(13, Suit.HEART);
        assertTrue(cardC.equals(cardB));
    }

    // Tests that equals() returns False when the object types are different.
    @Test
    public void testEqualsWhenTwoObjectsWithDifferentTypes() {
        assertFalse(cardA.equals(new Hand()));
    }

    // Tests that equals() returns False when the given object is null.
    @Test
    public void testEqualsWhenGivenObjectIsNull() {
        //cardF is only declared as card type variable without getting instantiated, so it is null.
        assertFalse(cardA.equals(cardF));
    }
}