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
public class Product {
    private int id;
    private int quantity;
    private double price;
    private String name;
    private int Stock_lev;
    
    //Constructor:

    public Product(String name,int id,double price,int Stock_lev ) {
        this.name = name;
        this.id = id;
        this.price = price;
        this.Stock_lev = Stock_lev;
    }
    
    //Getter and Setter

    public void SetStock(int lev){
        this.Stock_lev = lev;
    }
    
    public int getStock(){
        return Stock_lev;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String location) {
        this.name = name;
    }
//Function:
    public void UpdateStock(){
        System.out.println("Updating Stock --");
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter quantity");
        while(!sc.hasNextInt()){
            System.out.println("Invalid Input , Enter again");
            sc.next();
        }
        int quan = sc.nextInt();
        this.Stock_lev = this.Stock_lev+quan;
    }
    
    
  /*  @Override
    public String toString() {
        return "Product{" + "id=" + id + ", quantity=" + quantity + ", price=" + price + ", name=" + name + ", Stock_lev=" + Stock_lev + '}';
    }
*/

    @Override
    public String toString() {
        return name ;
    }
    
    
}
