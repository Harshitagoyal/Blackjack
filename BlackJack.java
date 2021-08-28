package HW08;

/**
 * The BlackJack game class runs the blackjack game for 1 human player against the
 * computer dealer. This game only uses the basic <i>hit</i> and <i>stand</i> functionality.
 * Human player will be displayed as player while computer dealer will be display as dealer
 * when running the game.
 */
public class BlackJack {
    // Deck of 52 cards.
    private final Deck deck;
    // The human player.
    private final HumanPlayer humanPlayer;
    // The dealer.
    private final Dealer dealer;

    /**
     * Constructor initializes the deck, humanPlayer and dealer variables.
     */
    public BlackJack() {
        deck = new Deck();
        humanPlayer = new HumanPlayer("Player", deck);
        dealer = new Dealer("Dealer", deck);
    }

    /**
     * Runs the BlackJack game.
     */
    public void runGame() {
        System.out.println("Welcome to BlackJack. Ready to win?");
        // Step 1: Shuffle the deck.
        deck.shuffleDeck();
        // Step 2: Deal cards to player.
        humanPlayer.dealCards();
        System.out.println("Cards of Human player:");
        humanPlayer.printCards();
        // Step 3: Check if BlackJack for player.
        if (this.humanPlayer.getScore() == 21) {
            System.out.println(this.humanPlayer.getName() +
                    " got a blackjack. " + this.humanPlayer.getName() + " wins!");
            return;
        }
        // Step 4: Deal cards to dealer.
        dealer.dealCards();
        System.out.println("Open card of Dealer");
        dealer.printCards();
        // Step 5: Check if 21 for dealer.
        if (this.dealer.getScore() == 21) {
            System.out.println(this.dealer.getName() +
                    " got a blackjack. " + this.dealer.getName() + " wins!");
            return;
        }

        // Player's turn
        this.humanPlayer.executeTurn();
        if (this.humanPlayer.getScore() > 21) {
            System.out.println(this.humanPlayer.getName() + " is busted with score: "
                    + this.humanPlayer.getScore());
            return;
        }
        if (this.humanPlayer.getScore() == 21) {
            System.out.println(this.humanPlayer.getName() + " wins with score: " +
                    this.humanPlayer.getScore());
            return;
        }

        // Dealer's turn
        this.dealer.executeTurn();
        if (this.dealer.getScore() > 21) {
            System.out.println(this.dealer.getName() + " is busted with score: "
                    + this.dealer.getScore());
            return;
        }
        if (this.dealer.getScore() == 21) {
            System.out.println(this.dealer.getName() + " wins with score: " +
                    this.dealer.getScore());
            return;
        }

        System.out.println(this.humanPlayer.getName() + "'s score: " +
                this.humanPlayer.getScore() + " " + this.dealer.getName() +
                "'s score: " + this.dealer.getScore());
        if (this.humanPlayer.getScore() > this.dealer.getScore()) {
            System.out.println(this.humanPlayer.getName() + " wins!");
        } else {
            System.out.println(this.dealer.getName() + " wins!");
        }
    }

    public static void main(String[] args) {
        BlackJack blackJack = new BlackJack();
        blackJack.runGame();
    }
}
