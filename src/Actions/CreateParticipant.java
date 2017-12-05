//Alexander Van Le && Oliver Lange

package Actions;

import Classes.Participant;

import java.util.Scanner;
import java.util.regex.Pattern;

import Classes.Person;
import Data.Data;

public class CreateParticipant {
    private static Scanner input = new Scanner(System.in);

    public static Participant run(Data data) {
        String[] participantTypes = {"Master", "Enthusiast", "Cruiser", "Debutant"};

        System.out.println("Opretter deltager");

        //GetName
        String participantName = validateName();

        //GetType
        String cyclistType = validateType(participantTypes);

        //GetEmail
        String participantEmail = validateEmail(data);

        //GetPassword
        String participantPassword = validatePassword();

        //CheckPassword
        boolean passCheck = matchPassword(participantPassword);

        System.out.println("Bruger er nu oprettet");
        if (passCheck){
            return data.generateParticipant(participantName, participantEmail, participantPassword, cyclistType);
        } else {
            return null;
        }

    }

    private static String validateName() {
        System.out.println("Indtast deltagernavn: ");

        String name = input.nextLine();

        do {
            if (Pattern.matches("[a-zA-Z ]+", name)){
                return name;
            } else {
                System.out.println("Et navn kan kun indeholde bogstaver, prøv igen: ");
                name = input.nextLine();
            }
        } while (true);
    }


    private static String validateType(String[] participantTypes){
        String choice;
        String type = "";
        boolean check;

        System.out.println("Indtast nummeret på den typen af cyklist: " + "\n1) " + participantTypes[0] +
                "\n2) " + participantTypes[1] + "\n3) " + participantTypes[2] + "\n4) " + participantTypes[3]);

        do {
            choice = input.nextLine();

            switch (choice){
                case "1":
                case "2":
                case "3":
                case "4":
                    type = participantTypes[Integer.parseInt(choice)-1];
                    System.out.println("Du er: " + type);
                    check = false;
                    break;
                default:
                    System.out.println("Venligst vælg én af cyklisttyperne");
                    check = true;

            }
        } while (check);

        return type;
    }

    private static String validateEmail(Data data) {
        System.out.println("Indtast Email: ");
        String email;
        int atPosition, dotPosition;
        boolean alreadyExist;


        while(true) {
            email = input.nextLine();
            atPosition = email.indexOf("@");
            dotPosition = email.lastIndexOf('.');
            alreadyExist = false;


            if (atPosition > 0 && dotPosition > atPosition && dotPosition < (email.length()-2)
                    && email.lastIndexOf("@") == email.indexOf("@") && !email.contains(" ")) {
                for (Person person:data.getPersons()) {
                    if (email.equals(person.getEmail())){
                        alreadyExist = true;
                    }
                }

                if (!alreadyExist){
                    System.out.println(email);
                    return email;
                } else {
                    System.out.println("Email eksisterer allerede. Vælg en ny:");
                }

            } else {
                System.out.println("Denne email er ikke valid, skriv venligst en ny: ");
            }
        }
    }

    //Kildehenvisning:
    //Youtube.com: Password Validate Simple Java Program. (Internet).
    //Wikipedia.org: ASCII. (Internet).
    private static String validatePassword() {
        System.out.println("Indtast password: ");
        String password = input.nextLine();
        int length;
        int numberCount;
        int capitalCount;
        boolean error;
        boolean onlyNumAndLetter;

        while (true) {
            length = password.length();
            numberCount = 0;
            capitalCount = 0;
            onlyNumAndLetter = false;

            for (int i = 0; i < length; i++) {
                // kan ikke tage imod ÆØÅ
                // tager udgangspunkt i ASCII
                // første kigger på numre "48" = '0' "57" = '9'
                // anden kigger på store bogstaver 65 = "A", 90 = "Z"
                // tredje kigger på små bogstaver 97 = "a", 122 = "z"
                onlyNumAndLetter = !((password.charAt(i) > 47 && password.charAt(i) < 58)
                            || (password.charAt(i) > 64 && password.charAt(i) < 91)
                            || (password.charAt(i) > 96 && password.charAt(i) < 123));


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
                System.out.println("Password må kun indeholde bogstaver og tal");
                error = true;
            }


            if (numberCount < 1) {
                System.out.println("Password skal indeholde mindst ét tal");
                error = true;
            }

            if (capitalCount < 1) {
                System.out.println("Password skal indeholde mindst ét stort bogstav");
                error = true;
            }

            if (length < 4 || length > 16) {
                System.out.println("Password skal være mellem 4 - 16 karakterer langt");
                error = true;
            }

            if (!error){
                return (password);
            }

            System.out.println("Indtast nyt password:");

            password = input.nextLine();

        }
    }

    private static boolean matchPassword(String password){
        String matchPassword;
        System.out.println("Indtast password igen: ");
        while (true) {
            matchPassword = input.nextLine();
            if (password.equals(matchPassword)) {
                System.out.println("Password matcher");
                return true;

            } else {
                System.out.println("Passwords matcher ikke, prøv igen: ");
            }
        }
    }
}



