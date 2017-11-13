// Alexander Van Lee && Oliver Lange

package Actions;
import Classes.Firm;

public class ShowTeamDistrubtionOfFirms {

    public ShowTeamDistrubtionOfFirms(){}

    public void run(){
        int numberOfTeams = 0;

        for (Firm firms : Firm.getFirmList()){
            numberOfTeams += firms.getTeamList().size();
        }

        System.out.println("Antal af hold i alt: ");
        System.out.println(numberOfTeams);

        for (Firm firms : Firm.getFirmList()){
            System.out.println(firms.getFirmName());
            System.out.println( (double) firms.getTeamList().size()/ (double) numberOfTeams * 100 + " %" +
            "\t antal hold: " + firms.getTeamList().size());
        }



    }
}
