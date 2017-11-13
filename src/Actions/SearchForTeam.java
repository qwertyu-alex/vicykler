// Alexander Van Lee && Oliver Lange (fiks nummer)

package Actions;
import Classes.Team;
import java.util.ArrayList;
import java.util.Scanner;


public class SearchForTeam {
    public SearchForTeam(){}

    public Team run (ArrayList<Team> teams){
        Scanner input = new Scanner(System.in);

        System.out.println("Hold:");
        for (Team team : teams) {
            System.out.println(team.getTeamName());
        }

        while (true){
            System.out.println("Indtast holdnavn:");
            String teamName = input.nextLine().toLowerCase();
            //Loop igennem alle vores teams fra arrayliste "teams"
            for (Team foundTeam: teams) {
                //se om der er en matchende email og retuner hvis der er
                if (foundTeam.getTeamName().toLowerCase().equals(teamName)){
                    return foundTeam;
                }
            }

            System.out.println("Intet match - Vil du prøve igen?");
            System.out.println("1) Ja \t 2) Nej");
            String answer = input.next();
            if (!answer.equals("1")){
                return null;
            }
        }
    }
}
