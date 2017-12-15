// Alexander Van Lee

package Actions;

import Classes.Participant;
import Classes.TeamCaptain;

public class ParticipantInformation {

    /**
     * Printer informationerne om en bestemt participant
     * @param participant Tager imod en participant objekt hvis informationer skal vises
     */
    public static void run(Participant participant){
        if (participant == null){
            return;
        }

        String name = participant.getName();
        String type = participant.getCyclistType();
        String team = participant.getTeam() != null ? participant.getTeam().getTeamName(): "Intet hold";
        String firm = participant.getFirm() != null ? participant.getFirm().getFirmName(): "Intet firma";
        String title;

        if (participant instanceof TeamCaptain){
            title = "Holdkaptajn";
        } else {
            title = "Deltager";
        }

        System.out.printf("Navn: %s\nType: %s\nHold: %s\nFirma: %s\nRolle: %s\n\n",name, type, team, firm, title);
    }
}
