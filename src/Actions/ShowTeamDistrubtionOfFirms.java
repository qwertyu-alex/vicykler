// Alexander Van Lee && Oliver Lange

package Actions;
import Classes.Firm;
import Classes.Team;
import Data.Data;

public class ShowTeamDistrubtionOfFirms {

    /**
     * Viser en distribution af hvor mange hold der er i de forskellige firma, og hvor mange deltagere der er i de forskellige firmaer og hold
     * @param data
     */
    public static void run(Data data){
        int numberOfTeams = 0;
        int numberOfParticipants = 0;
        int [] numberOfParticipantsInFirm = new int [data.getFirms().size()];
        int firmNumber;


        //Hvor mange hold er der?
        for (Firm firm : data.getFirms()){
            numberOfTeams += firm.getTeamList().size();
        }

        firmNumber = 0;
        for (Firm firm : data.getFirms()){
            for (Team team : firm.getTeamList()) {
                numberOfParticipantsInFirm[firmNumber] += team.getParticipants().size();
                numberOfParticipants += team.getParticipants().size();
            }
            firmNumber ++;
        }

        System.out.print("Amtal firmaer i alt: ");
        System.out.println(data.getFirms().size());

        System.out.print("Antal af hold i alt: ");
        System.out.println(numberOfTeams);

        System.out.print("Antal af deltagere i alt: ");
        System.out.println(numberOfParticipants);

        firmNumber = 0;
        for (Firm firms : data.getFirms()){
            System.out.println(firms.getFirmName());
            System.out.println(
                    String.format("%.2f",(double) firms.getTeamList().size() / (double) numberOfTeams * 100)
                    + " %" + "\t antal hold: " + firms.getTeamList().size());

            System.out.println(
                    String.format("%.2f",((double) numberOfParticipantsInFirm[firmNumber] / (double) numberOfParticipants * 100))
                    + " %" + "\t antal deltagere: " + numberOfParticipantsInFirm[firmNumber]);

            firmNumber++;
        }



    }
}
