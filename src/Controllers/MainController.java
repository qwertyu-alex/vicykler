package Controllers;

import Classes.Admin;
import Classes.Participant;
import Classes.Person;
import Classes.TeamCaptain;
import Data.Data;


public class MainController {
    public MainController(){

    }


    public void run(){
        Data data = new Data();

        AdminController adminController = new AdminController(data);
        adminController.showAdminMenu();

        /*    if (person instanceof Admin){
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
        }*/

    }
}

