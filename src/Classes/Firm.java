package Classes;//Alexander Van Le && Oliver Lange

import java.util.ArrayList;

public class Firm {
    private String firmName;
    private int numberOfFirmParticipants;

    private ArrayList<Participant> participants = new ArrayList<>();
    private ArrayList<Team> teamList = new ArrayList<>();

    private static int numberOfFirms;
    private static ArrayList<Firm> firmList = new ArrayList<>();

    //Contructor
    public Firm(String firmName) {

        //Variable definitioner
        this.firmName = firmName;

        //Static variable definitioner
        numberOfFirms++;
        firmList.add(this);
    }

    //Addere
    public void addTeam (Team team){
        teamList.add(team);
        numberOfFirmParticipants += team.getNumberOfTeamParticipants();
    }

    //Setter
    public void setFirmName(String firmName) {
        this.firmName = firmName;
    }

    //Getter
    public String getFirmName() {
        return firmName;
    }

    public int getNumberOfFirmParticipants() {
        return numberOfFirmParticipants;
    }

    public ArrayList<Participant> getParticipants() {
        return participants;
    }

    public ArrayList<Team> getTeam() {
        return teamList;
    }

    public ArrayList<Team> getTeamList() {
        return teamList;
    }

    public static int getNumberOfFirms() {
        return numberOfFirms;
    }

    public static ArrayList<Firm> getFirmList() {
        return firmList;
    }

    //Get fordeling af hold - mangler!


}
