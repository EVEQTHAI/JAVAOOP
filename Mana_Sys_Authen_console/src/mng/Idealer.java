/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package mng;

/**
 *
 * @author PC
 */
public interface Idealer {
    
    public static final String ENABLE="enabled";
    public static final String DISENABLE="disabled";
    public static final String PHONE_Format="\\d{9}||\\d{11}";
    public static final String ID_format ="D\\d{3}";
    
    public void SearchByName();
    
    public void addDealer();
    
    public void updateDealer();
    
    public void removeDealer();
    
    public void printAll();
    
    public void printActive();
    
    public void printNonactive();
    
    public boolean  SaveToFile(String filename);
}
