/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oopsystem;

import java.util.Scanner;

/**
 *
 * @author aliha
 */
public class person {
    protected String name;
    protected int Id;
    protected String store_loc;
    
    //Constructor:
    //for GUI
    public person(){
        
    }
    
    public person(String name, int Id, String store_loc) {
        this.name = name;
        this.Id = Id;
        this.store_loc = store_loc;
    }
    
    //Getter and Setter
    //name 
  Scanner s = new Scanner(System.in);
    public String getName() {
        return name;
    }
    
    public void inputName(){
        System.out.println("Enter Name ...");
        String name = s.nextLine();
        setName(name);
    }
    
    public void setName(String name) {
        this.name = name;
    }
    //name
    
    //id
    public int getId() {
        return Id;
    }
    
    public void inputId(){
        System.out.println("Enter Id ...");
        int id = s.nextInt();
        setId(id);
    }
    
    public void setId(int Id) {
        this.Id = Id;
    }
    //id
    
    //Store location
    public String getStore_loc() {
        return store_loc;
    }
    
    public void inputStoreLoc(){
        System.out.println("Enter Store location....");
        String store = s.nextLine();
        setStore_loc(store);
    }
    
    public void setStore_loc(String store_loc) {
        this.store_loc = store_loc;
    }
    //Store location
   
    
}
