package HW08;

import java.util.Scanner;

/**
 * Class with implementation for the human player.
 */
public class HumanPlayer extends Player {
    // Scanner to get hit/stand choice from the user.
    private final Scanner scanner;

    /**
     * Constructor that initializes human player with it's name, reference to the
     * common deck of cards and the scanner.
     *
     * @param name Name of the human player
     * @param deck common deck of cards.
     */
    public HumanPlayer(String name, Deck deck) {
        super(name, deck);
        scanner = new Scanner(System.in);
    }

    /**
     * Implementation of turn for the human player. The implementation takes in choices
     * for <i>hit</i> and <i>stand</i> via the scanner.
     */
    @Override
    public void executeTurn() {
        while (getScore() < 21) {
            System.out.println("User " + this.getName() + "'s current score is: " + this.getScore());
            System.out.println("Would you like to 'hit' or 'stand': ");
            String choice = scanner.next();
            if (choice.equalsIgnoreCase("hit")) {
                hit();
            } else if (choice.equalsIgnoreCase("stand")) {
                break;
            } else {
                System.out.println("Please enter valid choice.");
            }
        }
    }
}
