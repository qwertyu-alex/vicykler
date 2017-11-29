//Alexander Van Lee & Astrid Christensen

package Actions;

import java.util.Scanner;

import Classes.Firm;
import Classes.Participant;
import Classes.Team;
import Classes.TeamCaptain;
import Data.Data;

public class CreateTeam {
    static private Scanner input = new Scanner(System.in);

    static public Team run(Data data){

        //getFirm
        Firm firm = validateFirm(null, data);

        //getName
        String name = validateName(firm);

        //opret hold
        Team newTeam = data.generateTeam(name, firm);

        System.out.println("Nyt hold oprettet: " + newTeam.getTeamName());
        System.out.println("");
        return newTeam;
    }

    static public TeamCaptain run (Participant participant, Data data){
        //getFirm
        Firm firm = validateFirm(participant, data);

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

    static private Firm validateFirm(Participant participant, Data data){
        int count = 0;
        if(participant != null){
            if (participant.getFirm() != null){
                System.out.println("Firma: " + participant.getFirm().getFirmName());
                return participant.getFirm();
            }
        }

            System.out.println("Vælg et firma:");
            for (Firm firm : data.getFirms()) {
                count++;
                System.out.println(count + ") " + firm.getFirmName());
            }
            String chosenFirm = input.nextLine();

            return data.getFirms().get(Integer.parseInt(chosenFirm ) - 1);

    }

    static private String validateName(Firm firm){
        boolean error;
        String name;

        while (true){
            error = false;

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
            do {
                name = input.nextLine();
            } while (name.equals("\n") || name.length() < 1);


            //Tjekke hvis der er andre hold i virksomheden som hedder det samme
            for (Team team : firm.getTeamList()) {
                if (team.getTeamName().toLowerCase().equals(name.toLowerCase())){
                    error = true;
                }
            }

            System.out.println();

            if (!error){
                return name;
            }
        }
    }
}
