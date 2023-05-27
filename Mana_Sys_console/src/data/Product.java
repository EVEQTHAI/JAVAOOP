/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data;

/**
 *
 * @author PC
 */
public class Product implements Comparable<Product>{
    private String ID;
    private String name;
    private double price;
    private int quantity;
    private String status;


    public Product(String ID, String name, double price, int quantity, String status) {
        this.ID = ID;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.status = status;
    }

    public Product() {
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPice() {
        return price;
    }

    
    public void setPice(double pice) {
        this.price = pice;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return  ID + ", " + name + ", " + price + ", " + quantity + ", " + status;
    }

    @Override
    public int compareTo(Product o) {
        return o.name.compareToIgnoreCase(name);
        
        //int quanf = this.quantity-o.quantity;

//        if(S<0) return 1;
//        if(S>0)return -1;
//        return S;
    }
    
    
}
