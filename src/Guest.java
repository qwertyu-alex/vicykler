import java.util.Scanner;
import java.util.regex.Pattern;

public class Guest {

        private static String[] participantTypes = {"Enthusiast", "Master", "Cruiser", "Debutant"};
        private static int choice;
        private static String name;
        private static int age;
        private static String email;
        private static String password;
        private static String password1;

        static Scanner input = new Scanner(System.in);

    public static void createUser() {

        System.out.println("Indtast dit fulde navn: ");
        name = input.next();

        System.out.println("Indtast din alder: ");
        age = validateAge(input.nextInt());


        String selectedType;
        boolean check = true;

        do {
            System.out.println("Indtast nummeret på den type af cyklist, som du er: " + "\n1) " + participantTypes[0] +
            "\n2) " + participantTypes[1] + "\n3) " + participantTypes[2] + "\n4) " + participantTypes[3]);
            choice = input.nextInt();

            switch (choice) {
                case 1:
                    //System.out.println(participantTypes[0]);
                    selectedType = participantTypes[0];
                    check = false;
                    break;
                case 2:
                    //System.out.println(participantTypes[1]);
                    selectedType = participantTypes[1];
                    check = false;
                    break;
                case 3:
                    //System.out.println(participantTypes[2]);
                    selectedType = participantTypes[2];
                    check = false;
                    break;
                case 4:
                    //System.out.println(participantTypes[3]);
                    selectedType = participantTypes[3];
                    check = false;
                default:
                    System.out.println("Venligst vælg én af cyklisttyperne");
                    break;
            }
        } while (check);

        System.out.println("Indtast din Email: ");
        email = validateEmail(input.next());

        System.out.println("Indtast dit password: ");
        password = validatePassword(input.next());

        System.out.println("Indtast dit password igen: ");
        password1 = matchPassword(input.next());

    }

        public static boolean validateName(String name) {
            do {
                if (validateName(name)) {
                } else {
                    System.out.println("Et navn kan kun indeholde bogstaver, prøv igen: ");
                    name = input.next();
                }
                return Pattern.matches("[a-zA-Z]+", name);
            } while (true);
        }

        public static String validateEmail(String email) {
            int atPosition = email.indexOf("0");
            int dotPosition = email.lastIndexOf(".");

            do {
                if (atPosition < 1 || dotPosition < atPosition || dotPosition > email.length() - 2) {
                    return email;
                } else {
                    System.out.println("Denne email kan ikke valideres, skriv venligst en ny: ");
                    email = input.next();
                }
            } while (true);
        }

        public static String matchPassword(String password1){
            do {
                if (password.equals(password1)) {
                    //return password1;
                } else {
                    System.out.println("Passwords matcher ikke, prøv igen: ");
                    password = input.next();
                }
            } while (true);
    }

        public static int validateAge(int age){
            do {
                if (age > 14 && age < 99) {
                    return age;
                } else {
                    System.out.println("Du skal vælge en alder mellem 15-99");
                    age = input.nextInt();
                }
            }while(true);
        }

        public static String validatePassword(String password) {
            String result = "Dit password er godkendt";
            int lenght = 0;
            int numberCount = 0;
            int capitalCount = 0;

                for (int i = 0; i < password.length(); i++) {
                    if ((password.charAt(i) >= 47 && password.charAt(i) <= 58) || (password.charAt(i) >= 64
                            && password.charAt(i) <= 91) || (password.charAt(i) >= 97 && password.charAt(i) <= 122)) {
                    } else {
                        result = "Dit password må kun indeholde bogstaver og tal";
                    }
                    if ((password.charAt(i) > 47 && password.charAt(i) < 58)) {
                        numberCount++;
                    }
                    if ((password.charAt(i) > 64 && password.charAt(i) < 91)) {
                        capitalCount++;
                    }
                    lenght = (i + 1);
                }
                if (numberCount <= 1) {
                    result = "Dit password skal indeholde mindst ét tal";
                }
                if (capitalCount <= 1) {
                    result = "Dit password skal indeholde mindst ét stort bogstav";
                }
                if (lenght < 4 || lenght > 16) {
                    result = "Dit password skal være mellem 4 - 16 karakterer langt";
                }
                return (result);
            }
        }



