import java.util.ArrayList;

public class Team { //Hold
    private String teamName; //holdNavn
    private int numberOfTeamParticipants; //antalHoldDeltagere
    private Firm firm; //Virksomhed
    private Participant teamCaptain; //Deltager holdKaptajn

    private ArrayList <Participant> participant = new ArrayList<>();

    private static int numberOfTeams; //antalhold


    //Constructor
    public Team(){
        this("Intet holdNavn", null);
    }

    public Hold(String teamName, Firm firm){

        //variabler
        this.teamName = teamName;
        this.firm = firm;

        //static
        numberOfTeams++;
    }

    //Adder metoder
    public void addParticipant(Deltager deltager){
        participant.add(participant);
        numberOfTeamParticipants++;
    }

    //Getter metoder
    public String getTeamName(){
        return teamName;
    }

    public int getNumberOfTeamParticipants() {
        return numberOfTeamParticipants;
    }

    public ArrayList<Deltager> getParticipants() {
        return;
    }

    public Deltager getTeamCaptain() {
        return teamCaptain;
    }

    //Static getter
    public static int getNumberOfTeams() {
        return numberOfTeams;
    }

    //Setter metoder
    public void setHoldNavn(String teamName){
        this.teamName = teamName;
    }

    public void setHoldkaptajn(Deltager holdkaptajn) {
        this.teamCaptain = teamCaptain;
    }

    //Delete

}
