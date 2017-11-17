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
        Person currentPerson = null;
        Data data = new Data();
        GuestController guestController = new GuestController(data);
        ParticipantController participantController = new ParticipantController(data);
        TeamCaptainController teamCaptainController = new TeamCaptainController(data);
        AdminController adminController = new AdminController(data);

        while (true){

            if (currentPerson == null){
                currentPerson = guestController.showGuestMenu();
            }
            if (currentPerson instanceof Participant){
                currentPerson = participantController.showParticipantsMenu((Participant) currentPerson);
            }

            if (currentPerson instanceof TeamCaptain){
                currentPerson = teamCaptainController.showTeamCaptainMenu((TeamCaptain) currentPerson);
            }

            if (currentPerson instanceof Admin){
                currentPerson = adminController.showAdminMenu((Admin) currentPerson);
            }

        }


    }
}

