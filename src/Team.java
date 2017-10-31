//Alexander Van Le && Oliver Lange

import java.util.ArrayList;

public class Team {
    private String teamName;
    private int numberOfTeamParticipants;
    private Firm firm;
    private Participant teamCaptain;

    private ArrayList <Participant> participants = new ArrayList<>();

    private static int numberOfTeams;


    //Constructor
    public Team(){
        this("Intet holdNavn", null);
    }

    public Team(String teamName, Firm firm){

        //variabler
        this.teamName = teamName;
        this.firm = firm;

        //static
        numberOfTeams++;
    }
    //Adder metoder
    public void addParticipant(Participant participant){
        participants.add(participant);
        numberOfTeamParticipants++;
    }

    //Getter metoder
    public String getTeamName(){
        return teamName;
    }

    public int getNumberOfTeamParticipants() {
        return numberOfTeamParticipants;
    }

    public ArrayList<Participant> getParticipants() {
        return participants;
    }

    public Participant getTeamCaptain() {
        return teamCaptain;
    }

    //Static getter
    public static int getNumberOfTeams() {
        return numberOfTeams;
    }

    //Setter metoder
    public void setTeamName(String teamName){
        this.teamName = teamName;
    }

    public void setTeamCaptain(Participant teamCaptain) {
        this.teamCaptain = teamCaptain;
    }

    //Delete

}
