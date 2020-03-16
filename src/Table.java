import java.util.ArrayList;

public class Table {
    private ArrayList<Card> tableCards = new ArrayList<Card>();

    public Table()
    {

    }

    public ArrayList<Card> getTableCards() { return tableCards; }
    public Card getLastTable() { return this.getTableCards().get(this.getTableCards().size() - 1); }

    @Override
    public String toString() { return "[" + this.getLastTable().toString() + "]"; }
}
