//Alexander Van Lee

package Actions;

import Classes.Participant;
import Classes.Team;

public class ShowTeamInformation {
    public ShowTeamInformation(){}

    public void run (Team team){
        int number = 1;

        System.out.println("Navn på hold: " + team.getTeamName() + "\t" + "Firma: " + team.getFirm().getFirmName());
        System.out.println("Holdkaptain: " + team.getTeamCaptain().getName());
        System.out.println("Medlemmere:");
        for (Participant participant: team.getParticipants()) {
            System.out.println(number++ + ")\t" + participant.getName());
        }
    }
}
