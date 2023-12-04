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
public class backOrder {
    ArrayList<Stock>stock;
    private SalesAssistant assistant;
    private warehouse Warehouse;
    private delivery delivery;
//Constructor:
    //for order List;
    public backOrder(SalesAssistant assistant, warehouse Wareh1,delivery del) {
        this.assistant = assistant;
        this.Warehouse = Wareh1;
        this.delivery = del;
        stock = new ArrayList();
    }
    
    public backOrder(){
        stock = new ArrayList();
    }
    
    public void AddStock(ArrayList<Stock>stock){
        this.stock.addAll(stock);
    }
    
    public void DisplayStock(){
        for(int i=0;i<this.stock.size();i++){
             System.out.println(this.stock.get(i).getName());
        }
       
    }

    @Override
    public String toString() {
        return "backOrder{" + "stock=" + stock + ", assistant=" + assistant + ", Warehouse=" + Warehouse + ", delivery=" + delivery + '}';
    }
}
