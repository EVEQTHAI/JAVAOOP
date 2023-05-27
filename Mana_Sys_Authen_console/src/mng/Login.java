/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mng;

import Data.AccountChecker;
import Data.DealerList;
import java.util.List;


/**
 *
 * @author PC
 */
public class Login {

    public static void main(String[] args) throws Exception {

        Menu menu = new Menu();
        List<String> option = Menu.menuOption();
        DealerList dList = new DealerList();
        AccountChecker check = new AccountChecker();

        System.out.println("***********LOGIN************");
        System.out.println("Please Enter Account: ");
        check.print();
        check.inputAccount();

        int choice = 0;
        do {
            choice = menu.int_getChoice(option);
            switch (choice) {
                case 1:
                    dList.SearchByName();
                    break;
                case 2:
                    dList.addDealer();
                    break;
                case 3:
                    dList.updateDealer();
                    break;
                case 4:
                    dList.removeDealer();
                    break;
                case 5:
                    dList.ReStore();
                    break;
                case 6:
                    dList.printAll();
                    break;
                case 7:
                    dList.printActive();
                    break;
                case 8:
                    dList.printNonactive();
                case 9:
                    dList.SaveToFile("dealers.csv");
                    break;
                case 10:
                    check.inputAccount();
                    break;
                default:
                    System.out.print("BYE.");
            }

        } while (choice > 0 && choice <= 10);
    }
}
