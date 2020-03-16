import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

//Each time this class is called, it creates a full deck
public class Deck {
    private Card[] deck = new Card[52]; //Creates an empty CardArray
    private Tools t = new Tools();

    public Deck()
    {
        Suit[] suit = Suit.values();

        //Iterates through all suits and numbers -- Fills Array
        for(int i = 0; i < 4; i++) {
            for(int j = 0; j < 13; j++) {
                this.deck[i*13+j] = new Card(suit[i], j+1);
            }
        }
    }
    public Card[] getDeck() { return this.deck; }

    public ArrayList<Card> addTableCard(ArrayList<Card> tableCard)
    {
        int index = t.rdmCardIndex(this);
        tableCard.add(deck[index]);
        removeCard(deck, index);

        return tableCard;
    }

    public ArrayList<Card> addCardToHand(ArrayList<Card> hand)
    {
        //Gets rdm index
        int index = t.rdmCardIndex(this);
        //Adds card w/ that index to current hand
        hand.add(getDeck()[index]);
        //Removing card from deck
        removeCard(getDeck(), index);

        return hand;
    }

    public void removeCard(Card[] array, int index) { array[index] = null; }
    public void removeCard(ArrayList<Card> array, int index) { array.remove(index); }

    @Override
    public String toString() { return Arrays.toString(this.deck); }
}
