//Alexander Le && Oliver Lange.,
import java.util.*;

public class Login {

    public Login(){}


    public static void run(){
        Scanner input = new Scanner(System.in);
        String email;
        String password;
        Participant participant;

        System.out.println("Venligst indtast din email");
        email = input.next();
        System.out.println("Venligst indtast dit password");
        password = input.next();

        participant = findParticipant(email, password);

        if (participant instanceof Participant){
            Menu.run(participant);
        } else {
            System.out.println("Bruger ikke fundet");
            Menu.run();
        }

    }

    public static Participant findParticipant(String email, String password){
        for (Participant p : Participant.getParticipants()) {
            if (p.getParticipantEmail().equals(email) && p.getParticipantPassword().equals(password)){
                return p;
            }
        }
        return null;
    }

    /*



        User currentUser = findUser (username, password);


        //User: Admin, Team Captain, Participant, User
        if(currentUser != null){
            if(currentUser.getType() == 1) {
                AdminController adminController = new AdminController(data);
                adminController.showAdminMenu();
            }else if (currentUser.getType() == 2) {
                TeamCaptainController teamCaptainController = new TeamCaptainController(data);
                teamCaptainController.showTeamCaptainMenu();
            } else if (currentUser.getType() == 3) {
                ParticipantController participantController = new ParticipantController(data);
                participantController.showParticipantMenu();
            } else if (currentUser.getType() == 4){
                UserController userController = new UserController(data);
                userController.showUserMenu();
            }
        } else {
            System.out.println("Du har desværre indtastet et forkert brugernavn eller password");
        }
    }

  */
}
