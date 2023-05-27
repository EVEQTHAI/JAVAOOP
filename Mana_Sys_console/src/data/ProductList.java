/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import mng.Iproduct;
import mng.tool;

/**
 *
 * @author PC
 */
public class ProductList extends ArrayList<Product> implements Iproduct {

    static Scanner sc = tool.sc;
    ArrayList<Product> c = new ArrayList<>();

    public ProductList() {
    }

    public int searchID(String sID) {
        for (int i = 0; i < this.size(); i++) {
            if (this.get(i).getID().equals(sID)) {
                return i;
            }
        }
        return -1;
    }

    public int searchName(String sName) {
        for (int i = 0; i < this.size(); i++) {
            if (this.get(i).getName().equals(sName)) {
                return i;
            }
        }
        return -1;
    }
    public int checkNameExit(String sName){
        for (int i = 0; i < c.size(); i++) {
            if(c.get(i).getName().equals(sName))
                return i;
        }
        return -1;
    }

    @Override
    public void print() {
        if (this.isEmpty()) {
            System.out.println("Empty List");
        } else {
            for (Product x : this) {
                System.out.println(x.toString());
            }
        }
    }

    public boolean LoadFormFile(String filename) {
        try {
            FileReader fr = new FileReader(filename);
            BufferedReader bf = new BufferedReader(fr);
            String detail;
            while ((detail = bf.readLine()) != null) {
                String arr[] = detail.split("\\,");
                String ID = arr[0].trim();
                String name = arr[1].trim();
                double price = Double.parseDouble(arr[2]);
                int quantity = Integer.parseInt(arr[3]);
                String status = arr[4].trim();
                c.add(new Product(ID, name, price, quantity, status));
                this.add(new Product(ID, name, price, quantity, status));
            }
            fr.close();
            bf.close();
        } catch (Exception e) {
            System.out.println("File not exit!!!");
        }
        return true;
    }

    @Override
    public void createAProduct() {
        int pos, quantity;
        String ID, name, status = null;
        double price;
        boolean valid1, valid2;
        do {
            ID = tool.readPatter("Enter ID: ", ID_FORMAT);
            pos = searchID(ID);
            if (pos >= 0) {
                System.out.println("ID is dupplicate!");
            }
        } while (pos >= 0);
        do {
            name = tool.readPatter("Enter new name: ", NAME_FORTMAT);
            pos = searchName(name);
            if (pos >= 0) {
                System.out.println("Name is dupplicate!");
            }
        } while (pos >= 0);
        price = tool.readDouble("Enter Price ranges from 0 to 10000 :", 0, 10000);
        quantity = tool.readInt("Enter Quantity ranges form 0 to 1000 : ", 0, 1000);

        boolean b = tool.readBool("Enter Y to Available or enter N to Not Available");
        if (b == true) {
            status = AVA;
        } else if (b == false) {
            status = NOTAVA;
        }
        this.add(new Product(ID, name, price, quantity, status));
        System.out.println("Created.");
        if(Comeout(false)){
            System.out.println("Add Continute: ");
            createAProduct();
        } 
    }

    @Override
    public void checkExit() {
        int count = 0;
        boolean b=false;
        if (c.isEmpty()) {
            System.out.println("Empty list");
        } else {
            System.out.println("Enter name to check: ");
            String name = sc.nextLine().toLowerCase().trim();
            for (Product x : c) {
                if (x.getName().toLowerCase().equals(name)) {
                    System.out.println("Name is exit.");
                    b=true;
                    break;
                    //count++;
                }
            }
            if (!b) {
                System.out.println("Name is not Exit!!!");
            }
        }
        if(Comeout(false)){
            System.out.println("Check continute: ");
            checkExit();
        }
    }

    @Override
    public void searchByName() {
        int count = 0;
        System.out.println("Enter name to search: ");
        String sName = sc.nextLine().toLowerCase().trim();

        for (Product x : this) {
            if (x.getName().toLowerCase().contains(sName)) {
                System.out.println(x);
                count++;
            }
        }
        if (count <= 0) {
            System.out.println("Not Found!");
        }
        if(Comeout(false)){
            System.out.println("Search again: ");
            searchByName();
        }
    }

    @Override
    public void updateProduct() {
        if (this.isEmpty()) {
            System.out.println("Empty list");
        } else {
            String ID = tool.readPatter("Enter ID ", ID_FORMAT);
            int pos = searchID(ID);
            if (pos < 0) {
                System.out.println("Not FOund!");
            } else {
                String oldname = this.get(pos).getName();
                double oldPrice= this.get(pos).getPice();
                int oldQuan=this.get(pos).getQuantity();
                String status = null;
                String name = tool.readString("Enter new name: ", NAME_FORTMAT, oldname);
                double price = tool.CheckDouble("Enter price ranges from 0 to 10000", 0, 10000, oldPrice);
                int quantity = tool.CheckInt("Enter quantity ranges from 0 to 1000", 0, 1000,oldQuan);
                boolean b = tool.readBool("Enter Y to Available or enter N to Not Available");
                if (b == true) {
                    status = AVA;
                } else if (b == false) {
                    status = NOTAVA;
                }
                this.get(pos).setName(name);
                this.get(pos).setPice(price);
                this.get(pos).setQuantity(quantity);
                this.get(pos).setStatus(status);
                System.out.println("Update succsessfull.");
            }
        }
        if(Comeout(false)){
            System.out.println("Update continute: ");
            updateProduct();
        }
    }

    @Override
    public void deleteProduct() {
        if (this.isEmpty()) {
            System.out.println("Empty List!");
        } else {
            String ID = tool.readPatter("Enter ID: ", ID_FORMAT);
            int pos = searchID(ID);
            if (pos < 0) {
                System.out.println("Not found");
            } else {
                boolean b = tool.readBool("Delete!");
                if (b == true) {
                    this.remove(pos);
                    System.out.println("Remove successfull.");
                } else {
                    System.out.println("Remove NOT SUCCESSFULL!!!");
                }
            }
        }
        if(Comeout(false)){
            System.out.println("Delete continute: ");
            deleteProduct();
        }
    }

    @Override
    public boolean saveToFile(String filename) {
        try {
            File f = new File(filename);
            FileWriter fw = new FileWriter(f);
            PrintWriter pw = new PrintWriter(fw);
            for (Product x : this) {
                pw.println(x.getID() + "," + x.getName() + "," + x.getPice() + "," + x.getQuantity() + "," + x.getStatus());
            }
            pw.close();
            fw.close();
            System.out.println("Writed...");
        } catch (Exception e) {
            System.out.println("Writed not successfull!!!");
        }
        return true;
    }

    @Override
    public void printFormFile() {
        if (this.isEmpty()) {
            System.out.println("Empty List");
        } else {
            Collections.sort(this);
            for (Product x : this) {
                System.out.println(x);
            }
        }
    }

    public boolean Comeout(boolean b) {
        b = tool.readBool("Back to main menu agnain?");
        if (b == true) {
            return false;
        } else if(b==false) {
            return true;
        }
        return b;
    }

}
