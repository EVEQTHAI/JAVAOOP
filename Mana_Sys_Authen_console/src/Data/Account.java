/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Data;

/**
 *
 * @author PC
 */
public class Account {
    public String usename;
    public String password;
    public String role;
    public String Status;

    public Account(String usename, String password, String role, String Status) {
        this.usename = usename;
        this.password = password;
        this.role = role;
        this.Status = Status;
    }

    public String getUsename() {
        return usename;
    }

    public void setUsename(String usename) {
        this.usename = usename;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String Status) {
        this.Status = Status;
    }

    @Override
    public String toString() {
        return  usename + " | " + password + " | " + role + " | " + Status + '.';
    }

    
   
    
    
}
