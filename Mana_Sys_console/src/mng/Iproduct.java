/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package mng;

/**
 *
 * @author PC
 */
public interface Iproduct {

    public static final String AVA = "Available";
    public static final String NOTAVA = "Not Available";
    public static final String NAME_FORTMAT = "[\\s\\S]{5,10}$";
    public static final String ID_FORMAT = "\\d{4}";

    public void print();

    public void createAProduct();

    public void checkExit();

    public void searchByName();

    public void updateProduct();

    public void deleteProduct();

    public boolean saveToFile(String filename);

    public void printFormFile();
}
