import java.util.ArrayList; //import af Arraylist

public class Data {
    //Attributter
    private ArrayList<Participant> participants;
    private ArrayList<Firm> firms;
    private ArrayList<Team> teams;

    //Constructor
    public Data() {
        this.participants = new ArrayList<Participant>();
        this.firms = new ArrayList<Firm>();
        this.teams = new ArrayList<Team>();
    }


    public void generateData() {

        //*******************opret firma og hold*****************************
        //firma 1 - hold & og 2
        Firm firma1 = new Firm("firma1 - Arla");
        Team f1hold1 = new Team("f1hold1 - Lyserøde enhjørninger", firma1);
        Team f1hold2 = new Team("f1hold2 - Slanke Næsehorn", firma1);

        //firma 2 - hold & og 2
        Firm firma2 = new Firm("firma2 - PostNord");
        Team f2hold1 = new Team("f2hold1 - De flyvende bude", firma1);
        Team f2hold2 = new Team("f2hold2 - Dem som prøvede", firma1);

        //firma 3 - hold & og 2
        Firm firma3 = new Firm("firma 3 - Netto");
        Team f3hold1 = new Team("f3hold1 - Sprinterne", firma1);
        Team f3hold2 = new Team("f3hold2 - De fordømte", firma1);

        //firma 4 - hold & og 2
        Firm firma4 = new Firm("firma4");
        Team f4hold1 = new Team("f4hold1", firma1);
        Team f4hold2 = new Team("f4hold2", firma1);

        //firma 5 - hold & og 2
        Firm firma5 = new Firm("firma5");
        Team f5hold1 = new Team("f5hold1", firma1);
        Team f5hold2 = new Team("f5hold2", firma1);

        //Tilføj firmaer til Arraylisten "firms"
        firms.add(firma1);
        firms.add(firma2);
        firms.add(firma3);
        firms.add(firma4);
        firms.add(firma5);

        //Tilføj hold til Arrraylisten "teams"
        teams.add(f1hold1);
        teams.add(f1hold2);
        teams.add(f2hold1);
        teams.add(f2hold2);
        teams.add(f3hold1);
        teams.add(f3hold2);
        teams.add(f4hold1);
        teams.add(f4hold2);
        teams.add(f5hold1);
        teams.add(f5hold2);


        //opret deltagere og tildel dem firma og hold
        //firma 1 - hold 1
        Participant par1 = new Participant("Flemming Sørensen", "Entusiast", "Flemming@gmail.com", f1hold1, firma1);
        Participant par2 = new Participant("Lennert Andersen", "Mester", "Lennert@gmail.com", f1hold1, firma1);
        Participant par3 = new Participant("Poul Ridderstjerne", "Cruiser", "Poul@gmail.com", f1hold1, firma1);
        Participant par4 = new Participant("Bjarne Simonsen", "Debutant", "Bjarne@gmail.com", f1hold1, firma1);
        Participant par5 = new Participant("Søren Espensen", "Entusiast", "Søren@gmail.com", f1hold1, firma1);

        //Firma 1 - hold 2
        Participant par6 = new Participant("Frodo DatFrodo", "Debutant", "Frodo@gmail.com", f1hold2, firma1);
        Participant par7 = new Participant("Kesi Natteravn", "Cruiser", "Kesi@gmail.com", f1hold2, firma1);
        Participant par8 = new Participant("Jesus Kristus", "Entusiast", "Jesus@gmail.com", f1hold2, firma1);
        Participant par9 = new Participant("Muhammed", "Cruiser", "Muhammed@gmail.com", f1hold2, firma1);
        Participant par10 = new Participant("Johannes Døbberen", "Debutant", "Johannes@gmail.com", f1hold2, firma1);


        //Firma 2 - hold 1
        Participant par11 = new Participant("Pia kærsgård", "Mester", "Pia@gmail.com", f2hold1, firma2);
        Participant par12 = new Participant("Lars Løkke", "Debutant", "Lars@gmail.com", f2hold1, firma2);
        Participant par13 = new Participant("Nazer Khader", "Entusiast", "Nazar@gmail.com", f2hold1, firma2);
        Participant par14 = new Participant("Johannes Smith", "Cruiser", "Johannes@gmail.com", f2hold1, firma2);
        Participant par15 = new Participant("Espen Lunde", "Debutant", "Espen@gmail.com", f2hold1, firma2);

        //Firma 2 - hold 2
        Participant par16 = new Participant("Harry Potter", "Mester", "Harry@gmail.com", f2hold2, firma2);
        Participant par17 = new Participant("Ron Weasley", "Entusiast", "Ron@gmail.com", f2hold2, firma2);
        Participant par18 = new Participant("Hermione etellerandet", "Debutant", "Hermione@gmail.com", f2hold2, firma2);
        Participant par19 = new Participant("Professor Dumbeldore", "Cruiser", "Dumbeldore@gmail.com", f2hold2, firma2);
        Participant par20 = new Participant("Lord Voldemore", "Entusiast", "Voldemore@gmail.com", f2hold2, firma2);


        //Firma 3 - hold 1
        Participant par21 = new Participant("Maveric Mitchell", "Entusiast", "Maveric@gmail.com", f3hold1, firma3);
        Participant par22 = new Participant("Charlie Blackwood", "Debutant", "Charlie@gmail.com", f3hold1, firma3);
        Participant par23 = new Participant("Iceman Kazanski", "Mester", "Iceman@gmail.com", f3hold1, firma3);
        Participant par24 = new Participant("Goose Kazanski", "Cruiser", "Goose@gmail.com", f3hold1, firma3);
        Participant par25 = new Participant("Viper Metcalf", "Debutant", "Viper@gmail.com", f3hold1, firma3);

        //Firma 3 - hold 2
        Participant par26 = new Participant("Justin Bieber", "Entusiast", "Justin@gmail.com", f3hold2, firma3);
        Participant par27 = new Participant("Selena Gomez", "Cruiser", "Selena@gmail.com", f3hold2, firma3);
        Participant par28 = new Participant("Taylor taytay Swift", "Mester", "Taylor@gmail.com", f3hold2, firma3);
        Participant par29 = new Participant("One Direction 1", "Cruiser", "Dreng1@gmail.com", f3hold2, firma3);
        Participant par30 = new Participant("Mads Langer", "Debutant", "Mads@gmail.com", f3hold2, firma3);

        //Evt tilføjelse af flere....

        //Tilføj Deltager til ArrayListe "participants"
        participants.add(par1);
        participants.add(par2);
        participants.add(par3);
        participants.add(par4);
        participants.add(par5);
        participants.add(par6);
        participants.add(par7);
        participants.add(par8);
        participants.add(par9);
        participants.add(par10);
        participants.add(par11);
        participants.add(par12);
        participants.add(par13);
        participants.add(par14);
        participants.add(par15);
        participants.add(par16);
        participants.add(par17);
        participants.add(par18);
        participants.add(par19);
        participants.add(par20);
        participants.add(par21);
        participants.add(par22);
        participants.add(par23);
        participants.add(par24);
        participants.add(par25);
        participants.add(par26);
        participants.add(par27);
        participants.add(par28);
        participants.add(par29);
        participants.add(par30);


    }

    //Getters

    public ArrayList<Participant> getParticipants() {
        return participants;
    }

    public ArrayList<Firm> getFirms() {
        return firms;
    }

    public ArrayList<Team> getTeams() {
        return teams;
    }

}


