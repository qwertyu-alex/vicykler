//Astrid Christensen

package Actions;

import Classes.*;
import Data.Data;

import java.util.Scanner;

public class Menu {
    private Scanner input = new Scanner(System.in);

    //contructor
    public Menu(){}

    //default run

    public void run(){
        showGuestMenu();
    }

    //run med data
    public void run(Data data){
        showGuestMenu();
    }

    //overloaded run
    public void run(Person person){

        if (person instanceof Admin){
            showAdminMenu((Admin) person);
        }

        if (person instanceof TeamCaptain){
            showTeamCaptainMenu((TeamCaptain) person);
        }

        if (person instanceof Participant){
            showParticpantsMenu((Participant) person);
        }

        if (person == null){
            showGuestMenu();
        }
    }


    //Guest menu
    private void showGuestMenu(){
        System.out.println("Gæstemenu");
        System.out.println("1) Se statistikker");
        System.out.println("2) Login");
        System.out.println("3) Opret bruger");
        switch((input.next())){
            case "1":
                //indsæt metode
                break;
            case "2":
                run(new Login().run());
                break;
            case "3":
                new CreateParticipant().run();
                run();
                break;
            default:
                System.out.println("Du skal vælge en af følgende:");
                run();
                break;
        }
    }

    //Classes.Admin menu
    private void showAdminMenu(Admin admin){
        System.out.println("");
        System.out.println("Admin menu");
        System.out.println("1) Tilføj firma");
        System.out.println("2) Slet deltager");
        System.out.println("3) Opret et hold");
        System.out.println("4) Se information om en deltager");
        System.out.println("5) Overblik over et firmas hold og tilhørende holdkaptajn");
        System.out.println("6) Se information om et hold og dets deltagere");
        System.out.println("7) Oplysninger om alle tilmeldte hold og deres deltagere");
        System.out.println("8) Statistik over fordelingen af hold på firmaerne");
        System.out.println("9) Ændre i et firma og holds oplysninger");
        System.out.println("10) Fjern deltager fra hold");
        System.out.println("11) Slet hold");
        System.out.println("12) Slet firma");
        System.out.println("13) Tilføj deltager");


        switch((input.next())){
            case "1":
                admin.addFirm();
                run(admin);
                break;
            case "2":
                admin.removeParticipant();
                run(admin);

                break;
            case "3":
                new CreateTeam().run();
                run(admin);
                break;
            case "4":
                System.out.println("Se information om deltager");
                new ParticipantInformation().run(new SearchForParticipant().run(Participant.getParticipants()));
                run(admin);
                break;
            case "5":
                Firm foundFirm = new SearchForFirm().run(Firm.getFirmList());

                new ShowTeamsInFirmAndTeamCaptains().run(foundFirm);
                run(admin);
                break;
            case "6":
                Firm foundFirm1 = new SearchForFirm().run(Firm.getFirmList());
                Team foundTeam = new SearchForTeam().run(foundFirm1.getTeamList());
                new ShowTeamInformation().run(foundTeam);
                run(admin);
                break;
            case "7":
                for (Firm firm :Firm.getFirmList()) {
                    for (Team team : firm.getTeamList()) {
                        new ShowTeamInformation().run(team);
                    }
                }
                run(admin);
                break;
            case "8":
                new ShowTeamDistrubtionOfFirms().run();
                run(admin);
                break;
            case "9":
                System.out.println("Ændre i et firma og holds oplysninger");
                System.out.println( "Tast 1 for at ændre firma navn" +
                        "\nTast 2 for at ændre holds navn");
                int inputAnswer = input.nextInt();
                if (inputAnswer == 1) {
                    admin.changeFirmName();
                }else if (inputAnswer == 2){
                    admin.changeTeamName();
                }else {
                    System.out.println("Noget gik galt. Du bliver ført tilbage til admin menu");
                    run(admin);
                }
                break;
            case "10":
                //indsæt metode
                break;
            case "11":
                admin.removeTeam();
                run(admin);
                break;
            case "12":
                admin.deleteFirm();
                run(admin);
                break;
            case "13":
                new CreateParticipant().run();
            default:
                break;
        }
    }

