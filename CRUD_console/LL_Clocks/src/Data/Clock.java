/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Data;

/**
 *
 * @author PC
 */
public class Clock implements Comparable<Clock>{
    String ID;
    int guarantee=0;//tháng bảo hành
    double price=0.0;

    public Clock(String ID, int guarantee, double price) {
        this.ID = ID;
        this.guarantee=guarantee;
        this.price=price;
    }
    public Clock(String ID){
        this.ID=ID;
    }

     //Kiểm tra bằng nhau để tìm kiếm
    @Override
    public boolean equals(Object obj) {
        Clock clk = (Clock)obj;
        return this.ID.equals(clk.ID);
    }
     
    @Override
    public int compareTo(Clock o) {
        double d = this.price-o.price;
        return d>0? 1: d<0? -1: ID.compareTo(o.ID);
    }

    @Override
    public String toString() {
        return ID+", "+guarantee+", "+price;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public int getGuarantee() {
        return guarantee;
    }

    public void setGuarantee(int guarantee) {
        this.guarantee = guarantee;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
    
    
    
    
}
