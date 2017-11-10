//Astrid Christensen

import java.util.Scanner;

public class Menu {
    static Scanner input = new Scanner(System.in);

    public Menu(){}

    //default run
    public void run(){
        showGuestMenu();
    }

    //overloaded run
    public void run(Person person){
        showAdminMenu();
        showParticpantsMenu();
        showTeamCaptainMenu();
    }

    //for at teste
    public void run(Data data){
        showTeamCaptainMenu();
    }

    //Guest menu
    private void showGuestMenu(){
        do {
            System.out.println("Gæste menu");
            System.out.println("1) Se statistikker");
            System.out.println("2) Login");
            System.out.println("3) Opret bruger");
            switch(input.nextInt()){
                case 1:
                    //indsæt metode
                    break;
                case 2:
                    new Login().run(this);
                    break;
                case 3:
                    new CreateParticipant().run();
                    break;
                default:
                    break;
            }
        } while (true);
    }

    //Admin menu
    private void showAdminMenu(){
        System.out.println("Admin menu");
        System.out.println("1) Tilføj firma"); //tjek
        System.out.println("2) Slet deltager"); //tjek
        System.out.println("3) Tilføj et hold"); //tjek Opret hold
        System.out.println("4) Se information om en deltager"); //tjek Oplysninger om deltager
        System.out.println("5) Overblik over et firmas hold og tilhørende holdkaptajn"); //Oversigt over en virk hold og holdkaptajn
        System.out.println("6) Se information om et hold og dets deltagere"); //tjek
        System.out.println("7) Oplysninger om alle tilmeldte hold og deres deltagere"); //tjek
        System.out.println("8) Statistik over fordelingen af hold på firmaerne"); //tjek
        System.out.println("9) Ændre i et holds oplysninger");  //tjek
        System.out.println("10) Fjern deltager fra hold"); //tjek
        System.out.println("11) Slet hold");//tjek


        switch(input.nextInt()){
            case 1:
                //indsæt metode
                break;
            case 2:
                //indsæt metode
                break;
            case 3:
                //indsæt metode
                break;
            case 4:
                //indsæt metode
                break;
            case 5:
                //indsæt metode
                break;
            case 6:
                //indsæt metode
                break;
            case 7:
                //indsæt metode
                break;
            case 8:
                //indsæt metode
                break;
            case 9:
                //indsæt metode
                break;
            case 10:
                //indsæt metode
                break;
            case 11:
                //indsæt metode
                break;
            default:
                break;
        }
    }

    //Participant menu
    private void showParticpantsMenu(){

        System.out.println("Deltager menu");
        System.out.println("1) Tilføj et hold"); //opret hold tjek
        System.out.println("2) Se information om en deltager"); //tjek
        System.out.println("3) Overblik over et firmas hold og tilhørende holdkaptajn"); //tjek
        System.out.println("4) Se information om et hold og dets deltagere"); //tjek
        System.out.println("5) Oplysninger om alle tilmeldte hold og deres deltagere"); //tjek
        System.out.println("6) Statestik over fordelingen af hold på firmaerne"); //tjek

        switch(input.nextInt()){
            case 1:
                //indsæt metode
                break;
            case 2:
                //indsæt metode
                break;
            case 3:
                //indsæt metode
                break;
            case 4:
                //indsæt metode
                break;
            case 5:
                //indsæt metode
                break;
            case 6:
                //indsæt metode
                break;
            default:
                break;
        }
    }

    //Team captain menu
    private void showTeamCaptainMenu(){
        System.out.println("Holdkaptajn menu");
        System.out.println("1) Slet hold"); //tjek
        System.out.println("2) Tilføj deltager til hold"); //tjek
        System.out.println("3) Fjern deltager fra hold"); //tjek
        System.out.println("4) Ændre i et holds oplysninger"); //tjek
        System.out.println("5) Se information om en deltager"); //tjek
        System.out.println("6) Overblik over et firmas hold og tilhørende holdkaptajn"); //tjek
        System.out.println("7) Se information om et hold og dets deltagere"); //tjek
        System.out.println("8) Oplysninger om alle tilmeldte hold og deres deltagere"); //tjek
        System.out.println("9) Statistik over fordelingen af hold på firmaerne"); //tjek

        switch(input.nextInt()){
            case 1:
                //indsæt metode
                break;
            case 2:
                //indsæt metode
                break;
            case 3:
                //indsæt metode
                new TeamCaptain(new Participant("john", ".@.@@","Meme1", "Master")).removeParticipant("jesus@gmail.com");
                break;
            case 4:
                //indsæt metode
                break;
            case 5:
                //indsæt metode
                break;
            case 6:
                //indsæt metode
                break;
            case 7:
                //indsæt metode
                break;
            case 8:
                //indsæt metode
                break;
            case 9:
                //indsæt metode
                break;
            default:
                break;
        }
    }

}
