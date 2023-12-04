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
public class StockManager extends person {

     //Constructor:
    public StockManager(String name, int Id, String store_loc) {
        super(name, Id, store_loc);
    }
    
    //Function:
    public void monitorStocklev(){
        System.out.println("-------Stock Level Monitored -----");
    }
   
    public void PrintSalesReport(){
        System.out.println("-------Sales Report Printed -----");
    }
    
    public void checkStockArrival(){
        System.out.println("-------Checking Stock Arrival ----");
    }
}
