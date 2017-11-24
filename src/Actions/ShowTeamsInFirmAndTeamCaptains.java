// Alexander Van Le

package Actions;

import Classes.Firm;
import Classes.Team;

public class ShowTeamsInFirmAndTeamCaptains {
    public static void run(Firm firm){

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
