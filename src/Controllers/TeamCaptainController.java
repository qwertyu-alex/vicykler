//Mikkel Storm && Oliver Lange

package Controllers;

import Actions.*;
import Classes.*;
import Data.Data;

import java.util.ArrayList;
import java.util.Scanner;


class TeamCaptainController {
    private Data data;
    private Scanner input = new Scanner(System.in);

    TeamCaptainController(Data data){
        this.data = data;
    }

    /**
     * Menu for teamcaptain
     * @param teamCaptain tager imod den teamcaptain som har kaldt på metoden
     * @return returnerer "null" når man logger ud
     */
    Person showTeamCaptainMenu(TeamCaptain teamCaptain){
        while(true){
            System.out.println("\nHoldkaptajn menu for " + teamCaptain.getTeam().getTeamName());
            System.out.println("1) Slet hold");
            System.out.println("2) Tilføj deltager til hold");
            System.out.println("3) Fjern deltager fra hold");
            System.out.println("4) Ændre et holds oplysninger");
            System.out.println("5) Se information om en deltager");
            System.out.println("6) Overblik over et firmas hold og tilhørende holdkaptajn");
            System.out.println("7) Se information om et hold og dets deltagere");
            System.out.println("8) Oplysninger om alle tilmeldte hold og deres deltagere");
            System.out.println("9) Statistik over fordelingen af hold på firmaerne");
            System.out.println("Andet) Log ud ");
            System.out.println("_______________________________________________________________");

            switch(input.nextLine()){
                case "1":
                    Person person = removeTeam(teamCaptain);
                    if (!(person instanceof TeamCaptain)){
                        return person;
                    }
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

    /**
     * sletter en hold
     * @param teamCaptain tager imod den nuværende teamcaptain
     * @return @if hvis det er et succesfuldt forsøg, så returner en participant, som er baseret ud fra den nuværende teamcaptain
     * hvis det er et usuccesfuldt forsøg, så returner den nuværende teamcaptain
     */
    private Participant removeTeam(TeamCaptain teamCaptain){
        String confirm;
        Team team = teamCaptain.getTeam();
        Firm firm = teamCaptain.getTeam().getFirm();


        while(true){
            System.out.println("Vil du slette dit hold?: " + teamCaptain.getTeam().getTeamName() +
                    "\nIndtast 1 for Ja\nIndtast 2 for Nej");
            confirm = input.nextLine();
            if (confirm.equals("1")){
                System.out.println("Er du sikker? 1) Ja 2) Nej");
                confirm = input.nextLine();
                if (confirm.equals("1")){
                    //Slette alle medlemmeres hold i holdet
                    for (Participant participant:team.getParticipants()) {
                        participant.setTeam(null);
                    }
                    //slet holdet fra virksomheden
                    firm.getTeamList().remove(team);

                    //slet holdet fra holdlisten
                    data.getTeams().remove(team);

                    //Fjern holdkaptainen fra holdet
                    team.setTeamCaptain(null);

                    //set holdkaptajnens hold til null
                    teamCaptain.setTeam(null);

                    //Fjern holdkaptajnen over listen over personer
                    data.getPersons().remove(teamCaptain);

                    //gør holdkaptajnen til en participant
                    Participant newParticipant = data.generateParticipant(teamCaptain.getName(), teamCaptain.getEmail(),
                            teamCaptain.getPassword(), teamCaptain.getCyclistType());

                    System.out.println("Dit hold er nu slettet");
                    return newParticipant;
                }
            } else {
                return teamCaptain;
            }
        }
    }

    /**
     * Tilføj en participant til holdet som teamcaptain er på
     * @param teamCaptain tager imod den nuværende teamcaptain
     */
    private void addParticipantToTeam(TeamCaptain teamCaptain){
        Participant foundParticipant;
        if (teamCaptain.getTeam().getParticipants().size() < 16){
            foundParticipant = SearchForParticipant.run(data.getParticipants());
            if(foundParticipant != null){
                if (foundParticipant.getTeam() == null){
                    foundParticipant.setTeam(teamCaptain.getTeam());
                } else {
                    System.out.println("Personen er allerede i et hold");
                }
            }
        } else {
            System.out.println("Der er for mange deltagere på dig hold. Slet en for at tilføje en ny");
        }

    }

    /**
     * Fjerner en participant fra holdet
     * @param teamCaptain tager imod den nuværende teamcaptain
     */
    private void removeParticipantFromTeam(TeamCaptain teamCaptain){
        ArrayList<Participant> participantsInTheTeam = teamCaptain.getTeam().getParticipants();

        System.out.println("Fjern deltager fra hold");
        //tjek hvis der er deltagere i holdet
        if (participantsInTheTeam.size() > 0){
            System.out.println("Liste over folk på holdet:");
            for (Participant participant: participantsInTheTeam ) {
                if (participant != teamCaptain){
                    System.out.println("Navn: " + participant.getName() + ", email: " + participant.getEmail());
                }
            }

            //Tjek om emailen er i listen participantsInTheTeam
            Participant foundParticipant = (SearchForParticipant.run(participantsInTheTeam));

            //Fjern participant
            if (foundParticipant != null){
                System.out.println("Deltager, " + foundParticipant.getName() + ", er fjernet fra listen");
                //Fjern personen fra holdet
                foundParticipant.getTeam().getParticipants().remove(foundParticipant);
                //Fjern holdet fra personen
                foundParticipant.setTeam(null);
            } else {
                System.out.println("Ingen personer er fjernet fra holdet");
            }

        } else{
            //hvis der ikke er nogen deltagere
            System.out.println("Ingen deltagere i holdet");
        }
    }

    /**
     * Viser information om en bestemt deltager
     */
    private void showParticipantInformation(){
        System.out.println("Se information om en deltager");
        ParticipantInformation.run(SearchForParticipant.run(data.getParticipants()));
    }

    /**
     * Ændrer i et holds oplysninger (navn)
     * @param teamCaptain tager imod den nuværende teamcaptain
     */
    private void changeTeamName(TeamCaptain teamCaptain){
        System.out.println("Ændr holdnavn");
        System.out.println("Hvad skal det nye holdnavn være?");
        String name = input.nextLine();
        teamCaptain.getTeam().setTeamName(name);
    }

    /**
     * Viser alle hold og dens teamcaptain i et bestemt firma
     */
    private void firmOverview(){
        Firm foundFirm = SearchForFirm.run(data.getFirms());
        ShowTeamsInFirmAndTeamCaptains.run(foundFirm);
    }

    /**
     * Viser information om et hold og hvilke deltagere der er på holdet
     */
    private void showTeamInformation(){
        Firm foundFirm = SearchForFirm.run(data.getFirms());
        if (foundFirm != null){
            Team foundTeam = SearchForTeam.run(foundFirm.getTeamList());
            if (foundTeam != null){
                ShowTeamInformation.run(foundTeam);
            }
        }
    }

    /**
     * Viser alle hold og deltagere i et bestemt firma
     */
    private void showAllTeamInformation(){
        for (Firm firm :data.getFirms()) {
            for (Team team : firm.getTeamList()) {
                ShowTeamInformation.run(team);
            }
        }
    }

    /**
     * Viser nogle statistikker over fordeling af deltagere på hold
     */
    private void showTeamDistrubtionOfFirms(){
        ShowTeamDistrubtionOfFirms.run(data);
    }
}


