//Astrid

package Controllers;

import Actions.CreateParticipant;
import java.util.*;

import Actions.ShowTeamDistrubtionOfFirms;
import Data.Data;
import Classes.Person;


class GuestController {
    private Scanner input = new Scanner(System.in);
    private Data data;

    GuestController(Data data){
        this.data = data;
    }

    Person showGuestMenu(){
        while (true){
            System.out.println("\nGæstemenu");
            System.out.println("1) Statistik over fordelingen af hold på firmaerne");
            System.out.println("2) Login");
            System.out.println("3) Opret bruger");
            System.out.println("4) Luk programmet");
            System.out.println("_______________________________________________________________");

            switch((input.nextLine())){
                case "1":
                    showTeamDistrubtionOfFirms();
                    break;
                case "2":
                    return login();
                case "3":
                    createParticipant();
                    break;
                case "4":
                    return null;
                default:
                    System.out.println("Du skal vælge en af følgende:");
                    break;
            }
        }

    }

    private void showTeamDistrubtionOfFirms(){
        ShowTeamDistrubtionOfFirms.run(data);
    }

    private Person login(){
        String email;
        String password;

        System.out.println("Venligst indtast din email");
        email = input.nextLine().toLowerCase();
        System.out.println("Venligst indtast dit password");
        password = input.nextLine();

        //Tjek om der er fundet en bruger
        for (Person person: data.getPersons()) {
            if (person.getEmail().toLowerCase().equals(email) && person.getPassword().equals(password)){
                return person;
            }

        }

        System.out.println("Bruger ikke fundet");
        return null;
    }

    private void createParticipant(){
        CreateParticipant.run(data);
    }

}
