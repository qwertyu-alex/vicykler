//Alexander Van Le

package Actions;

import Classes.Participant;
import Classes.Team;

public class ShowTeamInformation {
    public ShowTeamInformation(){}

    public static void run (Team team){

        if (team == null){
            return;
        }

        int number = 1;

        System.out.println("Navn på hold: " + team.getTeamName() + "\n" + "Firma: " + team.getFirm().getFirmName());
        System.out.println("Holdkaptain: " + team.getTeamCaptain().getName());
        System.out.println("Medlemmer:");
        for (Participant participant: team.getParticipants()) {
            System.out.println(number++ + ")\t" + participant.getName());
        }
    }
}
