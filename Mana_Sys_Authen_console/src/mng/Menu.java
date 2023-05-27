/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mng;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author PC
 */
public class Menu {

    Scanner sc = new Scanner(System.in);

    public static List<String> menuOption() {
        List<String> list = new ArrayList<>();
        list.add("Search Dealers by name");
        list.add("Add a new Dealers");
        list.add("Update Dealers by id ");
        list.add("Remove Dealers by id");
        list.add("Restore Daelers by id");
        list.add("Print All Dealer");
        list.add("Print Active Dealer");
        list.add("Print NonActive Dealer");
        list.add("Save to File ");
        list.add("LogOut ");
        return list;

    }

    public int int_getChoice(List<String> options) {
        int response;
        for (int i = 0; i < options.size(); i++) {
            //System.out.println((i + 1) + "-" + options.get(i));
            System.out.printf("%-2d  -  %s\n", (i + 1), (options.get(i)));
        }

        while (true)
           try {
            System.out.print("Please choose an option 1..." + options.size() + ": ");
            response = Integer.parseInt(sc.nextLine());
            break;
        } catch (Exception e) {
            System.out.println("Option is number. Please enter again!!");
        }
        return response;
    }
}
