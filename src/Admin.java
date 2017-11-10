import java.util.ArrayList;
import java.util.Scanner;

public class Admin extends Person {
    //attribut
    private ArrayList<Participant> participants;
    private ArrayList<Firm> firms;
    private ArrayList<Team> teams;
    private Data data;
    private Scanner input;

    //Constructor
    public Admin(Person person){
        super("","","");
        this.participants = new ArrayList<>();
        this.firms = new ArrayList<>();
        this.teams = new ArrayList<>();
        this.input = new Scanner(System.in);
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
        System.out.println("Tilføj firma menu");
        System.out.println("Indtast navn på det nye firma");
        String firmName = input.nextLine();
        firms.add(new Firm(firmName));
        System.out.printf("Du har nu tilføjet firmaet %s til listen over firmaer",firmName);
    }
    public void removeFirm(){
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
            System.out.printf("Vil du ændre navnet på firmaet %s (j/n)", firms.get(numOfFirm - 1));
            String answer = input.nextLine();
            if (answer.equalsIgnoreCase("j"))
                safetyCheck = true;
        }while(!safetyCheck);
        System.out.printf("Hvad vil du ændre firmaet %s's navn til?",firms.get(numOfFirm-1));
        String newFirmName = input.nextLine();
        firms.get(numOfFirm-1).setFirmName(newFirmName);
    }


    //Getters
    public ArrayList<Participant> getParticipants() {
        return participants;
    }
    public ArrayList<Firm> getFirms() {
        return firms;
    }
    public ArrayList<Team> getTeams() {
        return teams;
    }
}
