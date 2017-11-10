package Classes;//Alexander Van Le && Oliver Langeee

import java.util.ArrayList;
import java.util.regex.Pattern;

public class TeamCaptain extends Participant {
    //Constructor
    public TeamCaptain(Participant participant){
        super(participant);

        //fjern personen fra deltager listen og gør ham i stedet for til en holdkaptain
        participant.removePerson(participant);
    }

    public TeamCaptain(String name, String email, String password, String cyclistType){
        super(name, email, password, cyclistType);
    }


    public void removeParticipant(String string){
        //string kan være email eller ID
        string = string.toLowerCase();
        int atPosition = string.indexOf("@");
        int dotPosition = string.lastIndexOf('.');
        ArrayList<Participant> participants = Participant.getParticipants();

        //Tjek hvis det er en email
        if (atPosition > 0 && dotPosition > atPosition && dotPosition < (string.length()-2) ) {
            //Er en email

            //Loop igennem alle vores participants fra static arrayliste "participants"
            for (Participant p: participants) {
                //se om der er en matchende email
                if (p.getEmail().equals(string)){
                    //se om de deltageren er i samme hold som holdkaptajnen
                    if (this.getTeam().equals(p.getTeam())){
                        //metode som finder den i arraylisten og fjerner den fra systemet
                        findAndRemove(p, participants);
                        //gå ud af loop
                        break;
                    }



                }
            }

        }

    }

    private void findAndRemove(Participant p, ArrayList<Participant> participants){
        //find index af participant i arrayliste "participants"
        int i = participants.indexOf(p);
        System.out.println("Deltager, " + p.getName() + ", er fjernet fra listen");
        p.removeParticipant(i);
        p = null;
    }

}
