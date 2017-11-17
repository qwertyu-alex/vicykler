// Alexander Van Lee

package Actions;

import Classes.Firm;
import Classes.Team;
import Classes.TeamCaptain;


public class ShowTeamsInFirmAndTeamCaptains {
    public ShowTeamsInFirmAndTeamCaptains(){}

    public void run(Firm firm){

        if (firm != null){
            System.out.println(firm.getFirmName());
            if (firm.getTeamList().size() != 0){
                for (Team team:firm.getTeamList()) {
                    System.out.println("\nHoldnavn: " + team.getTeamName()+ "\n" + "Holdkaptajn: " + team.getTeamCaptain().getName());
                    System.out.println("");
                }
            }
        } else {
            System.out.println("Intet firma forbundet med dig");
        }


    }
}
