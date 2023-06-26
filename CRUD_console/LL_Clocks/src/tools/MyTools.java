/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tools;

import java.util.Scanner;

/**
 *
 * @author PC
 */
public class MyTools {
    public static  Scanner sc= new Scanner(System.in);
    
    // Nhập số nguyên trông khoản 
    public static  int readInt(String message, int min, int max){
        int t;
        if(min>max){
            t=min;min=max;max=t;
        }
        boolean OK;
        do{
            System.out.println(message+": ");
             t=Integer.parseInt(sc.nextLine());
            OK = (t>=min && t<=max);
        }while(!OK);
        return t;
    }
    
    //nhập số nguyên >=min
    public static int readInt(String message, int min){
        return readInt(message, min, Integer.MAX_VALUE);
    }
    
    //nhập số thực trong khoản
    public static  double readDouble(String message, double min, double max){
        double t ;
        if(min>max){
            t=min;min=max;max=t;
        }
        boolean OK=false;
        do{
            System.out.println(message+": ");
            t=Double.parseDouble(sc.nextLine());
            OK=(t>=min && t<=max);
        }while (!OK);
        return t;
    }
    
    //nhập số thực lớn hơn min
    public static double readDouble(String message, double min){
        return readDouble(message, min,Double.MAX_VALUE);
    }
    
    //nhập chuổi không được bỏ trống
    public static String readNonBlankStr(String meassgae){
        String S;
        boolean OK=true;
        do{
            System.out.println(meassgae+": ");
            S=sc.nextLine().trim();
            if(S==null || S.isEmpty()) OK=false;
        }while(!OK);
        return S;
    }
    
    //regex theo mẫu
    public static String readPatter(String message, String regex){
        String S;
        boolean OK;
        do{
            System.out.println(message+": ");
            S=sc.nextLine().trim();
            OK=S.matches(regex);
            if(!OK) System.out.println("Invalid Input! ");
        }while (!OK);
        return S;
    }
    
    //nhập Boolean;
    public static boolean readBool(String message){
        System.out.println(message+" [T/F, Y/N, 1/0: ]");
        String S=sc.nextLine().trim().toUpperCase();
        char c = S.charAt(0);
        return (c=='T' || c=='Y' || c=='1');
    }
    public static String getString(String message, String oldData) {
        String str;
        boolean cont = true;
        do {
            System.out.print(message);
            str = sc.nextLine();
            if (str.isEmpty()) {//neu khong nhap thi gan gtr cu
                str = oldData;
            }
            cont = false;
        } while (cont == true);
        return str;
    }
}
