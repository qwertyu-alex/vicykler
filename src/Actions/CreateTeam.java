package Actions;

import java.util.Scanner;

import Classes.Firm;
import Classes.Participant;
import Classes.Team;


public class CreateTeam {
    Scanner input = new Scanner(System.in);
    public CreateTeam(){}

    public Team run (Participant participant){
        //getFirm
        Firm firm = validateFirm(participant);

        //getName
        String name = validateName(firm);

        return null;
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
            return Firm.getFirmList().get(chosenFirm - 1);
        }

    }

    private String validateName(Firm firm){
        boolean error = false;


        System.out.println("Hvad skal holdnavnet være? Det må ikke være følgende: ");
        //print de eksisterende holdnavne ud
        for (Team team : firm.getTeamList()) {
                System.out.print(team.getTeamName() + "\t");
        }

        //skal være her så det ikke bugger
        System.out.println();
        input.nextLine();

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
