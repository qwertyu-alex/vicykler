package Classes;

import java.util.ArrayList;
import java.util.Scanner;
import Data.Data;



public class Admin extends Person {
    //attribut
    private ArrayList<Participant> participants;
    private ArrayList<Team> teams;
    private Data data;
    private Scanner input = new Scanner(System.in);

    //Constructor
    public Admin(String name, String email, String password){
        super(name,email,password);
    }

    public void removeParticipant(Participant participant){
        participants.remove(participant);

        //Astrid
    }
    public void addParticipant(Participant participant){
    }
    public void removeTeam(){

    }
    public void addTeam(){

    }

    //Mikkel
    public void addFirm(){
        ArrayList<Firm> firms =  Firm.getFirmList();

        System.out.println("Tilføj firma menu");
        System.out.println("Indtast navn på det nye firma");
        String firmName = input.nextLine();
        firms.add(new Firm(firmName));
        System.out.printf("Du har nu tilføjet firmaet %s til listen over firmaer",firmName);
    }
    public void removeFirm(){
        ArrayList<Firm> firms =  Firm.getFirmList();

        System.out.println("Slet firma menu");
        System.out.println("Liste over firmaer");
        System.out.printf("%-5s %s","Nr:","Firmanavn");
        int i = 1;


        for(Firm firm : firms){
            System.out.printf("\n%-5d %s",i++,firm.getFirmName());
        }
        System.out.println("\nIndtast nummmer på firma du vil slette");
        int removeFirm = input.nextInt();
        System.out.printf("Du har nu slette firmaet %s fra listen over firmaer",firms.get(removeFirm-1).getFirmName() );
        firms.remove(removeFirm-1);
    }
    public void changeFirmName(){
        ArrayList<Firm> firms =  Firm.getFirmList();

        System.out.println("Ændre firma navn menu");
        System.out.printf("%-5s %s","Nr:","Firmanavn");
        int i = 1;
        for(Firm firm : firms){
            System.out.printf("\n%-5d %s",i++,firm.getFirmName());
        }
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
        System.out.printf("Hvad vil du ændre firmaet %s's navn til?",firms.get(numOfFirm-1).getFirmName());
        String newFirmName = input.nextLine();
        firms.get(numOfFirm-1).setFirmName(newFirmName);
    }

    public void addAdmin(){

    }
}
