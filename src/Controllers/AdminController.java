//Mikkel Storm && Astrid Christensen

package Controllers;

import Actions.*;
import Classes.*;

import java.util.*;
import Data.Data;

class AdminController {
    private Scanner input = new Scanner(System.in);
    private Data data;

    AdminController(Data data){
        this.data = data;
    }

    Person showAdminMenu(Admin admin){
        while(true){
            System.out.println("\nAdmin menu");
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
            System.out.println("\nAndet) Log ud ");
            System.out.println("_______________________________________________________________");


            switch((input.nextLine())){
                case "1":
                    addFirm();
                    break;
                case "2":
                    removeParticipant();
                    break;
                case "3":
                    createTeam();
                    break;
                case "4":
                    showParticipantInformation();
                    break;
                case "5":
                    firmOverview();
                    break;
                case "6":
                    showTeamInformation();
                    break;
                case "7":
                    showAllTeamInformation();
                    break;
                case "8":
                    showTeamDistrubtionOfFirms();
                    break;
                case "9":
                    changeFirmAndTeamInformation();
                    break;
                case "10":
                    removeParticipantFromTeam();
                    break;
                case "11":
                    removeTeam();
                    break;
                case "12":
                    removeFirm();
                    break;
                case "13":
                    addParticipant();
                    break;
                default:
                    System.out.println("Logger ud");
                    return null;
            }
        }


    }

    private void addFirm(){
        //henter Arraylisten over firmaer
        ArrayList<Firm> firms = data.getFirms();
        String firmName;
        boolean skip;

        System.out.println("Tilføj firma menu");
        System.out.println("Indtast navn på det nye firma");

        while (true){
            skip = false;
            firmName = input.nextLine();

            for (Firm firm:firms) {
                if (firm.getFirmName().equals(firmName)){
                    skip = true;
                    System.out.println("Dette navn er allerede i brug. Indtast andet navn:");
                }
            }

            if (skip){
                continue;
            }

            //Tilføjer det indtastede navn på firmaet til Arraylisten over firmaer.
            firms.add(new Firm(firmName));
            System.out.printf("Du har nu tilføjet firmaet %s til listen over firmaer",firmName);
            break;
        }
    }

    private void removeParticipant(){
        System.out.println("Sletter deltager");

        //Denne metode finder en participant ud fra en mail
        Participant foundParticipant = SearchForParticipant.run(data.getParticipants());

        //Denne metode sletter deltageren
        System.out.println((foundParticipant!=null?"Sletter " + foundParticipant.getName():"Kan ikke finde den søgte person"));

        if (foundParticipant != null){
            //Slet personen i firmaet
            if (foundParticipant.getFirm() != null){
                foundParticipant.getFirm().getParticipants().remove(foundParticipant);
            }

            //Slet personen i holdet
            if(foundParticipant.getTeam() != null){
                foundParticipant.getTeam().getParticipants().remove(foundParticipant);
            }

            //Slet personen over listen af deltagere
            data.getParticipants().remove(foundParticipant);
        }
    }

    private void createTeam(){
        CreateTeam.run(data);
    }

    private void showParticipantInformation(){
        System.out.println("Se information om en deltager");
        ParticipantInformation.run(SearchForParticipant.run(data.getParticipants()));
    }

    private void firmOverview(){
        Firm foundFirm = SearchForFirm.run(data.getFirms());
        ShowTeamsInFirmAndTeamCaptains.run(foundFirm);
    }

    private void showTeamInformation(){
        Firm foundFirm = SearchForFirm.run(data.getFirms());
        if (foundFirm != null){
            Team foundTeam = SearchForTeam.run(foundFirm.getTeamList());
            if (foundTeam != null){
                ShowTeamInformation.run(foundTeam);
            }
        }
    }

    private void showAllTeamInformation(){
        for (Firm firm :data.getFirms()) {
            for (Team team : firm.getTeamList()) {
                ShowTeamInformation.run(team);
            }
        }
    }

    private void showTeamDistrubtionOfFirms(){
        ShowTeamDistrubtionOfFirms.run(data);
    }

