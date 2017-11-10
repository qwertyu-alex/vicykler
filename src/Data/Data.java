package Data;

import Classes.Admin;
import Classes.Firm;
import Classes.Participant;
import Classes.TeamCaptain;
import Classes.Team;

//Credits to Mikkel
public class Data {

    //Constructor
    public Data() {
        generateData();
    }


    public void generateData() {
        Admin adm1 = new Admin("Alex", ".@.@@", "Hej1");

        //firmless
        Participant lol = new Participant("Lol Natteravn", "lol@gmail.com","Alex1", "Master");

        Firm firma1 = new Firm("firma1 - Arla");
        Team team1 = new Team("The Sharks", firma1);
        Team team2 =  new Team("død", firma1);


        //folk fra The sharks
        Participant par1 = new Participant("Kesi Natteravn", "Kesi@gmail.com","Alex1", "Master");
        Participant par2 = new Participant("Jesus Kristus", "jesus@gmail.com","Alex1", "Master");
        Participant par3 = new Participant("Muhammed", "Muhammed@gmail.com","Alex1", "Master");
        Participant par4 = new Participant("Johannes Døbberen", "Johannes@gmail.com","Alex1",  "Master");
        par1.setTeam(team1);
        par2.setTeam(team1);
        par3.setTeam(team1);
        par4.setTeam(team1);

        TeamCaptain tc1 = new TeamCaptain(new Participant("Frodo DatFrodo", "frodo@mail.com","Alex1", "Master"));
        TeamCaptain tc2 = new TeamCaptain("Hej", "lol@.@", "Hej2", "Master");
        tc1.setTeam(team1);

        //Folk fra død
        Participant ppar1 = new Participant("Kesi", "k@mail.com","Alex1", "Master");
        ppar1.setTeam(team2);
    }
}


