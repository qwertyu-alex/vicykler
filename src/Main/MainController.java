package Main;

import java.util.Scanner;

import Classes.Person;
import Data.Data;
import Actions.Menu;


public class MainController {

    Scanner input = new Scanner(System.in);
    //private Data.Data data;

    public MainController(){
        //this.data = new Data.Data();
    }

    public void run(){
        Menu menu = new Menu();
        Data data = new Data();
        menu.run(data);
    }
}
