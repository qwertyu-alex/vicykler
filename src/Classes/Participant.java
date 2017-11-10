package Classes;//Alexander Van Le && Oliver Lange

import java.util.ArrayList;

public class Participant extends Person {
    //Variabler
    private String cyclistType;
    private Firm firm = null;
    private Team team = null; // arraylist
    private int numberOfCyclictDays;
    private double numberOfKm;
    private String participantID;

    private static int numberOfParticipants = 0;
    private static ArrayList<Participant> participants = new ArrayList<>();
    private static int numberOfCyclingDaysAll = 0;
    private static double numberOfKmAll = 0;

    //Constructor
    public Participant(String name, String email, String password, String cyclistType) {
        super(name, email, password);

        //Der kan kun være 4 typer: Indsæt logik
        this.cyclistType = cyclistType;
        this.participantID = "#" + Integer.toString(numberOfParticipants + 1);

        //Static variabler definitioner
        numberOfParticipants++;
        participants.add(this);
    }

    //Overloaded contructor
    public Participant(Participant participant){
        super(participant.getName(), participant.getEmail(), participant.getPassword());
        this.cyclistType = participant.getCyclistType();
        //hvis der er forbundet et hold;
        if (participant.getTeam() != null){
            this.team = participant.getTeam();
        }
        //hvis der er forbundet et firma;
        if (participant.getFirm() != null){
            this.firm = participant.getFirm();
        }

    }

    //Adder
    public void addCyclistDays() {
        numberOfCyclictDays++; //5+1 = 6 dage person
        numberOfCyclingDaysAll++;
    }

    public void addNumberOfKmAll(int km) {
        numberOfKmAll -= numberOfKm;
        numberOfKm += km;
        numberOfKmAll += numberOfKm;
    }


    //Getter
    public String getCyclistType() {
        return cyclistType;
    }

    public Team getTeam() {
        return team;
    }

    public Firm getFirm() {
        return firm;
    }

    public double getNumberOfKm() {
        return numberOfKm;
    }

    public int getNumberOfCyclictDays() {
        return numberOfCyclictDays;
    }

    public static int getNumberOfCyclingDaysAll() {
        return numberOfCyclingDaysAll;
    }

    public static double getNumberOfKmAll() {
        return numberOfKmAll;
    }

    public String getparticipantID() {
        return participantID;
    }

    public String getInfo() {
        //Kode mangler
        return null;
    }

    //Static Getter
    public static int getNumberOfParticipants() {
        return numberOfParticipants;
    }

    public static ArrayList<Participant> getParticipants() {
        return participants;
    }

    //Setter
    public void setCyklistType(String cyclistType) {
        this.cyclistType = cyclistType;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    public static void setParticipants(ArrayList<Participant> participants) {
        Participant.participants = participants;
    }

    public void setFirm(Firm firm) {
        this.firm = firm;
    }

    public void removeParticipant(int index){
        //fjerner deltageren fra personer
        this.removePerson(this);

        //fjerner deltageren fra deltagerlisten
        participants.remove(index);

    }
}
