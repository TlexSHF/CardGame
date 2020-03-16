//enum in its own class
enum Suit {spades, hearts, clubs, diamonds}

public class Card {
    private Suit suit;
    private int number;

    public Card(){}
    public Card(Suit s, int n){
        this.suit = s;
        this.number = n;
    }

    public Suit getSuit() { return suit; }
    public int getNumber() { return number; }

    @Override
    public String toString() {
        return number + " " + suit;
    }
}
