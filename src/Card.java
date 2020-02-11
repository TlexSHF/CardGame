import java.util.Random;

public class Card {
    enum Suit {spades, hearts, clubs, diamonds};
    private Suit suit;
    private int number;

    public Suit getSuit() { return suit; }
    public int getNumber() { return number; }

    public Card(Suit s, int n){
        this.suit = s;
        this.number = n;
    }

    @Override
    public String toString() {
        return number + " " + suit;
    }

}
