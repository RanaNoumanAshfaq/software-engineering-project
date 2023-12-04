/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oopsystem;

import java.util.Scanner;

/**
 *
 * @author aliha
 */
public class SalesAssistant extends person {

    //Constructor:
    private Store store1;
    private warehouse wareh1;
    private Order r;
    public SalesAssistant( String name, int Id, String store_loc) {
        super(name, Id, store_loc);
    }
    public void SetStore(Store store){
        this.store1 = store;
    }
    
    public void SetWarehouse(warehouse warehh){
        this.wareh1 = warehh;
    }
   /* public void setOrder(Order order){
        this.r = order;
    }
  
    public Order getOrder(){
        return r;
    }*/
   //FUNCTIONS:
   
    public void ProcessOrder(){
       
        
        Scanner s = new Scanner(System.in);
      
      System.out.println(" Enter customer information : ");
      //     Customer Info 
       System.out.println("Name : ");
       String cname = s.nextLine();
       while(!ValidString(cname)){
          System.out.println("! Invalid");
          cname = s.nextLine();
       }
       
       System.out.println("ID : ");
       while(!s.hasNextInt()){
           System.out.println("Invalid! Enter again");
           s.next();
       }
       int id = s.nextInt();
       s.nextLine();
       System.out.println("Store Name Added: ");
       String s_name = this.store_loc;
     
       System.out.println("Adress : ");
       String adress = s.nextLine();
       
       Customer c = new Customer(cname , id,s_name,adress);
        System.out.println(" ** Customer Info Added **");
       // Customer Info end
       //choose products
       
       store1.ChooseProducts(this);
       
  
        //delivery:
        System.out.println("Enter Delivery option");
        System.out.println("1 --->> Store Pickup");
        System.out.println("2 --->> Home Delivery");
        delivery delivery1=null;
        
        boolean deliv_check = false;
                
        while(!deliv_check){
            while(!s.hasNextInt()){
            System.out.println("Invalid! Enter again");
            s.next();
            }
            int option = s.nextInt();
        switch(option){
            case 1:{
                delivery1 = new Store_pickup(0);
                 deliv_check =true;
                break;
            }
            case 2:{
                System.out.println("Enter distance");
                while(!s.hasNextInt()){
                    System.out.println("Invalid ! Enter Again");
                    s.next();
                }
                int km = s.nextInt();
                if(km>5){
                    System.out.println("Distance is more than 5 km --> Delivery charges : 100");
                    delivery1 = new homeDelivery(100);
                }
                else{
                    System.out.println("Distance is within 5 km --> Delivery charges : 50");
                    delivery1 = new homeDelivery(50);
                }
                deliv_check =true;
                break;
            }
            default:{
                System.out.println("Enter 1 OR 2");
                break;
            }
        }
        }
        System.out.println(" ** Delivery Info Added ** ");
        //delivery end
        
        //payment:
        Payment pay=null;
        System.out.println("Enter payment method :");
        System.out.println("1 for cash 2 for card");
        
        boolean pay_check = false;
        double tot_check_amount = delivery1.getCharges()+store1.getProductAmount();
        while(!pay_check){
            while(!s.hasNextInt()){
            System.out.println("Invalid! Enter again ");
            s.next();
            }
        int pay_opt = s.nextInt();
        switch(pay_opt){
            case 1:{
                
                System.out.println("Enter amount");
              
                boolean check_tot = false;
                while(!check_tot){
                    while(!s.hasNextDouble()){
                    System.out.println("Inavlid! enter again");
                    s.next();
                    }
                    double a = s.nextDouble();
                    if(a<tot_check_amount){
                        System.out.println("Amount is below Total amount");
                        
                    }
                    else{
                        pay = new cash(a);
                        
                        check_tot= true;
                    }
                }
                
                
                
                pay_check = true;
                break;
            }
            case 2:{
                System.out.println("Enter card num");
                while(!s.hasNextLong()){
                    System.out.println("Invalid!");
                    s.next();
                }
                long card_num = s.nextLong();
                s.nextLine();
                System.out.println("Enter expiry date");
                String date = s.nextLine();
                while(!ValidString(date)){
                    System.out.println("Invalid");
                    date = s.nextLine();
                }
                System.out.println("Enter amount");
                while(!s.hasNextDouble()){
                    System.out.println("Inavlid! enter again");
                    s.next();
                }
                double am =s.nextDouble();
                
                pay = new card(card_num,am,date);
                pay_check= true;
                break;
            }
            default:{
                System.out.println("Enter 1 for Cash  2 for card");
                break;
            }
        }
        }
        
        
        //billing:
        double total = delivery1.getCharges()+store1.getProductAmount();
        System.out.println("___________ BILL ___________");
        System.out.println("Total Amount --> "+total);
        System.out.println("Backorder Amount --->"+amount12);
        System.out.println("Amount Paid" + pay.getAmount());
        
        System.out.println("Remaining" +(pay.getAmount()-(total+amount12)));
        
        //order:
        System.out.println("====< Order Placed >====");
        Order order1 = new Order(1,c,pay,delivery1);
        System.out.println("Order status completed");
        order1.setStatus("Completed");
        s.nextLine();
        System.out.println("Enter delivery status:");
        String dels= s.nextLine();
        while(!ValidString(dels)){
            System.out.println("Invalid!");
            dels = s.nextLine();
        }
        delivery1.setDelivery_status(dels);
        
        System.out.println(order1);
        store1.returnOrder().Display();
        System.out.println(" --- Order ADDED in List --- ");
        ol= new OrderList();
        ol.AddOrder(order1);
    }




//reminder
    private int parameter;
    private double amount12;
    public void CreateBackOrder(int parameter){
        this.parameter = parameter;
         wareh1.SelectProducts();
        //delivery:
        System.out.println(" --- Enter Delivery Info ---");
        System.out.println("1 ---->> Store Delivery");
        System.out.println("2 ---->> Home Delivery");
        delivery delivery1=null;
        
        boolean deliv_check = false;
                
        while(!deliv_check){
            while(!s.hasNextInt()){
            System.out.println("! Invalid");
            s.next();
            }
            int option = s.nextInt();
        switch(option){
            case 1:{
                System.out.println("Charges --> 100");
                delivery1 = new storeDelivery(12333,100);
                deliv_check =true;
                break;
            }
            case 2:{
                System.out.println("Enter distance");
                while(!s.hasNextInt()){
                    System.out.println("Invalid !");
                    s.next();
                }
                int km = s.nextInt();
                if(km>5){
                    System.out.println("Distance is more than 5 km --> Delivery charges : 100");
                    delivery1 = new homeDelivery(100);
                }
                else{
                    System.out.println("Distance is within 5 km --> Delivery charges : 50");
                    delivery1 = new homeDelivery(50);
                }
                deliv_check =true;
                break;
            }
            default:{
                System.out.println("Enter 1 OR 2");
                break;
            }
            
            }
        }
        
        System.out.println(" ** Delivery Info Added ** ");
        
        if(parameter == 1){
          amount12 = wareh1.getStockAmount()+delivery1.getCharges();
          return;   
        }
        else{
        //payment:
         Payment pay=null;
        System.out.println("Enter payment method :");
        System.out.println("1 for cash 2 for card");
       
        boolean pay_check = false;
        double amount11 = wareh1.getStockAmount()+delivery1.getCharges();
        while(!pay_check){
             while(!s.hasNextInt()){
            System.out.println("Invalid! Enter again ");
            s.next();
            }
            int pay_opt = s.nextInt();
            switch(pay_opt){
            case 1:{
                
                System.out.println("Enter amount");
              
                boolean check_tot = false;
                while(!check_tot){
                    while(!s.hasNextDouble()){
                    System.out.println("Inavlid! enter again");
                    s.next();
                    }
                    double a = s.nextDouble();
                    if(a<amount11){
                        System.out.println("Amount is below Total amount");
                        
                    }
                    else{
                        pay = new cash(a);
                        
                        check_tot= true;
                    }
                }
                
                
                
                pay_check = true;
                break;
            }
            case 2:{
                System.out.println("Enter card num");
                while(!s.hasNextLong()){
                    System.out.println("Invalid!");
                    s.next();
                }
                long card_num = s.nextLong();
                s.nextLine();
                System.out.println("Enter expiry date");
                String date = s.nextLine();
                while(!ValidString(date)){
                    System.out.println("Invalid");
                    date = s.nextLine();
                }
                System.out.println("Enter amount");
                while(!s.hasNextDouble()){
                    System.out.println("Inavlid! enter again");
                    s.next();
                }
                double am =s.nextDouble();
                
                pay = new card(card_num,am,date);
                pay_check= true;
                break;
            }
            default:{
                System.out.println("Invalid! Enter 1 for Cash  2 for card");
                break;
            }
        }
        }
        
        
        /*Payment pay=null;
        System.out.println(" ---- Enter payment method ---- ");
        System.out.println("1 --->> cash");
        System.out.println(" 2 --->> card");
        while(!s.hasNextInt()){
            System.out.println("Invalid !");
            s.next();
        }
        int pay_opt = s.nextInt();
        switch(pay_opt){
            case 1:{
                System.out.println("Enter amount");
                double a = s.nextDouble();
                pay = new cash(a);
                break;
            }
            case 2:{
                System.out.println("Enter card num");
                while(!s.hasNextLong()){
                    System.out.println("Invalid !");
                    s.next();
                }
                long card_num = s.nextLong();
                s.nextLine();
                System.out.println("Enter expiry date");
                String date = s.nextLine();
                while(!ValidString(date)){
                System.out.println("Invalid!");
                date = s.nextLine();
                }
                System.out.println("Enter amount");
                while(!s.hasNextDouble()){
                    System.out.println("Invalid !");
                    s.next();
                }
                double am =s.nextDouble();
                
                pay = new card(card_num,am,date);
                break;
            }
        }
         */
        //billing:
        System.out.println("___________BILL___________");
        double total = delivery1.getCharges()+wareh1.getStockAmount();
        System.out.println("total amount --> "+total);
        
        System.out.println("Amount paid" + pay.getAmount());
        
        System.out.println("Remaining" +(pay.getAmount()-total));
        
        //order:
        
        System.out.println("Enter delivery status:");
        s.nextLine();
        String dels= s.nextLine();
        delivery1.setDelivery_status(dels);
        backOrder border = new backOrder(this,wareh1,delivery1);
        System.out.println("___ BACKORDER ADDED IN LIST ___");
        bol= new OrderList();
        bol.AddBackOrder(border);
       
    }
         
    }
    
    public void CheckStock(Store s){
            
            this.store1 = s;
            
            System.out.println("_____ Checking Stock ______");
            s.Display();
            
    }
    //for adding and displaying order
    private OrderList ol= null;
    private OrderList bol = null;
    public void ChecckOrder(){
        System.out.println("1 --->> Order");
        System.out.println("2 --->> Back Order");
        while(!s.hasNextInt()){
            System.out.println("Invalid! Enter again");
            s.next();
        }
        while(!s.hasNextInt()){
            System.out.println("Invalid !");
            s.next();
        }
        int opt = s.nextInt();
       switch(opt){
           case 1:{
                if(ol != null){
                     System.out.println("Displaying order");
                     ol.DisplayOrder();
                }
                else{
                     System.out.println("Order not placed");
                }
                break;
            }
           case 2:{
               if(bol != null){
                   System.out.println("Displaying Back Order");
                   bol.DisplayBackOrder();
               }
               else{
                   System.out.println("BackOrder not Placed");
               }
               break;
           }
       }
    }
    
    //checking input
    
    public static boolean ValidString(String name){
         return name.matches("[a-zA-Z ]+");
     }
}
