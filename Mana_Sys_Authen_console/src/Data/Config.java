/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Data;

import java.io.BufferedReader;
import java.io.FileReader;
/**
 *
 * @author PC
 */
public class Config {

    private static final String CONFIG_FILE = "D:\\CodeJava\\Lab211_Assignment1\\config.properties";
    private String user_file;
    private String dealer_file;

    public Config() {
        readData();
    }
    
    
    private void readData() {
        try{
            FileReader fr = new FileReader(CONFIG_FILE);
            BufferedReader bf = new BufferedReader(fr);
            String line = "";
            while ((line = bf.readLine()) != null) {
                String[] temp = line.split("=");
                line = line.toLowerCase();
                if (line.contains("users")) {
                    user_file = temp[1].trim();
                }
                if (line.contains("dealer")) {
                    dealer_file = temp[1].trim();
                }

            }
            fr.close();
            bf.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String getUser_file() {
        return user_file;
    }

    public String getDealer_file() {
        return dealer_file;
    }


    
}
