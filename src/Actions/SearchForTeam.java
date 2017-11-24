// Alexander Van Lee && Oliver Lange

package Actions;
import Classes.Team;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;


public class SearchForTeam {

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
            System.out.println("1) Ja \t 2) Nej");
            String answer = input.nextLine();
            if (!answer.equals("1")){
                return null;
            }
        }
    }
}
