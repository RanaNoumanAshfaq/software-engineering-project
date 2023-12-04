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
public class homeDelivery extends delivery {
    private Order order_info;

    //Constructor:

    public homeDelivery( double charges) {
        super(charges);
    }
    

    public Order getOrderInfo() {
        return order_info;
    }

    public void setOrderInfo(Order order_info) {
        this.order_info =order_info;
    }

    @Override
    public String toString() {
        return "homeDelivery{" + "order_info=" + order_info + " charges = "+ charges +" delivery_ status="+ delivery_status +'}';
    }

    

    
    
    
}