    //Classes.Participant menu
    private void showParticpantsMenu(Participant participant){

        System.out.println("Deltager menu");
        System.out.println("1) Opret et hold");
        System.out.println("2) Se information om en deltager");
        System.out.println("3) Overblik over et firmas hold og tilhørende holdkaptajn");
        System.out.println("4) Se information om et hold og dets deltagere");
        System.out.println("5) Oplysninger om alle tilmeldte hold og deres deltagere");
        System.out.println("6) Statistik over fordelingen af hold på firmaerne");

        switch(input.nextInt()){
            case 1:
                run(new CreateTeam().run(participant));
                break;
            case 2:
                new ParticipantInformation().run(new SearchForParticipant().run(Participant.getParticipants()));
                run(participant);
                break;
            case 3:
                new ShowTeamsInFirmAndTeamCaptains().run(participant.getFirm());
                run(participant);
                break;
            case 4:

                //Ud fra en liste over alle firmaer, så vælges der et speficikt firma,
                //det firma en liste af hold, og et af holdene bliver valgt
                Firm foundFirm = new SearchForFirm().run(Firm.getFirmList());
                Team foundTeam = new SearchForTeam().run(foundFirm.getTeamList());
                new ShowTeamInformation().run(foundTeam);
                run(participant);
                break;
            case 5:
                for (Firm firm :Firm.getFirmList()) {
                    for (Team team : firm.getTeamList()) {
                        new ShowTeamInformation().run(team);
                    }
                }
                break;
            case 6:
                new ShowTeamDistrubtionOfFirms().run();
                break;
            default:
                break;
        }
    }

    //Classes.Team captain menu
    private void showTeamCaptainMenu(TeamCaptain teamCaptain){
        Participant foundParticipant;
        System.out.println("Holdkaptajn menu for " + teamCaptain.getTeam().getTeamName());
        System.out.println("1) Slet hold"); //mangler
        System.out.println("2) Tilføj deltager til hold");
        System.out.println("3) Fjern deltager fra hold");
        System.out.println("4) Ændre i et holds oplysninger"); //mangler
        System.out.println("5) Se information om en deltager");
        System.out.println("6) Overblik over et firmas hold og tilhørende holdkaptajn");
        System.out.println("7) Se information om et hold og dets deltagere");
        System.out.println("8) Oplysninger om alle tilmeldte hold og deres deltagere");
        System.out.println("9) Statistik over fordelingen af hold på firmaerne");

        switch(input.nextInt()){
            case 1:
                //indsæt metode
                break;
            case 2:
                while(true){
                    foundParticipant = new SearchForParticipant().run(Participant.getParticipants());
                    if(foundParticipant.getTeam() != null){
                        foundParticipant.setTeam(teamCaptain.getTeam());
                        break;
                    }
                }
                break;
            case 3:
                teamCaptain.removeParticipant();
                run(teamCaptain);
                break;
            case 4:
                //indsæt metode
                break;
            case 5:
                new ParticipantInformation().run(new SearchForParticipant().run(Participant.getParticipants()));
                run(teamCaptain);
                break;
            case 6:
                Firm foundFirm = new SearchForFirm().run(Firm.getFirmList());

                new ShowTeamsInFirmAndTeamCaptains().run(foundFirm);
                run(teamCaptain);
                break;
            case 7:
                //Ud fra en liste over alle firmaer, så vælges der et speficikt firma,
                //det firma en liste af hold, og et af holdene bliver valgt
                /*Firm foundFirm = new SearchForFirm().run(Firm.getFirmList());
                Team foundTeam = new SearchForTeam().run(foundFirm.getTeamList());
                new ShowTeamInformation().run(foundTeam);
                run(teamCaptain);
                break;*/
            case 8:
                for (Firm firm :Firm.getFirmList()) {
                    for (Team team : firm.getTeamList()) {
                        new ShowTeamInformation().run(team);
                    }
                }
                break;
            case 9:
                new ShowTeamDistrubtionOfFirms().run();
                break;
            default:
                break;
        }
    }

}

