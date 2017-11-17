// Oliver Lange

package Actions;

import Classes.Firm;
import Classes.Team;
import Classes.TeamCaptain;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class RemoveTeamAsTeamCaptain {

    Scanner input = new Scanner(System.in);

    public RemoveTeamAsTeamCaptain() {
    }

    public void run(TeamCaptain teamCaptain) {
        ArrayList<Team> listTeam = new ArrayList<>();
        int confirm;

        System.out.println("Vil du slette dit hold?: " + teamCaptain.getTeam().getTeamName() +
                "\nIndtast 1 for Ja\nIndtast 2 for Nej");

        boolean keepRunning = true;

        do {
            try {
                confirm = input.nextInt();
                if (confirm == 1) {
                    for (Firm firm : Firm.getFirmList()) {
                        for (Team team : firm.getTeamList()) {
                            if (team.getTeamCaptain().equals(teamCaptain))
                                listTeam.remove(team);
                            System.out.println("Du har slettet dit hold: " + teamCaptain.getTeam().getTeamName());
                        }
                    }
                } else if (confirm == 2) {
                    System.out.println("Du har valgt IKKE at slette dit hold");
                    keepRunning = false;
                } else {
                    System.out.println("Du skal vælge én enten:\n1) Ja eller 2) Nej");
                }
            } catch (InputMismatchException e) {
                System.out.println("Du skal vælge et tal\n1) Ja eller 2) Nej");
                keepRunning = true;
                input.next();
            }
        } while (keepRunning);
    }
}
