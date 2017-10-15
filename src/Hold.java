import java.util.ArrayList;

public class Hold {
    private String holdNavn;
    private int antalHoldDeltagere;
    private Virksomhed virksomhed;
    private Deltager holdkaptajn;

    private ArrayList <Deltager> deltagere;

    private static int antalHold;

    public void Hold(String holdNavn, int antalHoldDeltagere,
                     Virksomhed virksomhed, Deltager holdkaptajn){
        this.holdNavn = holdNavn;
        this.antalHoldDeltagere = antalHoldDeltagere;

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


    //Setter metoder
    public void setHoldNavn(String holdNavn){
        this.holdNavn = holdNavn;
    }

    public void setHoldkaptajn(Deltager holdkaptajn) {
        this.holdkaptajn = holdkaptajn;
    }

    //Delete

}
