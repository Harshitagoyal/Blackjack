package HW08;

import static org.junit.Assert.*;

class DummyPlayer extends Player {
    /**
     * Constructor initializes player's name and stores a reference to the common deck
     * of cards.
     *
     * @param name Name of the player
     * @param deck The common deck of cards
     */
    public DummyPlayer(String name, Deck deck) {
        super(name, deck);
    }

    public void executeTurn() {}
}

public class PlayerTest {
    private Player player;

    @org.junit.Before
    public void setUp() throws Exception {
        Deck deck = new Deck();
        player = new DummyPlayer("player1", deck);
    }

    // Tests getName.
    @org.junit.Test
    public void getName() {
        assertEquals("player1", player.getName());
    }

    // Tests getScore
    @org.junit.Test
    public void getScore() {
        player.dealCards();
        assertEquals(13, player.getScore());
    }

    @org.junit.Test
    public void dealCards() {
    }

    @org.junit.Test
    public void hit() {
    }
}