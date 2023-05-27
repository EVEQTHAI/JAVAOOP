/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mng;

import java.util.Scanner;

/**
 *
 * @author PC
 */
public class tool {

    public static Scanner sc = new Scanner(System.in);

    //nhập số thực trong khoản
    public static double readDouble(String message, double min, double max) {
        double t;
        if (min > max) {
            t = min;
            min = max;
            max = t;
        }
        boolean OK = false;
        do {
            System.out.println(message + ": ");
            t = Double.parseDouble(sc.nextLine());
            OK = (t >= min && t <= max);
        } while (!OK);
        return t;
    }

    public static int CheckInt(String message, int min, int max, int oldData) {
        String tmp;
        int value = 0;
        boolean cont = true;
        do {
            try {
                System.out.println(message);
                tmp = sc.nextLine();
                if (tmp.isEmpty()) {
                    value = oldData;
                } else {
                    value = Integer.parseInt(tmp);
                }
                cont = false;
            } catch (Exception e) {
                System.out.println("Retype an integer: ");
            }
        } while (cont == true || value < min || value > max);
        return value;
    }
    
    public static double CheckDouble(String message, double min, double max, double oldData) {
        String tmp;
        double value = 0;
        boolean cont = true;
        do {
            try {
                System.out.println(message);
                tmp = sc.nextLine();
                if (tmp.isEmpty()) {
                    value = oldData;
                } else {
                    value = Double.parseDouble(tmp);
                }
                cont = false;
            } catch (Exception e) {
                System.out.println("Retype an integer: ");
            }
        } while (cont == true || value < min || value > max);
        return value;
    }

    // Nhập số nguyên trông khoản 
    public static int readInt(String message, int min, int max) {
        int t;
        if (min > max) {
            t = min;
            min = max;
            max = t;
        }
        boolean OK;
        do {
            System.out.println(message + ": ");
            t = Integer.parseInt(sc.nextLine());
            OK = (t >= min && t <= max);
        } while (!OK);
        return t;
    }
    //nhập chuổi không được bỏ trống

    public static String readNonBlankStr(String meassgae) {
        String S;
        boolean OK = true;
        do {
            System.out.println(meassgae + ": ");
            S = sc.nextLine().trim();
            if (S == null || S.isEmpty()) {
                OK = false;
            }
        } while (!OK);
        return S;
    }

    //nhập Boolean;
    public static boolean readBool(String message) {
        char c;
        do {
            System.out.println(message + " [T/F, Y/N, 1/0: ]");
            String S = sc.nextLine().trim().toUpperCase();
            c = S.charAt(0);
        } while (c != 'T' & c != 'F' && c != 'Y' && c != 'N' && c != '1' && c != '0');
        return (c == 'T' || c == 'Y' || c == '1');
    }

    public static String readPatter(String message, String regex) {
        String S;
        boolean OK;
        do {
            System.out.println(message + ": ");
            S = sc.nextLine().trim();
            OK = S.matches(regex);
            if (!OK) {
                System.out.println("Invalid Input! ");
            }
        } while (!OK);
        return S;
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

    public static String readString(String message, String regex, String oldData) {
        String str;
        boolean OK, count = true;
        do {
            System.out.println(message);
            str = sc.nextLine().trim();
            if (str.isEmpty()) {
                str = oldData;
                count = false;
            }
            OK = str.matches(regex);
            if (!OK) {
                System.out.println("Invalid Input! ");
            }
        } while (count == true && !OK);
        return str;
    }

}
