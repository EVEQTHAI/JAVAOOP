package Data;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
import mng.Idealer;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author PC
 */
public class DealerList extends ArrayList<Dealer> implements Idealer {

    Scanner sc = new Scanner(System.in);
    String cf;

    public DealerList() {
        congig();
    }

    private void congig() {
        Config c = new Config();
        cf = c.getDealer_file();
        LoadFormFile(cf);
    }

    private void config() {
        Config c = new Config();
        cf = c.getDealer_file();
        SaveToFile(cf);
    }

    public boolean LoadFormFile(String filename) {
        try {
            FileReader fr = new FileReader(filename);
            BufferedReader bf = new BufferedReader(fr);
            String detail;
            while ((detail = bf.readLine()) != null) {
                String arr[] = detail.split("\\|");
                String ID = arr[0].trim();
                String Name = arr[1].trim();
                String Address = arr[2].trim();
                String Phone = arr[3].trim();
                String status = arr[4].trim();
                this.add(new Dealer(ID, Name, Address, Phone, status));
            }
            fr.close();
            bf.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return true;
    }

    public int searchID(String dID) {
        for (int i = 0; i < this.size(); i++) {
            if (this.get(i).getID().equalsIgnoreCase(dID)) {
                return i;
            }
        }
        return -1;
    }

    public int searchName(String name) {
        for (int i = 0; i < this.size(); i++) {
            if (this.get(i).getName().equalsIgnoreCase(name)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public void SearchByName() {
        int count = 0;
        System.out.println("Enter name to search: ");
        String sName = sc.nextLine().toLowerCase().trim();

        for (Dealer x : this) {
            if (x.getName().toLowerCase().contains(sName)) {
                System.out.println(x);
                count++;
            }
        }
        if (count <= 0) {
            System.out.println("Not Found!");
        }

    }

    @Override
    public void addDealer() {
        String ID, name, address, phone;
        String status;
        boolean valid1, valid2;
        int pos;
        System.out.println("Add new Dealer: ");
        do {
            System.out.println("Enter ID: ");
            ID = sc.nextLine().toUpperCase();
            pos = searchID(ID);
            valid1 = ID.matches(ID_format);
            if (!valid1) {
                System.out.println("ID is from [Dxxx]");
            }
            if (pos >= 0) {
                System.out.println("The ID is dupplicated!");
            }
        } while (pos >= 0 || !valid1);
        do {
            System.out.println("Enter Name ");
            name = sc.nextLine().trim();
            if (name.isEmpty()) {
                System.out.println("Don't blank is name!!!");
            }
        } while (name.isEmpty());

        do {
            System.out.println("Enter Address: ");
            address = sc.nextLine().trim();
            if (address.isEmpty()) {
                System.out.println("please enter address!!!");
            }
        } while (address.isEmpty());
        do {
            System.out.println("Enter Phone: ");
            phone = sc.nextLine();
            valid1 = phone.matches(PHONE_Format);
            if (!valid1) {
                System.out.println("The phone is : + 9 digit or 11 digit");
            }
        } while (!valid1);

        do {
            System.out.println("Enter status: ");
            System.out.println("Enter 1 to enable or enter 2 to disable.");
            status = sc.nextLine().trim();
            valid1 = status.matches("1");
            valid2 = status.matches("2");
            if (!valid1 && !valid2) {
                System.out.println("Enter 1 to enable or enter 2 to disable.");
            } else {
                if (valid1 == true) {
                    status = ENABLE;
                    break;
                } else {
                    status = DISENABLE;
                    break;
                }
            }
        } while (!valid1 || !valid2);

        this.add(
                new Dealer(ID, name, address, phone, status));
        System.out.println(
                "Added!");
    }

    @Override
    public void updateDealer() {
        System.out.println("Enter ID dealer Update: ");
        String uID = sc.nextLine().toUpperCase();
        int pos = this.searchID(uID);
        boolean valid;
        if (pos == -1) {
            System.out.println("ID not exsit!");
        } else {
            String oldaddress = this.get(pos).getAddress();
            String oldphone = this.get(pos).getPhone();
            String newAddress = null, newPhone;
            while (newAddress == null || newAddress.isEmpty()) {
                System.out.println("old address " + oldaddress + ", new address: ");
                newAddress = sc.nextLine();
            }
            do {
                System.out.println("old phone " + oldphone + ", new phone: ");
                newPhone = sc.nextLine();
                valid = newPhone.matches(PHONE_Format);
                if (!valid) {
                    System.out.println("The phone is : + 9 digit or 11 digit");
                }
            } while (!valid || newPhone.isEmpty());
            this.get(pos).setAddress(newAddress);
            this.get(pos).setPhone(newPhone);
            System.out.println("Updateed.");
        }
    }

    @Override
    public void removeDealer() {
        System.out.println("Enter ID to remove: ");
        String rID = sc.nextLine().toUpperCase();
        int pos = this.searchID(rID);
        if (pos == -1) {
            System.out.println("Not Found!");
        } else {
            System.out.println("Found: ");
            this.get(pos).setStatus(DISENABLE);
            System.out.println("remove enabled conpleted.");
        }
    }

    @Override
    public void printAll() {
        if (this.isEmpty()) {
            System.out.println("Empty List!");
        }
        for (int i = 0; i < this.size(); i++) {
            System.out.println(this.get(i).toString());
        }
    }

    @Override
    public void printActive() {
        if (this.isEmpty()) {
            System.out.println("Empty List.");
        }
        for (Dealer x : this) {
            if (x.getStatus().equals(ENABLE)) {
                System.out.println(x);
            }
        }
    }

    @Override
    public void printNonactive() {
        if (this.isEmpty()) {
            System.out.println("Empty List.");
        }
        for (Dealer x : this) {
            if (x.getStatus().equals(DISENABLE)) {
                System.out.println(x);
            }
        }
    }

    @Override
    public boolean SaveToFile(String filename) {
        try {
            File f = new File(filename);
            FileWriter fw = new FileWriter(f);
            PrintWriter pw = new PrintWriter(fw);
            for (Dealer x : this) {
                pw.println(x.getID() + "|" + x.getName() + "|" + x.getAddress() + "|" + x.getPhone() + "|" + x.getStatus());
            }
            pw.close();
            fw.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return true;
    }

    public boolean Nonblank(String meassgae) {
        String s;
        boolean OK = true;
        do {
            System.out.println(meassgae + ": ");
            s = sc.nextLine().trim();
            if (s == null || s.isEmpty()) {
                OK = false;
            }
        } while (!OK);
        return true;
    }

    public void ReStore() {
        System.out.println("Enter ID to remove: ");
        String rID = sc.nextLine().toUpperCase();
        int pos = this.searchID(rID);
        if (pos == -1) {
            System.out.println("Not Found!");
        } else {
            System.out.println("Found: ");
            this.get(pos).setStatus(ENABLE);
            System.out.println("remove enabled conpleted.");
        }
    }

}
