/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Data;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author PC
 */
public class AccountChecker extends ArrayList<Account> {

    Scanner sc = new Scanner(System.in);
    String cf;

    public AccountChecker() {
        config();
    }

    public void config() {
        Config c = new Config();
        cf = c.getUser_file();
        loadFromFile(cf);
    }

    public boolean loadFromFile(String filename) {
        try {
            FileReader fr = new FileReader(filename);
            BufferedReader bf = new BufferedReader(fr);
            String line;
            while ((line = bf.readLine()) != null) {
                String arr[] = line.split("\\|");
                String username = arr[0].trim();
                String password = arr[1].trim();
                String Role = arr[2].trim();
                String Status = arr[3].trim();
                this.add(new Account(username, password, Role, Status));
            }
            bf.close();
            fr.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return true;
    }

    public int SearchUserName(String username) {
        for (int i = 0; i < this.size(); i++) {
            if (this.get(i).usename.equalsIgnoreCase(username)) {
                return i;
            }
        }
        return -1;
    }

    public int searchPassword(String password) {
        for (int i = 0; i < this.size(); i++) {
            if (this.get(i).password.equalsIgnoreCase(password)) {
                return i;
            }
        }
        return -1;
    }

    public int searchRole(String role) {
        for (int i = 0; i < this.size(); i++) {
            if (this.get(i).role.equalsIgnoreCase(role)) {
                return i;
            }
        }
        return -1;
    }

    public void print() {
        for (int i = 0; i < this.size(); i++) {
            System.out.println(this.get(i).toString());
        }
    }

    public boolean inputAccount() {
        String username, password;
        int p1, p2, p3 = 0;
        boolean  b = false;

        try {
            do {
                System.out.println("Enter Username: ");
                username = sc.nextLine().trim();
                p1 = SearchUserName(username);

                System.out.println("Enter Password: ");
                password = sc.nextLine().trim();
                p2 = searchPassword(password);
                if(p1==p2)p3=p1;
                if (p1 < 0 || p2 < 0 || p1!=p2) {
                    System.out.println("Error Username or Passwork");
                    System.out.println("please enter again!");
                }

            } while (p1 < 0 || p2 < 0 || p1!=p2);

            do {
                if (this.get(p3).getRole().equalsIgnoreCase("ADMIN")) {
                    System.out.println("Can not accept by ADMIN ");
                    inputAccount();break;
                } else {
                    if(this.get(p3).getStatus().equalsIgnoreCase("disabled")){
                        System.out.println("Role: "+this.get(p3).getRole()+" is disabled!!!");
                        readBool("Enter any key to logout>>>>>");
                        inputAccount();break;
                    }else{
                        System.out.println("Role: "+this.get(p3).getRole());
                        b=true;break;
                    }
                }
            } while (b == false);
        } catch (Exception e) {
            System.out.println("Password or username is erroe!");
            inputAccount();
        }
        return false;
    }
    
    public boolean readBool(String message){
        System.out.println(message);
        String s = sc.nextLine().trim().toUpperCase();
        char c = s.charAt(0);
        return (c=='T' || c=='Y' || c=='1');
    }

}
