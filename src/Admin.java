import java.util.ArrayList;

public class Admin extends Person {
    //attribut
    private ArrayList<Participant> participants;
    private ArrayList<Firm> firms;
    private ArrayList<Team> teams;
    private Data data;

    //Constructor
    public Admin(Person person){
        super("","","");
        this.participants = new ArrayList<>();
        this.firms = new ArrayList<>();
        this.teams = new ArrayList<>();
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
    public void addFirm(Firm firm){

    }
    public void removeFirm(Firm firm){

    }
    public void changeFirmName(){

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
