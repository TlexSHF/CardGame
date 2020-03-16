import java.util.ArrayList;

enum PName { p1, p2 }

public class Player {

    private PName name; //= "player1";
    private ArrayList<Card> hand; // = new ArrayList<Card>();

    /*public Player(){
        Hand h = new Hand();
        this.hand = h.getHand();
    }*/
    //Every player gets a hand object each
    public Player(PName name) {
        Hand h = new Hand();            //Player creates its own hand... not assigning it though
        this.name = name;
        this.hand = h.getHand();
    }

    public ArrayList<Card> getHand() {
        return this.hand;
    }

    public PName getName() {
        return this.name;
    }

    public String indexHand() {
        String indexHand = "";
        for (int i = 0; i < this.hand.size(); i++) {
            indexHand += i + ":[" + hand.get(i) + "] ";
        }
        return indexHand;
    }

    public void setName (PName name){
        this.name = name;
    }
}
