import java.util.ArrayList;

public class Hold {
    private String holdNavn;
    private int antalHoldDeltagere;
    private Virksomhed virksomhed;
    private Participant holdKaptajn;

    private ArrayList <Participant> deltagere = new ArrayList<>();

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
    public void addDeltager(Participant participant){
        deltagere.add(participant);
        antalHoldDeltagere++;
    }

    //Getter metoder
    public String getHoldNavn(){
        return holdNavn;
    }

    public int getAntalHoldDeltagere() {
        return antalHoldDeltagere;
    }

    public ArrayList<Participant> getDeltagere() {
        return deltagere;
    }

    public Participant getHoldKaptajn() {
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

    public void setHoldkaptajn(Participant holdkaptajn) {
        this.holdKaptajn = holdkaptajn;
    }

    //Delete

}
