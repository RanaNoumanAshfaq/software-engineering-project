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
public class StoreManager extends person {

    //Constructors:
    public StoreManager(String name, int Id, String store_loc) {
        super(name, Id, store_loc);
    }
    //function
    public void PrintSalesReport(){
        System.out.println("Sales Report Printed -----");
        
    }
    
    public void calculateBonus(){
        System.out.println("Bonus Calculated -------");
    }
}
