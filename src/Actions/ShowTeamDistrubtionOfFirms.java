// Alexander Van Lee && Oliver Lange

package Actions;
import Classes.Firm;
import Data.Data;

public class ShowTeamDistrubtionOfFirms {

    public static void run(Data data){
        int numberOfTeams = 0;

        for (Firm firms : data.getFirms()){
            numberOfTeams += firms.getTeamList().size();
        }

        System.out.println("Antal af hold i alt: ");
        System.out.println(numberOfTeams);

        for (Firm firms : data.getFirms()){
            System.out.println(firms.getFirmName());
            System.out.println( (double) firms.getTeamList().size()/ (double) numberOfTeams * 100 + " %" +
            "\t antal hold: " + firms.getTeamList().size());
        }



    }
}
