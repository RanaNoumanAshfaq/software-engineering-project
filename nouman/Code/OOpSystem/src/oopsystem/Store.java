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
public class Store {
   //product total:
    
    private double total_amount=0; 
    ArrayList<Product>products;
    public Store(){
        products = new ArrayList();
    }
    
    public void addProduct(Product p){
        this.products.add(p);
    }
   
    public void Display(){
        for(int i=0; i<this.products.size();i++){
            
            System.out.println("Name --> "+this.products.get(i).getName());
             System.out.println("Price --> "+this.products.get(i).getPrice());
              System.out.println("Stock --> "+this.products.get(i).getStock());
                System.out.println("Selected Quantity --> "+this.products.get(i).getQuantity());
                  System.out.println("--------------------");
        }
    }
    
    //used in sales assistant 
    private Order order1 = new Order();
    private SalesAssistant sa;
    public void ChooseProducts(SalesAssistant sa ){
        
        this.sa =sa;
 
        Order order= new Order();
        Scanner s = new Scanner(System.in);
        System.out.println("_____MENU_____");
        System.out.println("Lays--> id:11");
        System.out.println("Pepsi--> id:12");
        System.out.println("Juice--> id:13");
        //product id;
        System.out.println("Enter product id");
        while(!s.hasNextInt()){
            System.out.println("Invalid !");
            s.next();
        }
        int p_id = s.nextInt();
        double tot_amount=0;
        boolean check=true;
       while(check != false) {
           boolean flag=false;
        for(int i=0;i<products.size();i++){
            
            if(p_id == products.get(i).getId()){
                flag = true;
                System.out.println("Product name : "+products.get(i).getName()+" Product price "+products.get(i).getPrice());
                System.out.println("Enter Quantity");
                
                while(!s.hasNextInt()){
                    System.out.println("Invalid !");
                    s.next();
                }
                //checking stock:
                int quan = s.nextInt();
                //calculation:
                if(quan <= products.get(i).getStock()){
                    Product product = products.get(i);
                    
                    products.get(i).setQuantity(quan);
                    
                    order.addProduct(product);
                    order1= order;
                    tot_amount += (products.get(i).getPrice()*quan);
                    
                    total_amount = tot_amount;
                    int update_stock = products.get(i).getStock() - quan;
                    //stock updated:
                    products.get(i).SetStock(update_stock);
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
                    System.out.println("Out of Stock ...");
                    System.out.println("For BackOrder Press 1 Or Remove Product Press 2");
                    while(!s.hasNextInt()){
                        System.out.println("Invalid !");
                        s.next();
                    }
                    int rr = s.nextInt();
                    switch (rr){
                        case 1:{
                            //use of sale assistant
                            sa.CreateBackOrder(1);
                            break;
                        }
                        case 2:{
                            System.out.println("removed");
                            order.removeProduct(products.get(i));
                            break;
                        }
                    }
                    
                    System.out.println("Wanna Enter more products: 1 for yes and 2 for no");
                    boolean p_c = false;
                    while(!p_c){
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
                            p_c = true;
                            break;
                        }
                        case 2:{
                            check = false;
                            p_c = true;
                            break;
                        }
                        default:{
                            System.out.println("Invalid! Enter Again");
                        }
                    }
                    }
                   
                    
                }
            }
            
        }
        if(!flag){
            System.out.println("Better Try 11,12 or 13");
            while(!s.hasNextInt()){
            System.out.println("Invalid !");
            s.next();
        }
            p_id=s.nextInt();
        }
       }
        //product completed:
       
    }
    public Order returnOrder(){
        return order1;
    }
     public double getProductAmount(){
            return total_amount;
        }
    
    
    
    
}
