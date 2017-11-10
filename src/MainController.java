import java.util.Scanner;

public class MainController {

    Scanner input = new Scanner(System.in);
    //private Data data;

    public MainController(){
        //this.data = new Data();
    }

    public void run(){
        Menu menu = new Menu();
        Data data = new Data();
        menu.run(data);
    }
}
