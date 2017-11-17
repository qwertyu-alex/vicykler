package Controllers;

import Actions.CreateParticipant;
import Actions.Login;
import java.util.*;


public class GuestController {
    public GuestController(){}

    private void showGuestMenu(){
        Scanner input = new Scanner(System.in);

        System.out.println("Gæstemenu");
        System.out.println("1) Se statistikker");
        System.out.println("2) Login");
        System.out.println("3) Opret bruger");
        switch((input.next())){
            case "1":
                //indsæt metode
                break;
            case "2":
                new Login().run();
                break;
            case "3":
                new CreateParticipant().run();
                break;
            default:
                System.out.println("Du skal vælge en af følgende:");
                break;
        }
    }

}
