//Oliver Lange && Alexander Van Le

import java.util.Scanner;
import java.util.regex.Pattern;

public class CreateParticipant {
    static Scanner input = new Scanner(System.in);

    public static Participant run() {
        String[] participantTypes = {"Master", "Enthusiast", "Cruiser", "Debutant"};

        //GetName
        String participantName = validateName();

        //GetAge
        int age = validateAge();

        //GetType
        String cyclistType = validateType(participantTypes);

        //GetEmail
        String participantEmail = validateEmail();

        //GetPassword
        String participantPassword = validatePassword();

        //CheckPassword
        boolean passCheck = matchPassword(participantPassword);

        return new Participant(participantName, cyclistType, participantEmail, participantPassword);
    }

    public static String validateName() {
        System.out.println("Indtast dit fulde navn: ");

        String name = input.nextLine();

        do {
            if (Pattern.matches("[a-zA-Z ]+", name)){
                return name;
            } else {
                System.out.println("Et navn kan kun indeholde bogstaver, prøv igen: ");
                name = input.next();
            }
        } while (true);
    }

    public static int validateAge(){
        System.out.println("Indtast din alder: ");
        int age;

        age = input.nextInt();
        do {
            if (age > 14 && age < 99) {
                return age;
            } else {
                System.out.println("Du skal vælge en alder mellem 15-99");
                age = input.nextInt();
            }
        }while(true);

}

    public static String validateType(String[] participantTypes){
        int choice;
        String type = "";
        boolean check = true;

        System.out.println("Indtast nummeret på den type af cyklist, som du er: " + "\n1) " + participantTypes[0] +
                "\n2) " + participantTypes[1] + "\n3) " + participantTypes[2] + "\n4) " + participantTypes[3]);

        do {
            choice = input.nextInt();

            if (choice > 0 && choice < 5){
                type = participantTypes[choice-1];
                System.out.println("Du er: " + type);
                check = false;
            } else {
                System.out.println("Venligst vælg én af cyklisttyperne");
                check = true;
            }
        } while (check);

        return type;
    }

    public static String validateEmail() {
        System.out.println("Indtast din Email: ");
        String email = input.next();
        int atPosition = email.indexOf("@");
        int dotPosition = email.lastIndexOf('.');

        do {
            if (atPosition > 0 && dotPosition > atPosition && dotPosition < (email.length()-2) ) {
                System.out.println(email);
                return email;
            } else {
                System.out.println("Denne email kan ikke valideres, skriv venligst en ny: ");
                System.out.println("atPosition:" + atPosition);
                System.out.println("dotPosition:" + dotPosition);
                System.out.println("email.length(): " + email.length());
                email = input.next();
                atPosition = email.indexOf("@");
                dotPosition = email.lastIndexOf('.');
            }
        } while (true);
    }

    public static String validatePassword() {
        System.out.println("Indtast dit password: ");
        String password = input.next();
        int lenght = password.length();
        int numberCount = 0;
        int capitalCount = 0;
        boolean error;
        boolean onlyNumAndLetter = false;

        do {
            lenght = password.length();
            numberCount = 0;
            capitalCount = 0;
            onlyNumAndLetter = false;

            for (int i = 0; i < lenght; i++) {
                // kan ikke tage imod ÆØÅ
                // tager udgangspunkt i ASCII
                // første kigger på numre "48" = '0' "57" = '9'
                // anden kigger på store bogstaver 65 = "A", 90 = "Z"
                // tredje kigger på små bogstaver 97 = "a", 122 = "z"
                if ((password.charAt(i) > 47 && password.charAt(i) < 58)
                        || (password.charAt(i) > 64 && password.charAt(i) < 91)
                        || (password.charAt(i) > 98 && password.charAt(i) < 123)) {
                } else {onlyNumAndLetter = true;}

                if ((password.charAt(i) > 47 && password.charAt(i) < 58)) {
                    numberCount++;
                }
                if ((password.charAt(i) > 64 && password.charAt(i) < 91)) {
                    capitalCount++;
                }

            } //loop stopper

            error = false;

            //error checking
            if (onlyNumAndLetter){
                System.out.println("Dit password må kun indeholde bogstaver og tal");
                error = true;
            }


            if (numberCount < 1) {
                System.out.println("Dit password skal indeholde mindst ét tal");
                error = true;
            }

            if (capitalCount < 1) {
                System.out.println("Dit password skal indeholde mindst ét stort bogstav");
                error = true;
            }

            if (lenght < 4 || lenght > 16) {
                System.out.println("Dit password skal være mellem 4 - 16 karakterer langt");
                error = true;
            }

            if (!error){
                return (password);
            }

            System.out.println("Indtast nyt password:");

            password = input.next();

        }while(error);
        return null;
    }

    public static boolean matchPassword(String password){
            System.out.println("Indtast dit password igen: ");
            String matchPassword = input.next();
            boolean valid;
            do {
                if (password.equals(matchPassword)) {
                    valid = true;
                    System.out.println("Password matcher");
                    return valid;

                } else {
                    valid = false;
                    System.out.println("Passwords matcher ikke, prøv igen: ");
                    matchPassword = input.next();
                }
            } while (!valid);
            return false;
    }
}



