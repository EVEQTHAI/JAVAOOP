/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Data;

import java.util.LinkedList;
import java.util.Scanner;
import tools.MyTools;

/**
 *
 * @author PC
 */
public class ClockList extends LinkedList<Clock> {

    static Scanner sc = MyTools.sc;

    public ClockList() {
    }

    public void addClock() {
        int pos;
        String ID;
        do {
            ID = MyTools.readPatter("Enter ID Cxxx", "C[\\d]{3}");
            pos = this.indexOf(new Clock(ID));
            if (pos >= 0) {
                System.out.println("ID is duplicate!");
            }
        } while (pos >= 0);
        //bảo hành 6 tháng
        System.out.println("Guarantee maximun is 6 month: ");
        int guaratee = MyTools.readInt("Guarate: ", 0, 6);
        System.out.println("Price at least 0.0$");
        double price = MyTools.readDouble("Price", 0.0);

        Clock clk = new Clock(ID, guaratee, price);
        this.addLast(clk);
        System.out.println("A new Clock is added.");
    }

    public void searchClock() {
        String ID = MyTools.readPatter("Enter ID to find Cxxx", "C[\\d]{3}");
        int pos = this.indexOf(new Clock(ID));
        if (pos < 0) {
            System.out.println("Not Found!");
        } else {
            System.out.println("Found: " + this.get(pos));
        }
    }

    public void removeClock() {
        String ID = MyTools.readPatter("Enter ID to find Cxxx", "C[\\d]{3}");
        int pos = this.indexOf(new Clock(ID));
        if (pos < 0) {
            System.out.println("Not Found!");
        } else {
            boolean res = MyTools.readBool("Remove the clock. Really? ");
            if (res == true) {
                this.remove(pos);
                System.out.println("Removed.");
            }
        }
    }

    public void updateClock() {
        String ID = MyTools.readPatter("Enter ID to find Cxxx", "C[\\d]{3}");
        int pos = this.indexOf(new Clock(ID));
        if (pos < 0) {
            System.out.println("Not Found!");
        } else {
            Clock clk = this.get(pos);
            int oldGu = clk.guarantee;
            double oldPri = clk.price;
            //nhập chổ trống không cập nhật
            String input;
            System.out.println("Update guarantee: ");
            System.out.println("Old guarantee: " + oldGu);
            System.out.println("New guarantee: [Enter for bypassing]: ");
            input = sc.nextLine().trim();
            if (input.length() > 0) {
                clk.setGuarantee(Integer.parseInt(input));
            }
            System.out.println("Old price: " + oldPri);
            System.out.println("New price :[Enter for bypassing: ]");
            input = sc.nextLine().trim();
            if (input.length() > 0) {
                clk.setPrice(Double.parseDouble(input));
            }
            System.out.println("Updateed.");
        }
    }

    public void printAll() {
        if (this.isEmpty()) {
            System.out.println("Empty List!");
        } else {
            System.out.println("Clock List: ");
            for (Clock clk : this) {
                System.out.println(clk);
                System.out.println(this.size() + " clock(s).");
            }
        }
    }

    //duyệt dồng hồ trong 1 khoản giá 
    public void printPriceRange() {
        if (this.isEmpty()) {
            System.out.println("Empty List!");
        }
        double p1, p2;
        p1 = MyTools.readDouble("Low price: ", 0);
        p2 = MyTools.readDouble("High price", 0);
        if(p1>p2){
            double t = p1;
            p1=p2;
            p2=t;
        }
        for (Clock clk : this) {
            double price = clk.price;
            if(price>=p1 && price<=p2){
                System.out.println(clk);
            }
        }
    }

}
