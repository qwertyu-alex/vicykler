import java.util.ArrayList;

public class Hold {
    private String holdNavn;
    private int antalHoldDeltagere;
    private Virksomhed virksomhed;
    private Deltager holdKaptajn;

    private ArrayList <Deltager> deltagere;

    private static int antalHold;


    //Constructor
    public Hold(){

    }

    public Hold(String holdNavn, int antalHoldDeltagere,
                     Virksomhed virksomhed, Deltager holdkaptajn){
        this.holdNavn = holdNavn;
        this.antalHoldDeltagere = antalHoldDeltagere;
        this.virksomhed = virksomhed;
        this.holdKaptajn = holdkaptajn;


    }

    //Adder metoder
    public void addDeltager(Deltager deltager){
        deltagere.add(deltager);
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
