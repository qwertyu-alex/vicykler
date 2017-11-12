package Classes;//Alexander Van Le && Oliver Lange

import java.util.ArrayList;

public class Team {
    private String teamName;
    private int numberOfTeamParticipants;
    private Firm firm;
    private TeamCaptain teamCaptain;

    private ArrayList <Participant> participants = new ArrayList<>();

    private static int numberOfTeams;


    //Constructor
    public Team(String teamName, Firm firm){
        //variabler
        this.teamName = teamName;
        this.firm = firm;
        firm.addTeam(this);

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

    public Firm getFirm() {
        return firm;
    }

    public ArrayList<Participant> getParticipants() {
        return participants;
    }

    public TeamCaptain getTeamCaptain() {
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

    public void setTeamCaptain(TeamCaptain teamCaptain) {
        this.teamCaptain = teamCaptain;
        if (teamCaptain.getTeam() != this){
            teamCaptain.setTeam(this);
        }
    }

    //Remove
    public void removeParticipant(Participant participant){
        participants.remove(participant);
    }

}
