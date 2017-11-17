//Mikkel Storm && Astid Christensen

package Classes;

import java.util.ArrayList;
import java.util.Scanner;

import Data.Data;
import Actions.SearchForParticipant;
import Actions.SearchForTeam;


public class Admin extends Person {
    //attributer
    private ArrayList<Participant> participants;
    private ArrayList<Team> teams;
    private Data data;
    private Scanner input = new Scanner(System.in);

    //Constructor
    public Admin(String name, String email, String password){
        super(name,email,password);
    }


    //Astrid

    //Sletter deltager fra programmet
    public void deleteParticipant(){
    }

    //sletter deltager fra hold
    /*
    public void removeParticipant(){

        System.out.println("Sletter deltager");

        //Denne metode finder en participant ud fra en mail
        Participant newParticipant = new SearchForParticipant().run(data.getParticipants());

        //Denne metode sletter deltageren
        System.out.println("Sletter " + newParticipant.getName());
        newParticipant.removeParticipant();
    }*/
    /*
    public void removeTeam(){

        ArrayList<Team> listTeam = new ArrayList<>();

        //Oprettet en liste over alle hold der findes
        for (Firm firm:data.getFirms()) {
            for (Team team:firm.getTeamList()) {
                listTeam.add(team);
            }
        }

        //Her finder det hold i listen vi vil slette
        Team foundTeam = new SearchForTeam().run(listTeam);

        System.out.println("Du har valgt hold " + foundTeam.getTeamName());
        foundTeam.removeTeam();
        foundTeam = null;
    }*/



    //Mikkel
    //Denne metode tilføjer et firma til listen over firmaer.
    public void addFirm(){
        //henter Arraylisten over firmaer
        ArrayList<Firm> firms =  data.getFirms();

        System.out.println("Tilføj firma menu");
        System.out.println("Indtast navn på det nye firma");
        String firmName = input.nextLine();
        //Tilføjer det indtastede navn på firmaet til Arraylisten over firmaer.
        firms.add(new Firm(firmName));
        System.out.printf("Du har nu tilføjet firmaet %s til listen over firmaer",firmName);
    }
    //Herunder kan der slettes et firma fra Arraylisten "Firms"
    public void deleteFirm(){
        //Henter Arraylisten over firmaer
        ArrayList<Firm> firms =  data.getFirms();
        //Printer listen over firmaer
        System.out.println("Slet firma menu");
        System.out.println("Liste over firmaer");
        System.out.printf("%-5s %s","Nr:","Firmanavn");
        int i = 1;
        for(Firm firm : firms){
            System.out.printf("\n%-5d %s",i++,firm.getFirmName());
        }
        //sletter indtastede firma fra listen over firmaer
        System.out.println("\nIndtast nummmer på firma du vil slette");
        int removeFirm = input.nextInt();
        System.out.printf("Du har nu slette firmaet %s fra listen over firmaer",firms.get(removeFirm-1).getFirmName() );
        firms.remove(removeFirm-1);
    }
    //Metoden herunder giver mulighed for at ændre et firma's navn, med en en sikkerhedsforanstilting
    //der sikre man ændre det rigtige firmas navn
    public void changeFirmName(){
        //henter Arraylisten over firmaer
        ArrayList<Firm> firms =  data.getFirms();
        //Printer listen over firmaer
        System.out.println("Ændre firma navn menu");
        System.out.printf("%-5s %s","Nr:","Firma navn");
        int i = 1;
        for(Firm firm : firms){
            System.out.printf("\n%-5d %s",i++,firm.getFirmName());
        }
        //Giver mulighed for at vælge et firma man vil ændre navnet på
        //Sikkerhedsforanstalting sikre man ikke ændre navnet på det forkerte firma.
        boolean safetyCheck = false;
        int numOfFirm;
        do {
            System.out.println("\nIndtast nummmer på firma du vil ændre navn på");
            numOfFirm = input.nextInt();
            System.out.printf("Vil du ændre navnet på firmaet %s (j/n)", firms.get(numOfFirm - 1).getFirmName());
            String answer = input.nextLine();
            if (answer.equalsIgnoreCase("j"))
                safetyCheck = true;
        }while(!safetyCheck);
        System.out.printf("Hvad vil du ændre firmaet %s's navn til?",firms.get(numOfFirm - 1).getFirmName());
        //ændre navnet fra det gamle til det man indtaster nedenfor
        String newFirmName = input.nextLine();
        firms.get(numOfFirm-1).setFirmName(newFirmName);
    }
    //Nedenstående metode giver mulighed for at ændre et holds navn
    public void changeTeamName(){
        //Henter Aarraylisten over firmaer
        ArrayList<Firm> firms = data.getFirms();

        System.out.println("Ændre hold navn menu");
        System.out.printf("%-5s %s","Nr:","Firma navn");
        int i = 1;
        for(Firm firm : firms){
            System.out.printf("\n%-5d %s",i++,firm.getFirmName());
        }
        System.out.println("\nVælg firma du vil ændre et hold navn i");
        int numOfFirm = input.nextInt()-1;
        System.out.printf("%-5s %s","Nr:","hold navn");
        i = 1;
        for (Team team:firms.get(numOfFirm).getTeamList()) {
            System.out.printf("\n%-5d %s",i++,team.getTeamName());
        }

        System.out.println("\nVælg hold du vil ændre navn på");
        int numOfTeam = input.nextInt()-1;
        System.out.println("Du har valgt at ændre navnet på holdet: " + firms.get(numOfFirm).getTeamList().get(numOfTeam).getTeamName());
        System.out.println("Hvad vil du ændre navnet til?");
        String antibug = input.nextLine();
        String newTeamName = input.nextLine();
        firms.get(numOfFirm).getTeamList().get(numOfTeam).setTeamName(newTeamName);
        System.out.println("Du har ændret navnet på holdet til: " + newTeamName);
    }

    //Opret et hold
    public void createTeam(){

    }
    //Tilføj ekstra admin
    public void addAdmin(){

    }
    //Viser informationer om en bestemt deltager
    public void ParticipantInformation(){

    }
    //Statistik over et firmaer og tilhørende holdkaptajner
    public void firmInformation() {

    }
    //Informationer om hold og deltagere
    public void teamInformation(){

    }





}
