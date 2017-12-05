//Mikkel Storm

package Data;

import Classes.*;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Data {
    private ArrayList<Firm> firms = new ArrayList<>();
    private ArrayList<Team> teams = new ArrayList<>();
    private ArrayList<Person> persons = new ArrayList<>();
    private ArrayList<Participant> participants = new ArrayList<>();
    private ArrayList<TeamCaptain> teamCaptains = new ArrayList<>();
    private ArrayList<Admin> admins = new ArrayList<>();


    //Constructor

    public Data() {
    }

    public void generateData() {
        Admin adm1 = generateAdmin("Admin1", "support@vicykler.dk", "1234");

        //firmless
        Participant lol = generateParticipant("Brian Larsen", "Brian@gmail.com","4321", "Master");

        //Arla
        Firm arla = generateFirm("Arla");

            //folk fra The sharks
            Team team1 = generateTeam("Tonserne", arla);
            generateTeamCaptain("Flemming Sørensen", "Flemming.S@gmail.com","4321", "Master").setTeam(team1);
            generateParticipant("Søren Henriksen", "Søren.H@gmail.com","4321", "Master").setTeam(team1);
            generateParticipant("Tina Eriksen", "Tina.E@gmail.com","4321", "Master").setTeam(team1);
            generateParticipant("Muhammed Ali", "Muhammed.A@gmail.com","4321", "Master").setTeam(team1);
            generateParticipant("Torben Torbensen", "Torben.T@gmail.com","4321",  "Master").setTeam(team1);

            //Folk fra død
            Team team2 = generateTeam("Anden holdet", arla);
            generateTeamCaptain("Birthe Kjær", "Birthe.K@gmail.com", "9876", "Master").setTeam(team2);
            generateParticipant("Richard Ragnvald", "Richard.R@gmail.com","9876", "Master").setTeam(team2);
            generateParticipant("Peter Belli", "Ulven@gmail.com","9876", "Master").setTeam(team2);


        //NONO
        Firm postnord = generateFirm("Postnord");

            //Team 3
            Team team3 = generateTeam("Cykelbudene", postnord);
            generateTeamCaptain("Per Person", "Per.P@gmail.com","6789", "Master").setTeam(team3);
            generateParticipant("Tim Flemmingsen", "Tim.F@gmail.com","6789", "Master").setTeam(team3);
            generateParticipant("Simon Thiesen", "Simon.T@gmail.com","6789", "Master").setTeam(team3);
            generateParticipant("Carsten Madsen", "Carsten.M@gmail.com","6789", "Master").setTeam(team3);
            generateParticipant("Jonas Johansen", "Jonas.J@gmail.com","6789",  "Master").setTeam(team3);

    }

    public Admin generateAdmin(String name, String email, String password){
        Admin newAdmin = new Admin(name, email, password);
        admins.add(newAdmin);
        persons.add(newAdmin);
        return newAdmin;
    }

    public TeamCaptain generateTeamCaptain(String name, String email, String password, String cyclistType){
        TeamCaptain newTeamCaptain = new TeamCaptain(name, email, password, cyclistType);
        teamCaptains.add(newTeamCaptain);
        persons.add(newTeamCaptain);
        return newTeamCaptain;
    }

    public Participant generateParticipant(String name, String email, String password, String cyclistType){
        Participant newParticipant = new Participant(name, email, password, cyclistType);
        participants.add(newParticipant);
        persons.add(newParticipant);
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

    public ArrayList<Person> getPersons() {
        return persons;
    }

    public ArrayList<Admin> getAdmins() {
        return admins;
    }
}


