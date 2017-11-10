package Data;

import Classes.Admin;
import Classes.Firm;
import Classes.Participant;
import Classes.TeamCaptain;

//Credits to Mikkel
public class Data {

    //Constructor
    public Data() {
        generateData();
    }


    public void generateData() {

        //*******************opret firma og hold*****************************
        //firma 1 - hold & og 2

        Admin adm1 = new Admin("Alex", ".@.@@", "Hej1");

        Firm firma1 = new Firm("firma1 - Arla");
/*
        Participant par1 = new Participant("Kesi Natteravn", "Kesi@gmail.com","Alex1", "Master");
        Participant par2 = new Participant("Jesus Kristus", "jesus@gmail.com","Alex1", "Master");
        Participant par3 = new Participant("Muhammed", "Muhammed@gmail.com","Alex1", "Master");
        Participant par4 = new Participant("Johannes Døbberen", "Johannes@gmail.com","Alex1",  "Master");
        par1.setFirm(firma1);
        par2.setFirm(firma1);
        par3.setFirm(firma1);
        par4.setFirm(firma1);


*/
        TeamCaptain tc1 = new TeamCaptain(new Participant("Frodo DatFrodo", "Frodo1@gmail.com","Alex1", "Master"));
        TeamCaptain tc2 = new TeamCaptain("Hej", "lol@.@", "Hej2", "Master");




    }

}


