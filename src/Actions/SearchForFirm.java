//Alexander Van Lee && Oliver Lange (fiks lige så man kan klikke på nummer uden for)

package Actions;
import Classes.Firm;
import Classes.Team;
import java.util.ArrayList;
import java.util.Scanner;


public class SearchForFirm {
    public SearchForFirm(){}

    public Firm run (ArrayList<Firm> firms){
        Scanner input = new Scanner(System.in);

        System.out.println("Firmaer:");
        for (Firm firm: firms) {
            System.out.println(firm.getFirmName());
        }


        while (true){
            System.out.println("Indtast firmanavn:");
            String firmName = input.nextLine().toLowerCase();
            //Loop igennem alle vores teams fra arrayliste "teams"
            for (Firm foundFirm: firms) {
                //se om der er en matchende email og retuner hvis der er
                if (foundFirm.getFirmName().toLowerCase().equals(firmName)){
                    return foundFirm;
                }
            }

            System.out.println("Intet match - Vil du prøve igen?");
            System.out.println("1) Ja \t 2) Nej");
            String answer = input.next();
            if (!answer.equals("1")){
                return null;
            }
        }
    }

}
