package Classes;//Alexander Van Le && Oliver Lange

import java.util.ArrayList;

public class Firm {
    private String firmName;
    private String firmID;

    private static int exclusiveFirmID = 0;
    private static ArrayList<Firm> firmList = new ArrayList<>();

    private ArrayList<Participant> participants = new ArrayList<>();
    private ArrayList<Team> teamList = new ArrayList<>();


    //Contructor
    public Firm(String firmName) {

        //Variable definitioner
        this.firmName = firmName;
        this.firmID = "#" + Integer.toString(exclusiveFirmID + 1);

        //Static variable definitioner
        exclusiveFirmID++;
        firmList.add(this);
    }

    //Addere
    public void addTeam (Team team){
        teamList.add(team);
    }

    //Setter
    public void setFirmName(String firmName) {
        this.firmName = firmName;
    }

    //Getter
    public String getFirmName() {
        return firmName;
    }

    public String getFirmID() {
        return firmID;
    }

    public int getNumberOfFirmParticipants() {
        int numberOfFirmParticipants = 0;

        for (Team team : this.teamList) {
            numberOfFirmParticipants += team.getParticipants().size();
        }
        return numberOfFirmParticipants;
    }

    public ArrayList<Participant> getParticipants() {
        return participants;
    }

    public ArrayList<Team> getTeamList() {
        return teamList;
    }

    //Static metoder
    public static int getNumberOfFirms() {
        return firmList.size();
    }

    public static ArrayList<Firm> getFirmList() {
        return firmList;
    }

    public static int getExclusiveFirmID() {
        return exclusiveFirmID;
    }




}
