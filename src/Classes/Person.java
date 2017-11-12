package Classes;//Astrid Christensen

import java.util.ArrayList;

public abstract class Person {

    protected String name;
    protected String email;
    protected String password;

    protected static ArrayList<Person> persons = new ArrayList<>();

    //Constructer
    public Person(String name, String email, String password){
        this.name = name;
        this.email = email;
        this.password = password;

        //tilføj denne person til arraylisten
        persons.add(this);
    }

    //Getter-metoder
    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public static ArrayList<Person> getPersons() {
        return persons;
    }

    //Setter-metoder
    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void showStatistics(){

    }

    //fjern et element fra person arraylisten
    public boolean removePerson(Person person){
        for (Person p : persons) {
            if (p.getEmail().equals(person.getEmail())){
                persons.remove(person);
                person = null;
                return true;
            }
        }
        return false;
    }
}

