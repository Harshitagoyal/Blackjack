package HW08;

/**
 * This enum class represents suit of the playing cards. Declared the enum constants in alphabetic order
 * so that it can be leveraged by Card class when sorting two cards with different suit.
 */
public enum Suit {
    CLUB,
    DIAMOND,
    HEART,
    SPADE;

    /**
     * Display the suit information in a more preferable way.
     *
     * @return String type of suit information.
     */
    @Override
    public String toString() {
        switch (this) {
            case CLUB:
                return "Club";
            case DIAMOND:
                return "Diamond";
            case HEART:
                return "Heart";
            case SPADE:
                return "Spade";
        }
        return null;
    }
}