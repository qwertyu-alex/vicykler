// Alexander Van Lee && Oliver Lange

package Actions;
import Classes.Team;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;


public class SearchForTeam {

    /**
     * Søger efter et bestemt team i en given liste
     * @param teams Modtager en liste over teams som den leder i
     * @return Returnerer et fundet team
     */
    public static Team run (ArrayList<Team> teams){
        int choice;
        if (teams.size() < 1){
            System.out.println("Ingen hold");
            return null;
        }


        Scanner input = new Scanner(System.in);
        int numb = 0;


        System.out.println("Hold:");
        for (Team team : teams) {
            numb++;
            System.out.println(numb + ") " + team.getTeamName());
        }

        /**
         * Kilde: Y. Daniel Liang (2015), s. 470
         */
        while (true){
            System.out.println("Indtast holdets nummer:");
            try {
                choice = input.nextInt();
                //Loop igennem alle vores teams fra arrayliste "teams"
                if (choice < teams.size()+1){
                    return teams.get(choice - 1);
                }
            } catch (InputMismatchException e){
                System.out.println("Det skal være et tal");
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
