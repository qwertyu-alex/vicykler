public class Deltager {
    //Variabler
    private String cyklistType;
    private String deltagerNavn;
    private String deltagerEmail;
    private Virksomhed virksomhed;
    private Hold hold;
    private int cykelDage;
    private double antalKm;

    private static int antalDeltagere = 0 ;
    private static int antalCykelDageAlle = 0;
    private static double antalKmAlle = 0;



    //Constructor
    public Deltager(){
    }


    public Deltager(String deltagerNavn, String cyklistType, String deltagerEmail, Hold hold, Virksomhed virksomhed){
        this.deltagerNavn = deltagerNavn;
        //Der kan kun være 4 typer: Indsæt logik
        this.cyklistType = cyklistType;
        this.deltagerEmail = deltagerEmail;
        this.hold = hold;
        this.virksomhed = virksomhed;


        //Static variabler definitioner
        antalDeltagere++;
    }

/*
    public Deltager(String cyklistType, String deltagerNavn, String deltagerEmail,
                         Virksomhed virksomhed, Hold hold, int cykelDage, double antalKm){

        //Variable definitioner
        this.cyklistType = cyklistType;
        this.deltagerNavn = deltagerNavn;
        this.deltagerEmail = deltagerEmail;
        this.virksomhed = virksomhed;
        this.hold = hold;
        this.cykelDage = cykelDage;
        this.antalKm = antalKm;

        antalCykelDageAlle += cykelDage;
    }*/

    //Adder
    public void addCykelDage(){
        cykelDage++; //5+1 = 6 dage person
        antalCykelDageAlle++;
    }

    public void addAntalKmAlle(int km){
        antalKmAlle -= antalKm;
        antalKm += km;
        antalKmAlle += antalKm;
    }


    //Getter
    public String getCyklistType() {
        return cyklistType;
    }

    public String getDeltagerNavn() {
        return deltagerNavn;
    }

    public String getDeltagerEmail() {
        return deltagerEmail;
    }

    public Hold getHold() {
        return hold;
    }

    public Virksomhed getVirksomhed() {
        return virksomhed;
    }

    public String getInfo(){
        //Kode mangler
        return null;
    }

    //Static Getter
    public static int getAntalDeltagere(){
        return antalDeltagere;
    }

    //Setter
    public void setCyklistType(String cyklistType) {
        this.cyklistType = cyklistType;
    }

    public void setDeltagerNavn(String deltagerNavn) {
        this.deltagerNavn = deltagerNavn;
    }

    public void setDeltagerEmail(String deltagerEmail) {
        this.deltagerEmail = deltagerEmail;
    }


}
