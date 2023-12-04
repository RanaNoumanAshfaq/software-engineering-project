/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oopsystem;

import java.util.ArrayList;

/**
 *
 * @author aliha
 */
public class Stock {
    
   private int num;
   private String name;
   private double price;
   private int quantity;
//private Product product;
    public Stock(int num, String name, double price, int quantity) {
        this.num = num;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
   
    //functions:
    public void updateQuantity(int quan){
        this.quantity += quan;
    }
   
       
       
   
}
