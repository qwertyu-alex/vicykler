//Astrid Christensen

package Controllers;
import Actions.*;
import Classes.*;
import Data.Data;

import java.util.Scanner;


class ParticipantController {
    private Data data;
    private Scanner input = new Scanner(System.in);

    ParticipantController(Data data){
        this.data = data;
    }

    Person showParticipantsMenu(Participant currentParticipant){
        while (true){
            System.out.println("\nDeltager menu");
            System.out.println("1) Opret et hold");
            System.out.println("2) Se information om en deltager");
            System.out.println("3) Oversigt over et firmas hold og tilhørende holdkaptajn");
            System.out.println("4) Se information om et hold og dets deltagere");
            System.out.println("5) Oplysninger om alle tilmeldte hold og deres deltagere");
            System.out.println("6) Statistik over fordelingen af hold på firmaerne");
            System.out.println("Andet) Log ud ");
            System.out.println("_______________________________________________________________");

            switch(input.nextLine()){
                case "1":
                    return createTeam(currentParticipant);
                case "2":
                    showParticipantInformation();
                    break;
                case "3":
                    firmOverview(currentParticipant);
                    break;
                case "4":
                    showTeamInformation();
                    break;
                case "5":
                    showAllTeamInformation();
                    break;
                case "6":
                    showTeamDistrubtionOfFirms();
                    break;
                default:
                    System.out.println("Logger ud");
                    return null;


            }
        }
    }

    private TeamCaptain createTeam(Participant currentParticipant){
         return CreateTeam.run(currentParticipant, data);
    }

    private void showParticipantInformation(){
        ParticipantInformation.run(SearchForParticipant.run(data.getParticipants()));
    }

    private void firmOverview(Participant currentParticipant){
        ShowTeamsInFirmAndTeamCaptains.run(currentParticipant.getFirm());
    }

    private void showTeamInformation(){
        Firm foundFirm = SearchForFirm.run(data.getFirms());
        if (foundFirm != null){
            Team foundTeam = SearchForTeam.run(foundFirm.getTeamList());
            ShowTeamInformation.run(foundTeam);
        }
    }

    private void showAllTeamInformation(){
        Firm foundFirm = SearchForFirm.run(data.getFirms());
        if  (foundFirm != null){
            Team foundTeam = SearchForTeam.run(foundFirm.getTeamList());
            ShowTeamInformation.run(foundTeam);
        }
    }

    private void showTeamDistrubtionOfFirms(){
        ShowTeamDistrubtionOfFirms.run(data);
    }





}
