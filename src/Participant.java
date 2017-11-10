//Alexander Van Le && Oliver Lange

import java.util.ArrayList;

public class Participant extends Person {
    //Variabler
//    private String participantName;
    private String cyclistType;
    //    private String participantEmail;
    private Firm firm;
    private Team team; // arraylist
    private int numberOfCyclictDays;
    private double numberOfKm;
    //    private String participantPassword;
    private String participantID;

    private static int numberOfParticipants = 0;
    private static ArrayList<Participant> participants = new ArrayList<>();
    private static int numberOfCyclingDaysAll = 0;
    private static double numberOfKmAll = 0;

    //Constructor
    public Participant(String name, String cyclistType, String email, String password) {
        super(name, email, password);
        //Der kan kun være 4 typer: Indsæt logik
        this.cyclistType = cyclistType;
        this.participantID = "#" + Integer.toString(numberOfParticipants + 1);

        //Static variabler definitioner
        numberOfParticipants++;
        participants.add(this);
    }

    public Participant(String participantName, String cyclistType, String participantEmail, Team team, Firm firm) {
        this(participantName, cyclistType, participantEmail);
        this.team = team;
        this.firm = firm;
    }

    public Participant(String participantName, String cyclistType, String participantEmail) {
        this(participantName, cyclistType, participantEmail, "Hej1");
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

    public void setFirm(Firm firm) {
        this.firm = firm;
    }
}
