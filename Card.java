package HW08;

/**
 * The Card class represents the information stored in a card. It has constants value
 * to represent the face value. Besides, it has two member fields:
 * {@code String value} representing the face value;
 * {@code Suit suit} representing the suit;
 */
public class Card implements Comparable<Card>{
    private final static int MIN_CARD_FACE_VALUE = 1;
    private final static int MAX_CARD_FACE_VALUE = 13;
    public static final String[] VALUES = {null, "Ace", "2", "3", "4", "5", "6", "7",
                                           "8", "9", "10", "Jack", "Queen", "King"};
    private String value;
    private Suit suit;

    /* Note on constructors: for the scope of this homework, we only provide user the two-argument
    constructor.
    */

    /**
     * Two-argument constructor which takes {@code int value} and {@code Suit suit} as inputs to
     * create the corresponding card object.
     *
     * @param value	integer value of the face value
     * @param suit	suit of the card
     */
    public Card(int value, Suit suit) {
        assertValueValidity(value);
        assertSuitValidity(suit);
        this.value = VALUES[value]; // convert the face value of int type to string type
        this.suit = suit;
    }

    /**
     * Return the face value of card object in string type
     *
     * @return the face value of card object in string type
     */
    public String getStringValue() {
        return value;
    }

    /**
     * Return the face value of card object in integer type
     *
     * @return the face value of card object in integer type
     */
    public int getIntValue() {
        int res = 0;
        String stringValue = getStringValue();
        //Skip index 0 since null stored in index 0
        for (int i = 1; i < VALUES.length; i++){
            if (VALUES[i].equals(stringValue)){
                res = i;
                break;
            }
        }
        return res;
    }

    /**
     * Return the suit in enum type
     *
     * @return the suit of this card
     */
    public Suit getSuit() {
        return suit;
    }

    /**
     * Private helper method that can only be invoked by constructor in order to validate the value
     * parameter is between {@code >= MIN_CARD_FACE_VALUE}  and {@code <= MIN_CARD_FACE_VALUE}.
     *
     * @param value	face value of the card
     * @throws IllegalArgumentException if the given value is not between the min and max face values
     * of card
     */
    private void assertValueValidity(int value) throws IllegalArgumentException{
        if (value < MIN_CARD_FACE_VALUE || value > MAX_CARD_FACE_VALUE){
            throw new IllegalArgumentException("Given face value is not between 1 and 13.");
        }
    }

    /**
     * Private helper method that can only be invoked by constructor in order to validate the suit
     * parameter is a Suit (enum type) constant.
     *
     * @param suit	suit of the card
     * @throws IllegalArgumentException if the given suit is null.
     */
    private void assertSuitValidity(Suit suit) throws IllegalArgumentException{
        if (suit == null){
            throw new IllegalArgumentException("Given suit is not valid");
        }
    }

    /**
     * Display the card information of this object in a more readable way.
     *
     * @return String type of card information.
     */
    @Override
    public String toString() {
        return "Card{ " + "value = '" + value + '\'' + ", suit = " + suit + " }";
    }

    /**
     * Compare this card object with the given card object.
     *
     * @param theOther	suit of the card
     * @return a int value > 0: if the suit of this card precedes that of the given card in alphabetic
     * order, or the face value of this card precedes that of the given card in ascending order;
     *         a int value < 0: if the suit of this card not precedes that of the given card in alphabetic
     * order, or the face value of this card not precedes that of the given card in ascending order
     *         a int value = 0: if the suit and face value of this card are the same with those of the
     * given card.
     * @throws IllegalArgumentException if the given card object is null.
     */
    @Override
    public int compareTo(Card theOther) {
        if (theOther == null){
            throw new IllegalArgumentException("Given input is null.");
        }
        if (getSuit().compareTo(theOther.getSuit()) == 0){
            if (getIntValue() == theOther.getIntValue()){
                return 0;
            }
            return getIntValue() > theOther.getIntValue() ? 1 : -1;
        }
        return getSuit().compareTo(theOther.getSuit());
    }

    /**
     * Determine whether the given object equals to this Card object assuming cards with same face
     * value and suit are considered equal.
     *
     * @param theOther the other Card object to be compared with
     * @return whether the given object equals to this Deck object.
     */
    @Override
    public boolean equals(Object theOther) {
        if (theOther == this) return true;
        if (theOther == null || this.getClass() != theOther.getClass()) return false;

        Card theOtherCard = (Card) theOther;
        return this.getSuit().equals(theOtherCard.getSuit()) && this.getStringValue().equals(theOtherCard.getStringValue());
    }
}
