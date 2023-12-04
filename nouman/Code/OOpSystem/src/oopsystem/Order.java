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
public class Order {

    private int number;
    private Customer c;
    private String loc;
    private String des;
    private delivery delivery;
    private String status;
    private Payment payment;
    private ArrayList<Product>product;

    public Order(){
         product= new ArrayList();
    }
    
    public Order(int number, Customer c,Payment payment,delivery d) {
        this.number = number;
        this.c = c;
        this.loc = c.getStore_loc();
        this.des = c.getAdress();
        this.payment = payment;
        this.delivery=d;
        product= new ArrayList();
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public Customer getC() {
        return c;
    }

    public void setC(Customer c) {
        this.c = c;
    }

    public String getLoc() {
        return loc;
    }

    public void setLoc(String loc) {
        this.loc = loc;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    public void addProduct(Product p){
        this.product.add(p);
    }
    
    public void removeProduct(Product p){
        this.product.remove(p);
    }
    public void Display(){
        for(int i=0; i<this.product.size();i++){
            
            System.out.println(this.product.get(i).getName());
             System.out.println(this.product.get(i).getPrice());
              System.out.println(this.product.get(i).getQuantity());
        }
    }

    
   
    public delivery getDelivery() {
        return delivery;
    }

    public void setDelivery(delivery delivery) {
        this.delivery = delivery;
    }

    @Override
    public String toString() {
        return "Order{" + "number=" + number + ", c=" + c + ", loc=" + loc + ", des=" + des + ", delivery=" + delivery + ", status=" + status + ", payment=" + payment + ", product=" + product + '}';
    }

   

    
    
}
