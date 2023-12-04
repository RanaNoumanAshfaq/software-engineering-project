/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oopsystem;

/**
 *
 * @author aliha
 */
public abstract class Payment {
   
    protected String type;
    protected double amount;

    //Constructor:
    
    public Payment(double amount) {
        this.amount = amount;
    }

    //Getter and Setter
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Payment{" + "type=" + type + ", amount=" + amount + '}';
    }
    
}