    private void changeFirmAndTeamInformation(){
        int i;
        int inputAnswer;
        ArrayList<Firm> firms =  data.getFirms();

        System.out.println("Ændre i et firma og holds oplysninger");
        System.out.println( "Tast 1 for at ændre firma navn" +
                "\nTast 2 for at ændre holds navn");

        /**
         * Kilde: Y. Daniel Liang (2015), s. 470
         */
        while (true){
            try {
                inputAnswer = input.nextInt();
                break;
            } catch (InputMismatchException e){
                System.out.println("Du skal taste 1 eller 2");
                input.nextLine();
            }
        }

        if (inputAnswer == 1) {
            i = 1;
            boolean safetyCheck = false;
            int numOfFirm;
            String answer;

            //Printer listen over firmaer
            System.out.println("Ændre firma navn menu");
            System.out.printf("%-5s %s","Nr:","Firma navn");
            for(Firm firm : firms){
                System.out.printf("\n%-5d %s",i++,firm.getFirmName());
            }
            //Giver mulighed for at vælge et firma man vil ændre navnet på
            //Sikkerhedsforanstalting sikre man ikke ændre navnet på det forkerte firma.
            do {
                System.out.println("\nIndtast nummmer på firma du vil ændre navn på");
                while (true){
                    /**
                     * Kilde: Y. Daniel Liang (2015), s. 470
                     */
                    try{
                        numOfFirm = input.nextInt();
                        break;
                    } catch (InputMismatchException e){
                        System.out.println("Indtast venligst et tal");
                        input.nextLine();
                    }
                }
                System.out.printf("Vil du ændre navnet på firmaet %s (j/n)", firms.get(numOfFirm - 1).getFirmName());
                answer = input.nextLine();

                if (answer.equalsIgnoreCase("j"))
                    safetyCheck = true;

            }while(!safetyCheck);

            System.out.printf("Hvad vil du ændre firmaet %s's navn til?",firms.get(numOfFirm - 1).getFirmName());
            //ændre navnet fra det gamle til det man indtaster nedenfor
            String newFirmName = input.nextLine();
            firms.get(numOfFirm-1).setFirmName(newFirmName);

        }else if (inputAnswer == 2){
            i = 1;
            int numOfTeam;
            int numOfFirm;
            System.out.println("Ændre hold navn menu");
            System.out.printf("%-5s %s","Nr:","Firma navn");
            for(Firm firm : firms){
                System.out.printf("\n%-5d %s",i++,firm.getFirmName());
            }
            System.out.println("\nVælg firma du vil ændre et hold navn i");
            while (true){
                /**
                 * Kilde: Y. Daniel Liang (2015), s. 470
                 */
                try{
                    numOfFirm = input.nextInt()-1;
                    break;
                } catch (InputMismatchException e){
                    System.out.println("Indtast venligst et tal");
                }
            }
            System.out.printf("%-5s %s","Nr:","hold navn");

            i = 1;
            for (Team team:firms.get(numOfFirm).getTeamList()) {
                System.out.printf("\n%-5d %s",i++,team.getTeamName());
            }

            System.out.println("\nVælg hold du vil ændre navn på");
            while (true){
                /**
                 * Kilde: Y. Daniel Liang (2015), s. 470
                 */
                try{
                    numOfTeam = input.nextInt()-1;
                    break;
                } catch (InputMismatchException e){
                    System.out.println("Indtast venligst et tal");
                }
            }


            System.out.println("Du har valgt at ændre navnet på holdet: " + firms.get(numOfFirm).getTeamList().get(numOfTeam).getTeamName());
            System.out.println("Hvad vil du ændre navnet til?");
            String newTeamName = input.nextLine();

            //Ændrer navnet på holdet
            firms.get(numOfFirm).getTeamList().get(numOfTeam).setTeamName(newTeamName);
            System.out.println("Du har ændret navnet på holdet til: " + newTeamName);
        }else{
            System.out.println("Noget gik galt. Du bliver ført tilbage til admin menu");
        }
    }

    private void removeParticipantFromTeam(){
        Participant foundParticipant;

        foundParticipant = SearchForParticipant.run(data.getParticipants());
        if (foundParticipant != null){
            if (foundParticipant.getTeam() != null){
                foundParticipant.getTeam().getParticipants().remove(foundParticipant);
                foundParticipant.setTeam(null);
            } else {
                System.out.println("Deltageren er ikke forbundet til noget hold");
            }
        } else {
            System.out.println("Kunne ikke finde deltageren");
        }
    }

    private void removeTeam(){
        ArrayList<Team> listTeam = new ArrayList<>();

        //Oprettet en liste over alle hold der findes


        for (Firm firm:data.getFirms()) {
            listTeam.addAll(firm.getTeamList());
        }

        //Her finder det hold i listen vi vil slette
        Team foundTeam = SearchForTeam.run(listTeam);

        if (foundTeam != null){
            //Fjern holdet fra hver enkelte holdmedlem
            System.out.println("Sletter: " + foundTeam.getTeamName());
            for (Participant participant:foundTeam.getParticipants()) {
                participant.setTeam(null);
            }

            //Fjern holdet fra firmaet
            foundTeam.getFirm().getTeamList().remove(foundTeam);
        }
    }

    private void removeFirm(){
        int i = 1;
        int removeFirm;
        //Henter Arraylisten over firmaer
        ArrayList<Firm> firms = data.getFirms();

        //Printer listen over firmaer
        System.out.println("Slet firma menu");
        System.out.println("Liste over firmaer");
        System.out.printf("%-5s %s","Nr:","Firmanavn");
        for(Firm firm : firms){
            System.out.printf("\n%-5d %s",i++,firm.getFirmName());
        }

        //sletter indtastede firma fra listen over firmaer
        System.out.println("\nIndtast nummmer på firma du vil slette");

        while (true){
            /**
             * Kilde: Y. Daniel Liang (2015), s. 470
             */
            try{
                removeFirm = input.nextInt();
                input.nextLine();
                if (removeFirm-1 < firms.size()){
                    break;
                } else {
                    System.out.println("Vælg venligst et af tallene.");
                }
            } catch (InputMismatchException e){
                System.out.println("Vælg venligst et af tallene.");
                input.nextLine();
            }
        }
        System.out.printf("Du har nu slette firmaet %s fra listen over firmaer. \n",firms.get(removeFirm-1).getFirmName());

        for (Team team:firms.get(removeFirm-1).getTeamList()) {

            //Fjern alle referencer af holdene der er indgået i firmaet og fjern referencen af firmaet i hvert deltager
            for (Participant participant: team.getParticipants()) {
                participant.setTeam(null);
                participant.setFirm(null);
            }
            //Fjern alle holdene fra databasen
            data.getTeams().remove(team);
        }

        //Fjern firmaet fra databsen
        firms.remove(removeFirm-1);
    }

    private void addParticipant(){
        CreateParticipant.run(data);
    }


}
