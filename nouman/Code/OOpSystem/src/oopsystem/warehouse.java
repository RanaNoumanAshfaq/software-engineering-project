/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oopsystem;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author aliha
 */
public class warehouse {
   private String person_name;
   private String region;
   ArrayList<Stock>stock;
   private double total_amount=0;
    public warehouse(String person_name, String region) {
        this.person_name = person_name;
        this.region = region;
        stock = new ArrayList();
    }

    public String getPerson_name() {
        return person_name;
    }

    public void setPerson_name(String person_name) {
        this.person_name = person_name;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public void AddStock(Stock stock){
        this.stock.add(stock);
    }
    
    public void DisplayStock(){
       for(int i=0;i<this.stock.size();i++){
           System.out.println(this.stock.get(i).getName());
           System.out.println(this.stock.get(i).getPrice());
           System.out.println(this.stock.get(i).getQuantity());
       }
    }
    Scanner s = new Scanner(System.in);
    public void SelectProducts(){
        backOrder border = new backOrder();
        
        System.out.println("Enter Product id :");
        while(!s.hasNextInt()){
            System.out.println("Invalid !");
            s.next();
        }
        int p_id = s.nextInt();
        double tot_amount=0;
        boolean check=true;
        while(check != false) {
           boolean flag=false;
        for(int i=0;i<stock.size();i++){
            
            if(p_id == stock.get(i).getNum()){
                
                flag = true;
                System.out.println("Product name : "+stock.get(i).getName()+" Product price "+stock.get(i).getPrice());
                System.out.println("Enter quatity");
                //checking stock:
                while(!s.hasNextInt()){
                    System.out.println("Invalid !");
                    s.next();
                }
                int quan = s.nextInt();
                //calculation:
                if(quan <= stock.get(i).getQuantity()){
                    stock.get(i).setQuantity(quan);
                    
                    border.AddStock(stock);
                    
                    tot_amount += (stock.get(i).getPrice()*quan);
                    
                    total_amount = tot_amount;
                    
                    int update_quantity= stock.get(i).getQuantity() - quan;
                    //stock updated:
                    stock.get(i).setQuantity(update_quantity);
                    System.out.println("Wanna Enter more products: 1 for yes and 2 for no");
                    while(!s.hasNextInt()){
                    System.out.println("Invalid !");
                    s.next();
                }
                    int mp= s.nextInt();
                    switch(mp){
                        case 1:{
                            System.out.println("Enter product id");
                            while(!s.hasNextInt()){
                    System.out.println("Invalid !");
                    s.next();
                }
                            
                            p_id = s.nextInt();
                            break;
                        }
                        case 2:{
                            check = false;
                            break;
                        }
                    }
                }
                else{
                    System.out.println(" ... Out of Stock ...");
                    System.out.println("Wanna Enter more products: 1 for yes and 2 for no");
                    boolean s_check = false;
                    while(!s_check){
                    while(!s.hasNextInt()){
                    System.out.println("Invalid !");
                    s.next();
                    }
                    int mp= s.nextInt();
                    switch(mp){
                        case 1:{
                            System.out.println("Enter product id");
                            while(!s.hasNextInt()){
                            System.out.println("Invalid !");
                            s.next();
                            }
                            p_id = s.nextInt();
                            s_check = true;
                            break;
                        }
                        case 2:{
                            check = false;
                            s_check = true;
                            break;
                        }
                        default:{
                            System.out.println("Invalid! Enter Again");
                            break;
                        }
                    }
                    }
                    
                    //create backorder or proceed without backorder
                }
            }
            
        }
        if(!flag){
            System.out.println("Better Try 11,12 or 13");
            p_id=s.nextInt();
        }
       }
        //product completed:
       
        
    }
    public double getStockAmount(){
            return total_amount;
        }
    
    //FUNctions:
    public void checkBackOrderCollection(OrderList ol1){
        OrderList ol = new OrderList();
        ol= ol1;
        System.out.println("Displaying backorder collection");
        ol.DisplayBackOrder();
    }
    
    public void RcieveStock(){
        System.out.println("Stock Recieved ");
    }
}
