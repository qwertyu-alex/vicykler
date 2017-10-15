import java.util.ArrayList;

public class Hold {
    private String holdNavn;
    private int antalHoldDeltagere;
    private Virksomhed virksomhed;
    private Deltager holdKaptajn;

    private ArrayList <Deltager> deltagere = new ArrayList<>();

    private static int antalHold;


    //Constructor
    public Hold(){
        this("Intet holdNavn", null);
    }

    public Hold(String holdNavn, Virksomhed virksomhed){

        //variabler
        this.holdNavn = holdNavn;
        this.virksomhed = virksomhed;

        //static
        antalHold++;
    }

    //Adder metoder
    public void addDeltager(Deltager deltager){
        deltagere.add(deltager);
        antalHoldDeltagere++;
    }

    //Getter metoder
    public String getHoldNavn(){
        return holdNavn;
    }

    public int getAntalHoldDeltagere() {
        return antalHoldDeltagere;
    }

    public ArrayList<Deltager> getDeltagere() {
        return deltagere;
    }

    public Deltager getHoldKaptajn() {
        return holdKaptajn;
    }

    //Static getter
    public static int getAntalHold() {
        return antalHold;
    }

    //Setter metoder
    public void setHoldNavn(String holdNavn){
        this.holdNavn = holdNavn;
    }

    public void setHoldkaptajn(Deltager holdkaptajn) {
        this.holdKaptajn = holdkaptajn;
    }

    //Delete

}
