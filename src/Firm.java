import java.util.ArrayList;

public class Firm {
    private String firmName;
    private int numberOfFirmParticipants;

    private ArrayList<Participant> participants = new ArrayList<>();
    private ArrayList<Team> holdListe = new ArrayList<>();

    private static int numberOfFirms;
    private static ArrayList<Firm> firmList = new ArrayList<>();

    //Contructor
    public Firm() {
    }

    public Firm(String firmName) {

        //Variable definitioner
        this.firmName = firmName;

        //Static variable definitioner
        numberOfFirms++;
        firmList.add(this);
    }

    //Addere
    public void addFirm (Firm firm){

        firmList.add(firm);
        numberOfFirmParticipants += Team.getnumberOfFirmParticipants();
    }

    //Setter
    public void setVirkNavn(String firmName) {
        this.firmName = firmName;
    }

    //Getter
    public String getFirmName() {
        return firmName;
    }

    public int getnumberOfFirmParticipants() {
        return getnumberOfFirmParticipants();
    }

    public ArrayList<Participant> getParticipants() {
        return participants;
    }

    public ArrayList<Firm> getFirm() {
        return firmList;
    }

    //Get fordeling af hold - mangler!


    //Delete Virk

}
