import java.util.ArrayList;

public class Participant {
    //Variabler
    private String participantName;
    private String cyclistType;
    private String participantEmail;
    private Firm firm;
    private Team team; // arraylist
    private int numberOfCyclictDays;
    private double numberOfKm;
    private String participantPassword;

    private static int numberOfParticipants = 0;
    private static ArrayList<Participant> participants = new ArrayList<>();
    private static int numberOfCyclingDaysAll = 0;
    private static double numberOfKmAll = 0;

    //Constructor
    public Participant(){
    }

    public Participant(String participantName, String cyclistType, String participantEmail, String participantPassword){
        this.participantName = participantName;
        //Der kan kun være 4 typer: Indsæt logik
        this.cyclistType = cyclistType;
        this.participantEmail = participantEmail;
        this.participantPassword = participantPassword;

        //Static variabler definitioner
        numberOfParticipants++;
        participants.add(this);
    }

    //Adder
    public void addCyclistDays(){
        numberOfCyclictDays++; //5+1 = 6 dage person
        numberOfCyclingDaysAll++;
    }

    public void addNumberOfKmAll(int km){
        numberOfKmAll -= numberOfKm;
        numberOfKm += km;
        numberOfKmAll += numberOfKm;
    }


    //Getter
    public String getCyclistType() {
        return cyclistType;
    }

    public String getParticipantName() {
        return participantName;
    }

    public String getParticipantEmail() {
        return participantEmail;
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

    public String getPassword() {
        return participantPassword;
    }

    public String getInfo(){
        //Kode mangler
        return null;
    }

    //Static Getter
    public static int getNumberOfParticipants(){
        return numberOfParticipants;
    }

    public static ArrayList<Participant> getParticipants() {
        return participants;
    }

    //Setter
    public void setCyklistType(String cyclistType) {
        this.cyclistType= cyclistType;
    }

    public void setDeltagerNavn(String participantName) {
        this.participantName = participantName;
    }

    public void setParticipantEmail(String participantEmail) {
        this.participantEmail = participantEmail;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    public void setFirm(Firm firm) {
        this.firm = firm;
    }

    public void setPassword(String participantPassword) {
        this.participantPassword = participantPassword;
    }
}
