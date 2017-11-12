package Actions;

import java.util.Scanner;

import Classes.Firm;
import Classes.Participant;
import Classes.Team;
import Classes.TeamCaptain;


public class CreateTeam {
    private Scanner input = new Scanner(System.in);
    public CreateTeam(){}

    public TeamCaptain run (Participant participant){
        //getFirm
        Firm firm = validateFirm(participant);

        //getName
        String name = validateName(firm);

        //opret hold
        Team newTeam = new Team(name, firm);

        //tilføj holdet til participant
        participant.setTeam(newTeam);

        System.out.println("Hold: \"" + newTeam.getTeamName() + "\" er nu oprettet");

        //ny holdkaptajn
        TeamCaptain newTeamCaptain = new TeamCaptain(participant);
        newTeam.setTeamCaptain(newTeamCaptain);
        participant.getTeam().removeParticipant(participant);

        return newTeamCaptain;
    }

    private Firm validateFirm(Participant participant){
        int count = 0;

        if (participant.getFirm() != null){
            System.out.println("Firma: " + participant.getFirm().getFirmName());
            return participant.getFirm();
        } else {
            System.out.println("Vælg et firma:");
            for (Firm firm : Firm.getFirmList()) {
                count++;
                System.out.println(count + ") " + firm.getFirmName());
            }
            int chosenFirm = input.nextInt();

            //sørger for at den ikke bugger
            input.nextLine();

            return Firm.getFirmList().get(chosenFirm - 1);
        }

    }

    private String validateName(Firm firm){
        boolean error = false;


        System.out.println("Hvad skal holdnavnet være?");

        //print alle hold i firmaet
        if (firm.getTeamList().size() != 0){
            System.out.println("Det må ikke være følgende:");
            //print de eksisterende holdnavne ud
            for (Team team : firm.getTeamList()) {
                System.out.println("\"" + team.getTeamName() + "\"");
            }
        }

        //input navnet på hold
        String name = input.nextLine();

        //Tjekke hvis der er andre hold i virksomheden som hedder det samme
        for (Team team : firm.getTeamList()) {
            if (team.getTeamName().toLowerCase().equals(name.toLowerCase())){
                error = true;
            }
        }

        System.out.println();

        if (error){
            validateName(firm);
        } else {
            return name;
        }
        return null;
    }
}
