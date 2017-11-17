package Main;

import java.util.Scanner;

import Classes.Admin;
import Classes.Person;
import Data.Data;
import Actions.Menu;


public class MainController {
    //private Data.Data data;

    public MainController(){
        //this.data = new Data.Data();
    }

    public void run(){

//        Menu menu = new Menu();
//        Data data = new Data();
//        menu.run(data);
        Data data = new Data();
        Admin admin = new Admin("geh", "geh@he","rewqr");
        admin.changeTeamName();

    }
}
