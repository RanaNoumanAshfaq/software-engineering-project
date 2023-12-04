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
public class storeDelivery extends delivery {
    private int store_id;

    //Constructor:

    public storeDelivery(int store_id, double charges) {
        super(charges);
        this.store_id = store_id;
    }
   

    public int getStore_id() {
        return store_id;
    }

    public void setStore_id(int store_id) {
        this.store_id = store_id;
    }

    
}
