//Alexander Van Lee && Oliver Lange

package Actions;
import Classes.Firm;
import Classes.Team;
import java.util.ArrayList;
import java.util.Scanner;


public class SearchForFirm {
    public SearchForFirm(){}

    public static Firm run (ArrayList<Firm> firms){
        if (firms.size() < 1){
            System.out.println("Ingen firmaer");
            return null;
        }

        Scanner input = new Scanner(System.in);
        int numb = 0;

        System.out.println("Firmaer:");
        for (Firm firm: firms) {
            numb++;
            System.out.println(numb + ") " + firm.getFirmName());
        }


        while (true){
            System.out.println("Indtast firmaets nummer:");
            int choice = input.nextInt();
            //Loop igennem alle vores teams fra arrayliste "teams"
            if (choice < firms.size() + 1){
                return firms.get(choice-1);
            }

            System.out.println("Intet match - Vil du prøve igen?");
            System.out.println("1) Ja \t 2) Nej");
            String answer = input.nextLine();
            if (!answer.equals("1")){
                return null;
            }
        }
    }

}
