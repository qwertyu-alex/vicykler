public class Main {
    public static void main(String[] args) {

        Virksomhed Google = new Virksomhed("Google");
        Participant John = new Participant();
        Participant Peter = new Participant();


        Hold alpha = new Hold();
        Google.addHold(alpha);
        Google.addHold(new Hold());

        System.out.println(Google.getAntalVirkDeltagere());



    }
}
