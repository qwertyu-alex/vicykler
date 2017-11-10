//Alexander Le && Oliver Lange.,-æøæø
import java.util.*;

public class Login {

    public Login(){}

    public void run(Menu menu){
        Scanner input = new Scanner(System.in);
        String email;
        String password;

        System.out.println("Venligst indtast din email");
        email = input.next();
        System.out.println("Venligst indtast dit password");
        password = input.next();


        //Tjek om der er fundet en bruger
        if (findParticipant(email, password) instanceof Participant){
            menu.run(findParticipant(email, password));
        } else {
            System.out.println("Bruger ikke fundet");
            menu.run();
        }

    }

    public Participant findParticipant(String email, String password){
        for (Participant p : Participant.getParticipants()) {
            if (p.getEmail().equals(email) && p.getPassword().equals(password)){
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
