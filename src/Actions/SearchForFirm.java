//Alexander Van Lee && Oliver Lange

package Actions;
import Classes.Firm;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;


public class SearchForFirm {

    /**
     * Søger efter et bestemt firma
     * @param firms Modtager en ArrayListe af firms hvori der skal søges
     * @return Returnerer det søgte firma
     */
    public static Firm run (ArrayList<Firm> firms){
        int choice;
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
            try{
                choice = input.nextInt();
                input.nextLine();
                //Loop igennem alle vores teams fra arrayliste "teams"
                if (choice < firms.size() + 1){
                    return firms.get(choice-1);
                }

                System.out.println("Intet match - Vil du prøve igen?");
                System.out.println("1) Ja \t Andet) Nej");
                String answer = input.nextLine();
                if (!answer.equals("1")){
                    return null;
                }

            } catch (InputMismatchException e){
                System.out.println("Ikke tilladt. Vælg et af tallene");
                input.nextLine();
            }
        }
    }

}
