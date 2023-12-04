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
public abstract class delivery {
    
    double charges;
    private Order order;
    String delivery_status;
    private backOrder border;
    //Constructor:

    public delivery(double charges) {    
        this.charges = charges;
    }
    
    //Getter and Setter

    public double getCharges() {
        return charges;
    }

    public void setCharges(double charges) {
        this.charges = charges;
    }

    public void setOrdder(Order orde){
        this.order = orde;
    }
    
    public Order getOrder(){
        return order;
    }
    
    public String getDelivery_status() {
        return delivery_status;
    }

    public void setDelivery_status(String delivery_status) {
        this.delivery_status = delivery_status;
    }
    
    
    
}
