import java.util.ArrayList;

public class Virksomhed {
    private String virkNavn;
    private int antalVirkDeltagere;

    private ArrayList<Deltager> deltagere;
    private ArrayList<Hold> hold;

    private static int antalVirk;

    // Oprette En Contructor
    public Virksomhed(String virkNavn, int antalVirkDeltagere) {
        this.virkNavn = virkNavn;
        this.antalVirkDeltagere = antalVirkDeltagere;
    }

    // Oprette Setter Metode
    public void setVirkNavn(String virkNavn) {
        this.virkNavn = virkNavn;
    }

    // Oprette Getter Metode
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
        return hold;
    }

    //Get fordeling af hold - mangler!


    //Add deltagere og hold


    //Delete Virk

}
