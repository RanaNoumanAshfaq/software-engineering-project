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
public class OrderList {
    ArrayList<Order> order;
    ArrayList<backOrder>  border;

    public OrderList(){
        order = new ArrayList();
        border = new ArrayList();
    }
    
    public void AddOrder(Order o1){
        this.order.add(o1);
        
    }
    
    public void DisplayOrder(){
        System.out.println("Displaying Order ---");
        System.out.println(order);
    }
    
    public void AddBackOrder(backOrder b1){
        this.border.add(b1);
    }
    
    public void DisplayBackOrder(){
        System.out.println("Displaying BackOrder ---");
        System.out.println(border);
    }
    
}
