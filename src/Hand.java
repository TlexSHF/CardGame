import java.util.ArrayList;

public class Hand {
    ArrayList<Card> hand = new ArrayList<Card>();

    public Hand()
    {
    }

    public ArrayList<Card> getHand() { return hand; }

    @Override
    public String toString() {

        String indexHand = "";
        for (int i = 0; i < this.hand.size(); i++) {
            indexHand += i + ":[" + hand.get(i) + "] ";
        }
        return indexHand;
    }
}
