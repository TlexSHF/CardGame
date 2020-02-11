import java.util.Random;

public class Deck {
    Card[] deck = new Card[52];

    public void creatingTheDeck()
    {
        Card.Suit suit
    }

    public int rdmCardMethod()
    {
        //get rdm nr from 52 possible numbers
        int rdmCardIndex = rdmNumberMethod(52);

        if(this.deck[rdmCardIndex] == null) {
            rdmCardMethod();
        }

        return rdmCardIndex;
    }

    public int rdmNumberMethod(int max)
    {
        int newRdmNumber;
        Random rdm = new Random();
        newRdmNumber = rdm.nextInt(max);
        return newRdmNumber;
    }
}
