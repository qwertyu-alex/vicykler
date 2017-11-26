//Alexander Van Lee && Oliver Lange

package Actions;

import Classes.Participant;

import java.util.ArrayList;
import java.util.Scanner;

public class SearchForParticipant {

    public static Participant run(ArrayList<Participant> participants){
        if (participants.size() < 1){
            System.out.println("Ingen deltagere");
            return null;
        }


        Scanner input = new Scanner(System.in);

        while (true){
            System.out.println("Indtast email:");
            String string = input.nextLine().toLowerCase();
            //find @ og . i strengen
            int atPosition = string.indexOf("@");
            int dotPosition = string.lastIndexOf('.');

            if (atPosition > 0 && dotPosition > atPosition && dotPosition < (string.length()-2) && string.lastIndexOf("@") == string.indexOf("@") ) {
                //Loop igennem alle vores participants fra arrayliste "participants"
                for (Participant foundParticipant: participants) {
                    //se om der er en matchende email og retuner hvis der er
                    if (foundParticipant.getEmail().toLowerCase().equals(string)){
                        return foundParticipant;
                    }
                }
            }
            System.out.println("Intet match - Vil du prøve igen?");
            System.out.println("1) Ja \t Andet) Nej");
            String answer = input.nextLine();
            if (!answer.equals("1")){
                return null;
            }
        }

    }
}
