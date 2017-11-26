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
        Admin adm1 = generateAdmin("Alex", ".@.@@", "Hej1");

        //firmless
        Participant lol = generateParticipant("Lol Natteravn", "lol@gmail.com","Alex1", "Master");

        //Arla
        Firm arla = generateFirm("Arla");

            //folk fra The sharks
            Team team1 = generateTeam("The Sharks", arla);
            generateTeamCaptain("Frodo DatFrodo", "frodo@gmail.com","Alex1", "Master").setTeam(team1);
            generateParticipant("Kesi Natteravn", "Kesi@gmail.com","Alex1", "Master").setTeam(team1);
            generateParticipant("Jesus Kristus", "jesus@gmail.com","Alex1", "Master").setTeam(team1);
            generateParticipant("Muhammed", "Muhammed@gmail.com","Alex1", "Master").setTeam(team1);
            generateParticipant("Johannes Døbberen", "Johannes@gmail.com","Alex1",  "Master").setTeam(team1);

            //Folk fra død
            Team team2 = generateTeam("død", arla);
            generateTeamCaptain("Hej", "lol@.@", "Hej2", "Master").setTeam(team2);
            generateParticipant("Kesi", "k@mail.com","Alex1", "Master").setTeam(team2);
            generateParticipant("Meme", "m@mail.com","Alex1", "Master").setTeam(team2);


        //NONO
        Firm nono = generateFirm("Nono");

            //Team 3
            Team team3 = generateTeam("Slagter", nono);
            generateTeamCaptain("Frodo DatFrodo", "frodo@asd.com","Alex1", "Master").setTeam(team3);
            generateParticipant("Kesi Natteravn", "Kesi@asd.com","Alex1", "Master").setTeam(team3);
            generateParticipant("Jesus Kristus", "jesus@asd.com","Alex1", "Master").setTeam(team3);
            generateParticipant("Muhammed", "Muhammed@sa.com","Alex1", "Master").setTeam(team3);
            generateParticipant("Johannes Døbberen", "Johannes@asd.com","Alex1",  "Master").setTeam(team3);

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


