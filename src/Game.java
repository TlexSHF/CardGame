import java.util.ArrayList;
import java.util.Scanner;

public class Game {
    GameSetup gs = new GameSetup();     //Creates one gameSetup -> ONE GAME - cant have one in execute
    Tools t = new Tools();
    Deck d = gs.getDeck();      //This is the way to solve it!
    Player p1 = gs.getP1();         //Gets players from theGameSetup
    Player p2 = gs.getP2();
    boolean debug;
    boolean game = true;

    public Game() {

        System.out.println("debug? y/n");
        Scanner myScan = new Scanner(System.in);
        debug = myScan.nextLine().equals("y");          //SAME AS WRITING: if(myScan.nextLine().equals("y") debug = true;

        Player[] pAr = {p1, p2};
        //Make this loop that changes p1, p2 dynamically until game is done

        Label1:
        while(game) {
            for(int i = 0; i<pAr.length; i++) {
                calcTurnType(pAr[i]);
                status(pAr[i]);
                if(!game) break Label1;
            }
            /*calcTurnType(p1);
            status(p1);
            if(!game) break;
            calcTurnType(p2);
            status(p2);
            if(!game) break;*/
            turnUpdate();
        }
    }

    private void status(Player p) {
            if(p.getHand().size() == 1) System.out.println(p.getName() + " HAS ONE CARD LEFT!");
            if(p.getHand().size() == 0) {
                System.out.println(p.getName() + " WON THE GAME!");
                this.game = false;
            }
    }
    private void turnUpdate() {
        System.out.println("Card on table: [" + gs.getLastTable() +"]");
        System.out.println("Your cards: " + p1.getHand());
    }
    private void calcTurnType(Player p) {

        if(p.getName() == PName.p1) {
            System.out.println("[P1's TURN]");
            if (this.placeAble(p.getHand())) {
                choice();
            } else noChoice();

        } else if(p.getName() == PName.p2) {
            System.out.println("[P2's TURN]");
            if(debug) System.out.println(p.getHand().toString());
            if(this.placeAble(p.getHand())) {
                computerPlace();
            } else drawThree(p);
        }
    }
    private boolean placeAble(ArrayList<Card> pH) {  //Checks if there is at least one placeAble card
        boolean canPlace = false;

        for(Card c : pH) {   //TypeValues: Card, eachValueName: c, array: p
            if(this.cardPossible(c)) {
                canPlace = true;
            }
        }

        return canPlace;
    }
    private boolean cardPossible(Card c) {
        return c.getSuit().equals(gs.getLastTable().getSuit())
                || c.getNumber() == gs.getLastTable().getNumber() || c.getNumber() == 8;
    }

    private void choice() {
        System.out.println("place or draw a card? p/d");
        Scanner myScan = new Scanner(System.in);
        String placeDraw = myScan.nextLine();

        if(placeDraw.equals("p")) { placeCard(); }
        else if(placeDraw.equals("d")) { drawThree(gs.getP1()); }       //Would it be easier making a method here, in gs, or just keep it like it is. Safer, easier?
        else choice();
    }
    private void noChoice() {
        System.out.println("you can't place anything. Draw a card");
        drawThree(gs.getP1());
    }

    void drawThree(Player p) {
        String another;
        Scanner myScan = new Scanner(System.in);
        ArrayList<Card> pH = p.getHand();

        for(int i = 0; i < 3; i++) {
            drawCard(p);

            if(p.getName().equals(PName.p1)) {

                if(i < 2) {
                    if (placeAble(pH)) {
                        System.out.println("Draw another? y/n");

                        if (myScan.nextLine().equals("n")) { placeCard(); break; }      //If user types anything else than n, it is true <- not so good
                    }
                } else {    //When 3 cards
                    if(placeAble(pH)) { placeCard(); break; }
                    else System.out.println("You had to pass");
                }
            } else if (p.getName().equals(PName.p2)) {
                if(i < 2) {
                    if (placeAble(pH)) { computerPlace(); break; }
                } else {    //When 3 cards
                    if(placeAble(pH)) { computerPlace(); break; }
                    else System.out.println("computer passed");
                }
            }
        }
    }
    void drawCard(Player p) {
        ArrayList<Card> pH = p.getHand();

        int newIndex = t.rdmCardIndex(d);
        pH.add(d.getDeck()[newIndex]);      //Maybe just have a method in gs... two methods, one for the object and one for the array

        if(p.getName().equals(PName.p1)) {
            System.out.println("You drew: [" + d.getDeck()[newIndex] + "]");
        } else if(p.getName().equals(PName.p2)) {
            System.out.println("Computer drew a card");
            if (debug) System.out.println(d.getDeck()[newIndex] + " fullDeck: " + p.getHand().toString());
        }

        d.removeCard(d.getDeck(), newIndex);
    }

    void placeCard(){
        System.out.println(p1.getHand().toString());
        System.out.println("Chose card to place w/ its index 0,1,2..");
        Scanner myScan = new Scanner(System.in);
        int index = myScan.nextInt();

        if(index >= 0 && index < p1.getHand().size()){
            if(cardPossible( p1.getHand().get(index) )) {
                gs.getTable().add( p1.getHand().get(index) );
                d.removeCard( p1.getHand(), index );
                System.out.println("you placed: [" + gs.getLastTable() + "]");
            } else {
                System.out.println("can't place that card");
                placeCard();
            }
        } else {
            System.out.println("invalid index");
            placeCard();
        }
    }
    private void computerPlace() {

        for(int i = 0; i < p2.getHand().size(); i++) {
            if(cardPossible(p2.getHand().get(i))) {
                gs.getTable().add(p2.getHand().get(i));
                d.removeCard(p2.getHand(), i);
                System.out.println("computer placed: [" + gs.getLastTable() + "]");
                break;
            }
        }
    }

    //SOMETHING TO CHECK IF CAN PLACE
        //IF YES: OPTION: DRAW OR PLACE
        //IF NO: MUST DRAW
    //DRAW UP TO THREE TIMES - IF CAN PLACE
        //IF YES: OPTION TO DRAW UP TO TWO MORE, ONE MORE
        //IF NO: MUST DRAW ANOTHER
    //IF DREW THREE TIMES - PASS - GAME PASSES FOR YOU
}
