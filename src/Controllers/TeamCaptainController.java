//Oliver && Mikkel

package Controllers;

import Actions.*;
import Classes.*;
import Data.Data;

import java.util.ArrayList;
import java.util.Scanner;


public class TeamCaptainController {
    Data data;
    Scanner input = new Scanner(System.in);

    public TeamCaptainController(Data data){
        this.data = data;
    }

    public Person showTeamCaptainMenu(TeamCaptain teamCaptain){

        while(true){
            System.out.println("\nHoldkaptajn menu for " + teamCaptain.getTeam().getTeamName());
            System.out.println("1) Slet hold"); //mangler
            System.out.println("2) Tilføj deltager til hold");
            System.out.println("3) Fjern deltager fra hold");
            System.out.println("4) Ændre holdnavn oplysninger"); //man gler
            System.out.println("5) Se information om en deltager");
            System.out.println("6) Overblik over et firmas hold og tilhørende holdkaptajn");
            System.out.println("7) Se information om et hold og dets deltagere");
            System.out.println("8) Oplysninger om alle tilmeldte hold og deres deltagere");
            System.out.println("9) Statistik over fordelingen af hold på firmaerne");
            System.out.println("Andet) Log ud ");
            System.out.println("_______________________________________________________________");

            switch(input.nextLine()){
                case "1":
                    removeTeam(teamCaptain);
                    break;
                case "2":
                    addParticipantToTeam(teamCaptain);
                    break;
                case "3":
                    removeParticipantFromTeam(teamCaptain);
                    break;
                case "4":
                    changeTeamName(teamCaptain);
                    break;
                case "5":
                    showParticipantInformation();
                    break;
                case "6":
                    firmOverview();
                    break;
                case "7":
                    showTeamInformation();
                    break;
                case "8":
                    showAllTeamInformation();
                    break;
                case "9":
                    showTeamDistrubtionOfFirms();
                    break;
                default:
                    System.out.println("Logger ud");
                    return null;
            }
        }
    }

    private void removeTeam(TeamCaptain teamCaptain){
        ArrayList<Team> listTeam = new ArrayList<>();
        String confirm;

        System.out.println("Vil du slette dit hold?: " + teamCaptain.getTeam().getTeamName() +
                "\nIndtast 1 for Ja\nIndtast 2 for Nej");

        boolean keepRunning = true;

        confirm = input.nextLine();
        while(keepRunning){

            if (confirm.equals("1")){

                //Slette alle medlemmeres hold i holdet
                for (Participant participant:teamCaptain.getTeam().getParticipants()) {
                    participant.setTeam(null);
                }
                //slet holdet fra virksomheden
                teamCaptain.getTeam().getFirm().getTeamList().remove(teamCaptain.getTeam());

                //slet holdet fra holdlisten
                data.getTeams().remove(teamCaptain.getTeam());

                //Fjern holdkaptainen fra holdet
                teamCaptain.getTeam().setTeamCaptain(null);

                //set holdkaptajnens hold til null
                teamCaptain.setTeam(null);

                //set holdkaptajnen til en participant
                data.generateParticipant(teamCaptain.getName(), teamCaptain.getEmail(), teamCaptain.getPassword(), teamCaptain.getCyclistType());

                System.out.println("Dit hold er nu slettet");
            } else {
                System.out.println("Vil du prøve igen? 1) Ja 2) Nej");
                confirm = input.nextLine();
                if (!confirm.equals("1")){
                    keepRunning = false;
                }
            }
        }
    }

    private void addParticipantToTeam(TeamCaptain teamCaptain){
        Participant foundParticipant;

        while(true){
            foundParticipant = new SearchForParticipant().run(data.getParticipants());
            if(foundParticipant.getTeam() != null){
                foundParticipant.setTeam(teamCaptain.getTeam());
                break;
            }
        }
    }

    private void removeParticipantFromTeam(TeamCaptain teamCaptain){
        ArrayList<Participant> participantsInTheTeam = teamCaptain.getTeam().getParticipants();

        //tjek hvis der er deltagere i holdet
        if (participantsInTheTeam.size() > 0){
            System.out.println("Emailliste over folk på holdet:");
            for (Participant participant: participantsInTheTeam ) {
                if (participant != teamCaptain){
                    System.out.println(participant.getEmail());
                }
            }

            //Tjek om emailen er i listen participantsInTheTeam
            Participant foundParticipant = (new SearchForParticipant().run(participantsInTheTeam));

            //Fjern participant
            if (foundParticipant != null){
                System.out.println("Deltager, " + foundParticipant.getName() + ", er fjernet fra listen");
                foundParticipant.getTeam().getParticipants().remove(foundParticipant);
                foundParticipant.setTeam(null);
            } else {
                System.out.println("Ingen personer er fjernet fra holdet");
            }

        } else{
            //hvis der ikke er nogen deltagere
            System.out.println("Ingen deltagere i holdet");
        }
    }

    private void showParticipantInformation(){
        System.out.println("Se information om en deltager");
        new ParticipantInformation().run(new SearchForParticipant().run(data.getParticipants()));
    }

    private void changeTeamName(TeamCaptain teamCaptain){
        System.out.println("Ændrer holdnavn");
        System.out.println("Hvad skal det nye holdnavn være?");
        String name = input.nextLine();
        teamCaptain.getTeam().setTeamName(name);
    }


    private void firmOverview(){
        Firm foundFirm = new SearchForFirm().run(data.getFirms());
        ShowTeamsInFirmAndTeamCaptains.run(foundFirm);
    }

    private void showTeamInformation(){
        Firm foundFirm = new SearchForFirm().run(data.getFirms());
        Team foundTeam = new SearchForTeam().run(foundFirm.getTeamList());
        ShowTeamInformation.run(foundTeam);
    }

    private void showAllTeamInformation(){
        for (Firm firm :data.getFirms()) {
            for (Team team : firm.getTeamList()) {
                ShowTeamInformation.run(team);
            }
        }
    }

    private void showTeamDistrubtionOfFirms(){
        new ShowTeamDistrubtionOfFirms().run(data);
    }
}


