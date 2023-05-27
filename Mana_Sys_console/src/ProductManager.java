
import data.ProductList;
//import jdk.nashorn.internal.objects.Global;
import mng.Menu;
import mng.tool;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author PC
 */
public class ProductManager {

    public static void main(String[] args) {
        Menu menu = new Menu();
        menu.add("Print");
        menu.add("Create a Product");
        menu.add("check exits Product");
        menu.add("Search by name ");
        menu.add("Update Prodcut");
        menu.add("Delete Product");
        menu.add("Save to File");
        menu.add("Print list Product from file");
        System.out.println("");
        ProductList list = new ProductList();
        list.LoadFormFile("D:\\CodeJava\\Lab2_Lab211\\Product.dat");
        int choice;
        do {
            choice = menu.getChoice();
            switch (choice) {
                case 1:
                    list.print();
                    break;
                case 2:
                    list.createAProduct();
                    break;
                case 3:
                    list.checkExit();
                    break;
                case 4:
                    list.searchByName();
                    break;
                case 5:
                    list.updateProduct();
                    break;
                case 6:
                    list.deleteProduct();
                    break;
                case 7:
                    list.saveToFile("D:\\CodeJava\\Lab2_Lab211\\Product.dat");
                    break;
                case 8:
                    list.printFormFile();
                    break;
                default:
                  System.out.println("Bye>.<");
            
            }
        } while (choice >= 0 && choice <= 8);
    }
}
