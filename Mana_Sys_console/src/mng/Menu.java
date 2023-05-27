/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mng;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author PC
 */
    public class Menu extends ArrayList<String>{
    
    static Scanner sc = new Scanner(System.in);

    public Menu() {
        super();
    }
    public int getChoice(){
        int i = 1;
        for (String option: this){
            System.out.println((i++)+"-"+option);
        }
        System.out.println("Choose: ");
        return Integer.parseInt(sc.nextLine());
    }
    
}

