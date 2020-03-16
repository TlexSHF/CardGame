import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class GameSetup {
    private Deck deck;
    private ArrayList<Card> table;
    private Player p1;
    private Player p2;                                  //This page needs a cleanUp. Things can be initialized on top, and not in publicGS

    public GameSetup() {

        //this.deck = d.getDeck();
        this.deck = new Deck();
        this.table = new Table().getTableCards();
        this.p1 = new Player(PName.p1);;
        this.p2 = new Player(PName.p2);;

        this.assignPHand(deck, p1.getHand());        //Assigning cards to p1, p2 and table
        this.assignPHand(deck, p2.getHand());        //Gets d(the object d for getting functions)
        this.assignTable(deck, table);         //And p1, p2, table(Arrays for filling)         //TODO question: Why not use the object itself?
        this.printFirstMessage();
    }

    //To get the objects themselves... do i need this?              //TODO Hand needs to be here for adding cards, is it a replica or the actual thing? Do i need it here? Can i remove other things, and it still is the same Player with a hand??
    //public Card[] getDeck() { return deck; }                        //Same here... cant acces the REAL deck.. only the array
    public Deck getDeck() { return deck; }
    public ArrayList<Card> getTable() { return table; }
    //public ArrayList<Card> getP1Hand() { return p1Hand; }       //TODO Might remove this as well. Get directly
    //public ArrayList<Card> getP2Hand() { return p2Hand; }         //or maybe I need it?? -- i don't... but still questions hmm hmm
    public Player getP1() { return p1; }
    public Player getP2() { return p2; }

    //For printing out as strings
    public String getDeckString() { return Arrays.toString(this.deck.getDeck()); }
    public String getTableString() { return "[" + this.getLastTable() + "]"; }
    public String getP1String() { return this.p1.getHand().toString(); }
    public String getP2String() { return this.p2.getHand().toString(); }

    public Card getLastTable() { return this.table.get(table.size() - 1); }
    private void assignPHand(Deck d, ArrayList<Card> p) {

        for(int i = 0; i < 8; i++) {
            d.addCardToHand(p);
        }
    }
    private void assignTable(Deck d, ArrayList<Card> t) {
        t = d.addTableCard(t);
    }
    private void printFirstMessage() {
        System.out.println("Your cards: ");
        System.out.println(this.getP1().indexHand());           //This works, but not .getP1.getHand or .getP1.getHand.toString ???
        System.out.println("Card on table: " + this.getTableString());
    }
    @Override
    public String toString() {
        return "Deck: " + Arrays.toString(deck.getDeck()) + "\n" +
                "Table: " + table + "\n" +
                "P1Hand: " + getP1String() + "\n" +
                "P2Hand: " + getP2String();
    }
}
