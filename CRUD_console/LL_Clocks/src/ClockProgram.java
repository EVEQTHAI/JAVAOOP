
import Data.ClockList;
import tools.Menu;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author PC
 */
public class ClockProgram {
    public static void main(String[] args) {
        Menu menu = new Menu();
        menu.add("Add new clock");
        menu.add("Search a clock");
        menu.add("Remove a clock");
        menu.add("Update a clock");
        menu.add("Print all clock");
        menu.add("view clocks in range of price");
        
        ClockList list = new ClockList();
        int choice;
        do{
            choice = menu.getChoice();
            switch(choice){
                case 1:
                    list.addClock();break;
                case 2:
                    list.searchClock();break;
                case 3:
                    list.removeClock();break;
                case 4:
                    list.updateClock();break;
                case 5:
                    list.printAll();break;
                case 6:
                    list.printPriceRange();break;
                default: System.out.println("Bye!");
                        
            }
        }while(choice>=0 && choice<=menu.size());
    }
}
