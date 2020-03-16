import java.util.Random;

public class Tools {
    /*METHODS THAT SHOULD BE IN THE REAL TOOLS CLASS*/
    //RdmNumber and its 'subMethods'
    //getLastTable()

    public int rdmCardIndex(Deck d)
    {
        //get rdm nr from 52 possible numbers
        int rdmIndex = rdmNumber(52);

        if(d.getDeck()[rdmIndex] == null) {
            return rdmCardIndex(d);
        }

        return rdmIndex;
    }

    private int rdmNumber(int max)  //max: always 52 - will i use it l8r for other things?
    {
        int newRdmNumber;
        Random rdm = new Random();
        newRdmNumber = rdm.nextInt(max);
        return newRdmNumber;
    }
}