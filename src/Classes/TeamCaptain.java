package Classes;//Alexander Van Le && Oliver Langeee

import java.util.*;
import java.util.ArrayList;

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


    public void removeParticipant(){
        Scanner input = new Scanner(System.in);
        String string;
        ArrayList<Participant> participantsInTheTeam = this.getTeam().getParticipants();


        System.out.println("Hvem vil du fjerne?");
        for (Participant participant: participantsInTheTeam ) {
            if (participant != this){
                System.out.println(participant.getEmail());
            }
        }

        //string kan være email eller ID
        string = input.next().toLowerCase();

        int atPosition = string.indexOf("@");
        int dotPosition = string.lastIndexOf('.');

        //Tjek hvis det er en email
        if (atPosition > 0 && dotPosition > atPosition && dotPosition < (string.length()-2) ) {
            //Loop igennem alle vores participants fra static arrayliste "participants"
            for (Participant foundParticipant: participantsInTheTeam) {
                //se om der er en matchende email
                if (foundParticipant.getEmail().toLowerCase().equals(string)){
                    //metode som finder den i arraylisten og fjerner den fra systemet
                    if (findAndRemove(foundParticipant, participantsInTheTeam)){
                        return;
                    }
                }
            }
        }

        System.out.println("Intet match - Vil du prøve igen?");
        System.out.println("1) Ja \t 2) Nej");
        String answer = input.next();
        if (answer.equals("1")){
            removeParticipant();
        }

    }

    private boolean findAndRemove (Participant foundParticipant, ArrayList<Participant> participantsInTheTeam){
        //find index af participant i arrayliste "participants"
        int i = participantsInTheTeam.indexOf(foundParticipant);
        System.out.println("Deltager, " + foundParticipant.getName() + ", er fjernet fra listen");
        System.out.println();
        foundParticipant.removeParticipant(i);
        foundParticipant = null;
        return true;
    }

}
