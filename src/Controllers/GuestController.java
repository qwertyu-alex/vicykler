package Controllers;

import Actions.CreateParticipant;
import Actions.Login;
import java.util.*;

import Actions.ShowTeamDistrubtionOfFirms;
import Data.Data;
import Classes.Person;


public class GuestController {
    private Scanner input = new Scanner(System.in);
    private Data data;

    public GuestController(Data data){
        this.data = data;
    }

    public Person showGuestMenu(){
        while (true){
            System.out.println();
            System.out.println("Gæstemenu");
            System.out.println("1) Se statistikker");
            System.out.println("2) Login");
            System.out.println("3) Opret bruger");
            switch((input.next())){
                case "1":
                    showTeamDistrubtionOfFirms();
                    break;
                case "2":
                    return login();
                case "3":
                    createParticipant();
                    break;
                default:
                    System.out.println("Du skal vælge en af følgende:");
                    break;
            }
        }

    }

    private void showTeamDistrubtionOfFirms(){
        new ShowTeamDistrubtionOfFirms().run();
    }

    private Person login(){
        return new Login().run();
    }

    private void createParticipant(){
        new CreateParticipant().run();
    }

}
