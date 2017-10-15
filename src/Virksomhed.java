import java.util.ArrayList;

public class Virksomhed {
    private String virkNavn;
    private int antalVirkDeltagere;

    private ArrayList<Deltager> deltagere;
    private ArrayList<Hold> holdListe;

    private static int antalVirk;

    //Contructor
    public Virksomhed() {
    }

    public Virksomhed(String virkNavn, int antalVirkDeltagere) {

        //Variable definitioner
        this.virkNavn = virkNavn;
        this.antalVirkDeltagere = antalVirkDeltagere;
    }

    //Addere
    public void addDeltagere (Deltager deltager){
        deltagere.add(deltager);
    }

    public void addHold (Hold hold){
        holdListe.add(hold);
    }

    //Setter
    public void setVirkNavn(String virkNavn) {
        this.virkNavn = virkNavn;
    }

    //Getter
    public String getVirkNavn() {
        return virkNavn;
    }

    public int getAntalVirkDeltagere() {
        return antalVirkDeltagere;
    }

    public ArrayList<Deltager> getDeltagere() {
        return deltagere;
    }

    public ArrayList<Hold> getHold() {
        return holdListe;
    }

    //Get fordeling af hold - mangler!


    //Add deltagere og hold


    //Delete Virk

}
