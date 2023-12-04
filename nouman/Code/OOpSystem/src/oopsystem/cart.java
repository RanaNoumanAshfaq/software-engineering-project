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
public class cart {
    //for GUI ADDING PRODUCTS
    private Product pr;
    private int quantity;

    public cart(Product pr, int quantity) {
        this.pr = pr;
        this.quantity = quantity;
    }

    public Product getPr() {
        return pr;
    }

    public void setPr(Product pr) {
        this.pr = pr;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    
    
}
