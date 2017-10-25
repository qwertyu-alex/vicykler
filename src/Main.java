public class Main {
    public static void main(String[] args) {

        Virksomhed Google = new Virksomhed("Google");
        Deltager John = new Deltager();
        Deltager Peter = new Deltager();


        Hold alpha = new Hold();
        Google.addHold(alpha);
        Google.addHold(new Hold());

        System.out.println(Google.getAntalVirkDeltagere());



    }
}
