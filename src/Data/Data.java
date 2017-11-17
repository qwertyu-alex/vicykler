//Mikkel Storm

package Data;

import Classes.Admin;
import Classes.Firm;
import Classes.Participant;
import Classes.TeamCaptain;
import Classes.Team;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Data {
    private ArrayList<Firm> firms = new ArrayList<>();
    private ArrayList<Team> teams = new ArrayList<>();
    private ArrayList<Participant> participants = new ArrayList<>();
    private ArrayList<TeamCaptain> teamCaptains = new ArrayList<>();

    //Constructor

    public Data() {
        generateData();
    }

    public void generateData() {
        Admin adm1 = new Admin("Alex", ".@.@@", "Hej1");

        //firmless
        Participant lol = new Participant("Lol Natteravn", "lol@gmail.com","Alex1", "Master");

        Firm firma1 = generateFirm("Arla");
        Firm firma2 = generateFirm("NONO");

        Team team1 = generateTeam("The Sharks", firma1);
        Team team2 =  generateTeam("død", firma1);


        //folk fra The sharks
        generateParticipant("Kesi Natteravn", "Kesi@gmail.com","Alex1", "Master").setTeam(team1);
        generateParticipant("Jesus Kristus", "jesus@gmail.com","Alex1", "Master").setTeam(team1);
        generateParticipant("Muhammed", "Muhammed@gmail.com","Alex1", "Master").setTeam(team1);
        generateParticipant("Johannes Døbberen", "Johannes@gmail.com","Alex1",  "Master").setTeam(team1);


        TeamCaptain tc1 = generateTeamCaptain(generateParticipant("Frodo DatFrodo", "frodo@gmail.com","Alex1", "Master"));
        TeamCaptain tc2 = generateTeamCaptain(generateParticipant("Hej", "lol@.@", "Hej2", "Master"));

        tc1.setTeam(team1);
        tc2.setTeam(team2);

        //Folk fra død
        Participant ppar1 = generateParticipant("Kesi", "k@mail.com","Alex1", "Master");
        ppar1.setTeam(team2);
    }

    public TeamCaptain generateTeamCaptain(Participant participant){
        TeamCaptain newTeamCaptain = new TeamCaptain(participant);
        teamCaptains.add(newTeamCaptain);
        return newTeamCaptain;
    }

    public Participant generateParticipant(String name, String email, String password, String cyclistType){
        Participant newParticipant = new Participant(name, email, password, cyclistType);
        participants.add(newParticipant);
        return newParticipant;
    }

    public Team generateTeam(String teamName, Firm firm){
        Team newTeam = new Team(teamName, firm);
        teams.add(newTeam);
        return newTeam;
    }

    public Firm generateFirm(String firmName){
        Firm newFirm = new Firm(firmName);
        firms.add(newFirm);
        return newFirm;
    }

    public ArrayList<Firm> getFirms() {
        return firms;
    }

    public ArrayList<Team> getTeams() {
        return teams;
    }

    public ArrayList<Participant> getParticipants() {
        return participants;
    }

    public ArrayList<TeamCaptain> getTeamCaptains() {
        return teamCaptains;
    }

}


