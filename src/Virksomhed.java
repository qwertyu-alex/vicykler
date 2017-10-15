import java.util.ArrayList;

public class Virksomhed {
    private String virkNavn;
    private int antalVirkDeltagere;

    private ArrayList<Deltager> deltagere = new ArrayList<>();
    private ArrayList<Hold> holdListe = new ArrayList<>();

    private static int antalVirk;
    private static ArrayList<Virksomhed> virkListe = new ArrayList<>();

    //Contructor
    public Virksomhed() {
    }

    public Virksomhed(String virkNavn) {

        //Variable definitioner
        this.virkNavn = virkNavn;

        //Static variable definitioner
        antalVirk++;
        virkListe.add(this);
    }

    //Addere
    public void addHold (Hold hold){

        holdListe.add(hold);
        antalVirkDeltagere += hold.getAntalHoldDeltagere();
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


    //Delete Virk

}
