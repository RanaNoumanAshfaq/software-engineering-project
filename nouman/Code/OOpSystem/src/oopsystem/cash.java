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
public class cash extends Payment{

    //Constructor:
    public cash(double amount) {
        super(amount);
        System.out.println("Payment type = CASH");
        super.setType("cash");
    }

    
}
