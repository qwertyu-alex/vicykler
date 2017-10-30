
/*import java.util.Scanner;

public class MainController {

    Scanner input = new Scanner(System.in);
    //private Data data;

    public MainController(){
        //this.data = new Data();
    }

    public void run(){

        System.out.println("Velkommen til ViCyklerTilArbejdes forside");
        System.out.println("Venligst indtast dit brugernavn");
        //username = input.next();
        System.out.println("Venligst indtast dit password");
        //password = input.next();


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

    public User findUser(String username, String password){
        for(user.getUsername().equals(username) && user.getPassword().equals(password)){
            return user;
        }
    }

    return null;
}
*/