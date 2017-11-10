//Alexander Van Le && Oliver Langeee

import java.util.ArrayList;
import java.util.regex.Pattern;

public class TeamCaptain extends Participant {

    //Constructor
    public TeamCaptain(Participant participant){
        super(participant);
    }

    public void removeParticipant(String string){
        int atPosition = string.indexOf("@");
        int dotPosition = string.lastIndexOf('.');

/*        System.out.println(string);
        System.out.println("a " + atPosition);
        System.out.println("d " + dotPosition);*/
        if (atPosition > 0 && dotPosition > atPosition && dotPosition < (string.length()-2) ) {
            //Er en email
            ArrayList<Participant> participants = Participant.getParticipants();

            //Loop igennem alle vores participants fra static arrayliste "participants"
            for (Participant p: participants) {
                //hvis den finder en matchende email
                if (p.getEmail().equals(string)){
                    //find index af participant i arrayliste "participants"
                    int i = participants.indexOf(p);
                    System.out.println("Deltager, " + p.getName() + ", er fjernet fra listen");

                    //midlertidig arrayliste til opbevaring af participants uden fjernet participant
                    ArrayList<Participant> arr = new ArrayList<>();
                    for (int j = 0; j < participants.size() - 1; j++){
                        //hvis j ikke er lige så stor som vores index af ønskede fjernet deltager
                        if (j != i){
                            //så tilføj participant i ny arrayliste
                            arr.add(Participant.getParticipants().get(j));
                        }
                    }
                    Participant.setParticipants(arr);
                }
            }

        } else{
            System.out.println("er ikke email");
        }

    }

}
