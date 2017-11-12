package Actions;//Alexander Le && Oliver Lange.,-æøæø
import Actions.Menu;
import Classes.Person;

import java.util.*;

public class Login {

    public Login(){}

    public Person run(Menu menu){
        Scanner input = new Scanner(System.in);
        String email;
        String password;

        System.out.println("Venligst indtast din email");
        email = input.next().toLowerCase();
        System.out.println("Venligst indtast dit password");
        password = input.next();

        //Tjek om der er fundet en bruger
        if (findPerson(email, password) instanceof Person){
            return (findPerson(email, password));
        } else {
            System.out.println("Bruger ikke fundet");
            return null;
        }
    }

    private Person findPerson(String email, String password){
        for (Person p : Person.getPersons()) {
            if (p.getEmail().toLowerCase().equals(email) && p.getPassword().equals(password)){
                    return p;
            }
        }
        return null;
    }
}
