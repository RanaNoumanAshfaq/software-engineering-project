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
public class OOpSystem {

    /**
     * @param args the command line arguments
     */
 /*   public static void main(String[] args) {
    
        Scanner s = new Scanner(System.in);
      
      
       //product :
       Product p1 = new Product("lays",11,100,3);
       Product p2 = new Product("pepsi",12,20,3);
       Product p3 = new Product("juice",13,60,3);
       //Adding to store:
       Store store1 = new Store();
       store1.addProduct(p1);
       store1.addProduct(p2);
       store1.addProduct(p3);  
    
    //Create BAckOrder Product:
        Stock product1 = new Stock(11,"Lays",60,100);
        Stock product2 = new Stock(12,"Pepsi",60,100);
        Stock product3 = new Stock(13,"Juice",100,100);
        
        //adding to warehouse :
        warehouse wareh1 = new warehouse("ali","denmark");
        wareh1.AddStock(product1);
        wareh1.AddStock(product2);
        wareh1.AddStock(product3);
       
        
        //START:
        int personOpt;
        boolean check = false;
        do{
            System.out.println("------ WELCOME ------");
            System.out.println("Press 1 for Sales Assistant ...");
            System.out.println("Press 2 for Stock Manager ...");
            System.out.println("Press 3 for Store Manager ...");
            System.out.println("Press 4 to EXIt");
        //check input
        while(!s.hasNextInt()){
            System.out.println("Invalid! Enter input in Numbers:");
            s.next();
        }
       
         personOpt = s.nextInt();
         s.nextLine();
        
        switch(personOpt){
            case 1:{
                //Sales Assitant Info
                System.out.println("------Sales Assistant Info-----");
                //input name:
                System.out.println("Enter Name ");
                String name = s.nextLine();
                while(!ValidString(name)){
                    System.out.println(" ! Invalid");
                    name = s.nextLine();
                }
                //input id:
                System.out.println("Enter Id ");
                while(!s.hasNextInt()){
                    System.out.println("Invalid ! Enter input in Numbers:");
                    s.next();
                }
                int id = s.nextInt();
                s.nextLine();
                //input location:
                System.out.println("Enter Store Location ");
                String loc = s.nextLine();
                while(!ValidString(loc)){
                    System.out.println("Invaled");
                    loc = s.nextLine();
                }
                
                SalesAssistant assistant1 = new SalesAssistant(name,id,loc);
                
                assistant1.SetStore(store1);
                assistant1.SetWarehouse(wareh1);
                System.out.println("** Sales Assistant Info Added **");
                //menu:
                boolean check1 = false;
                do{
                System.out.println("________SELECT OPTION________");
                System.out.println("Press 1 ---> Process Order");
                System.out.println("Press 2 ---> Create BackOrder");
                System.out.println("Press 3 ---> Check Stock");
                System.out.println("Press 4 ---> Check Order");
                System.out.println("Press 0 ---> To EXIT");
                while(!s.hasNextInt()){
                    System.out.println("Invalid! Enter again :");
                    s.next();
                }
                int menu = s.nextInt();
                switch(menu){
                    case 1:
                    {
                        assistant1.ProcessOrder();
                        break;
                    }
                    case 2:
                    {
                        assistant1.CreateBackOrder(0);
                        break;
                    }
                    case 3:
                    {
                        assistant1.CheckStock(store1);
                        break;
                    }
                    case 4:{
                        assistant1.ChecckOrder();
                        break;
                    }
                    case 0:{
                        check1 = true;
                        break;
                    }
                    default:
                    {
                        System.out.println("INVALID! Enter Again");
                        while(!s.hasNextInt()){
                            System.out.println("INVALID! Enter in Numbers");
                            s.next();
                        }
                        menu = s.nextInt();
                    }
                }    
                }while(!check1);
                
                
                break;
                
            }
            case 2:{
                   System.out.println("Enter Name ");
                String name = s.nextLine();
                while(!ValidString(name)){
                    System.out.println("! Invalid");
                    name = s.nextLine();
                }
                //input id:
                System.out.println("Enter Id ");
                while(!s.hasNextInt()){
                    System.out.println("Invalid! Enter input in Numbers:");
                    s.next();
                }
                int id = s.nextInt();
                s.nextLine();
                //input location:
                System.out.println("Enter Store Location ");
                String loc = s.nextLine();
                while(!ValidString(loc)){
                    System.out.println("! Invalid");
                    loc = s.nextLine();
                }
                 StockManager stm = new StockManager(name,id,loc);
                 boolean check2 = false;
                 do{
                  
                System.out.println("------- Stock manager -------");
                System.out.println("Press 1 ---> Monitor stock level");
                System.out.println("Press 2 ---> Print sales Report ");
                System.out.println("Press 3 ---> Check Stock Arrival");
                while(!s.hasNextInt()){
                    System.out.println("Enter integers only!");
                    s.next();
                }
               
                int opti = s.nextInt();
                switch(opti){
                    case 1:{
                        stm.monitorStocklev();
                        break;
                    }
                    case 2:{
                        stm.PrintSalesReport();
                        break;
                    }
                    case 3:{
                        stm.checkStockArrival();
                        break;
                    }
                    case 0:{
                        System.out.println("Exit");
                        check2 =true;
                        break;
                    }
                    default:{
                        System.out.println("Invalid!Enter again");
                        while(!s.hasNextInt()){
                        System.out.println("Enter integers only!");
                        s.next();
                        }
                          opti = s.nextInt();
                        break;
                    }
                 }
                
                }while(!check2);
                break;
                
            }
            case 3:{
                 System.out.println("Enter Name ");
                String name = s.nextLine();
                while(!ValidString(name)){
                    System.out.println("! Invalid");
                    name = s.nextLine();
                }
                //input id:
                System.out.println("Enter Id ");
                while(!s.hasNextInt()){
                    System.out.println("Invalid! Enter input in Numbers:");
                    s.next();
                }
                int id = s.nextInt();
                s.nextLine();
                //input location:
                System.out.println("Enter Store Location ");
                String loc = s.nextLine();
                while(!ValidString(loc)){
                    System.out.println("! Invalid");
                    loc = s.nextLine();
                }
                StoreManager srm = new StoreManager(name,id,loc);
                 boolean check3 = false;
                 do{
                  
                System.out.println("Store manager -----");
                System.out.println("Press 1 ---> Print sales report");
                System.out.println("Press 2 ---> Calculate Bonus ");
                while(!s.hasNextInt()){
                    System.out.println("Enter integers only!");
                    s.next();
                }
               
                int opti = s.nextInt();
                switch(opti){
                    case 1:{
                        srm.PrintSalesReport();
                        break;
                    }
                    case 2:{
                        srm.calculateBonus();
                        break;
                    }
                    
                    case 0:{
                        System.out.println("Exit");
                        check3 =true;
                        break;
                    }
                    default:{
                        System.out.println("Invalid!Enter again");
                        while(!s.hasNextInt()){
                        System.out.println("Enter integers only!");
                        s.next();
                        }
                          opti = s.nextInt();
                        break;
                    }
                 }
                
                }while(!check3);
                break;
            }
            case 4:{
                check = true;
                System.out.println("Program End ----- GoodBye!");
                break;
            }
            default:{
                System.out.println("Invalid Enter again:");
                // while(!s.hasNextInt()){
                  //   System.out.println("Invalid! Enter input in Numbers:");
                    // s.next();
                 //}
                //personOpt = s.nextInt();
                break;
            }
        
        }
        
        }while(!check);
        
        //sa.ProcessOrder();
        //sa.CreateBackOrder(0);
       
    }
     public static boolean ValidString(String name){
         return name.matches("[a-zA-Z ]+");
        }
}*/









//WITH USER ID
    public static void main(String[] args) {
    
        Scanner s = new Scanner(System.in);
      
      
       //product :
       Product p1 = new Product("lays",11,100,3);
       Product p2 = new Product("pepsi",12,20,3);
       Product p3 = new Product("juice",13,60,3);
       //Adding to store:
       Store store1 = new Store();
       store1.addProduct(p1);
       store1.addProduct(p2);
       store1.addProduct(p3);  
    
    //Create BAckOrder Product:
        Stock product1 = new Stock(11,"Lays",60,100);
        Stock product2 = new Stock(12,"Pepsi",60,100);
        Stock product3 = new Stock(13,"Juice",100,100);
        
        //adding to warehouse :
        warehouse wareh1 = new warehouse("ali","denmark");
        wareh1.AddStock(product1);
        wareh1.AddStock(product2);
        wareh1.AddStock(product3);
       
        
        //START:
        //for user id checking
        int checkSA =0;
        int siid = 0;
                String siname =null;
                String siloc = null;
        //
        int personOpt;
        boolean check = false;
        do{
            System.out.println("------ WELCOME ------");
            System.out.println("Press 1 for Sales Assistant ...");
            System.out.println("Press 2 for Stock Manager ...");
            System.out.println("Press 3 for Store Manager ...");
            System.out.println("Press 4 to EXIt");
        //check input
        while(!s.hasNextInt()){
            System.out.println("Invalid! Enter input in Numbers:");
            s.next();
        }
       
         personOpt = s.nextInt();
        
        switch(personOpt){
            case 1:{
                int nid = 0;
                
                
                if(checkSA >0){
                    System.out.println("Enter id");
                    int sid =s.nextInt();
                    if(sid == siid){
                        System.out.println("User found ---");
                        
                    }
                    else{
                        System.out.println("User not found ---");
                        nid=1;
                    }
                }
                if(checkSA == 0 || nid>0){
                    s.nextLine();
                //input name:
                //Sales Assitant info:
                System.out.println("------Sales Assistant Info-----");
                System.out.println("Enter Name ");
                siname = s.nextLine();
                while(!ValidString(siname)){
                    System.out.println("! Invalid");
                    siname = s.nextLine();
                }
                //input id:
                System.out.println("Enter Id ");
                while(!s.hasNextInt()){
                    System.out.println("Invalid! Enter input in Numbers:");
                    s.next();
                }
                siid = s.nextInt();
                s.nextLine();
                //input location:
                System.out.println("Enter Store Location ");
                siloc = s.nextLine();
                while(!ValidString(siloc)){
                    System.out.println("! Invalid");
                    siloc = s.nextLine();
                }
               
                }
                
                
                SalesAssistant assistant1 = new SalesAssistant(siname,siid,siloc);
                 checkSA++;
                assistant1.SetStore(store1);
                assistant1.SetWarehouse(wareh1);
                System.out.println(" **Sales Assistant Info Added ** ");
                //menu:
                boolean check1 = false;
                do{
                System.out.println("_______ SELECT OPTION _________");
                System.out.println("Press 1 ---> Process Order");
                System.out.println("Press 2 ---> Create BackOrder");
                System.out.println("Press 3 ---> Check Stock");
                System.out.println("Press 4 ---> Check Order");
                System.out.println("Press 0 ---> To EXIT");
                while(!s.hasNextInt()){
                    System.out.println("Invalid! Enter again :");
                    s.next();
                }
                int menu = s.nextInt();
                switch(menu){
                    case 1:
                    {
                        assistant1.ProcessOrder();
                        break;
                    }
                    case 2:
                    {
                        assistant1.CreateBackOrder(0);
                        break;
                    }
                    case 3:
                    {
                        assistant1.CheckStock(store1);
                        break;
                    }
                    case 4:{
                        assistant1.ChecckOrder();
                        break;
                    }
                    case 0:{
                        check1 = true;
                        break;
                    }
                    default:
                    {
                        System.out.println("INVALID! Enter Again");
                        while(!s.hasNextInt()){
                            System.out.println("INVALID! Enter in Numbers");
                            s.next();
                        }
                        menu = s.nextInt();
                    }
                }    
                }while(!check1);
                
                
                break;
                
            }
            case 2:{
                   System.out.println("Enter Name ");
                String name = s.nextLine();
                while(!ValidString(name)){
                    System.out.println("! Invalid");
                    name = s.nextLine();
                }
                //input id:
                System.out.println("Enter Id ");
                while(!s.hasNextInt()){
                    System.out.println("Invalid! Enter input in Numbers:");
                    s.next();
                }
                int id = s.nextInt();
                s.nextLine();
                //input location:
                System.out.println("Enter Store Location ");
                String loc = s.nextLine();
                while(!ValidString(loc)){
                    System.out.println("! Invalid");
                    loc = s.nextLine();
                }
                 StockManager stm = new StockManager(name,id,loc);
                 boolean check2 = false;
                 do{
                  
                System.out.println("Stock manager -----");
                System.out.println("Press 1 ---> Monitor stock level");
                System.out.println("Press 2 ---> Print sales Report ");
                System.out.println("Press 3 ---> Check Stock Arrival");
                while(!s.hasNextInt()){
                    System.out.println("Enter integers only!");
                    s.next();
                }
               
                int opti = s.nextInt();
                switch(opti){
                    case 1:{
                        stm.monitorStocklev();
                        break;
                    }
                    case 2:{
                        stm.PrintSalesReport();
                        break;
                    }
                    case 3:{
                        stm.checkStockArrival();
                        break;
                    }
                    case 0:{
                        System.out.println("Exit");
                        check2 =true;
                        break;
                    }
                    default:{
                        System.out.println("Invalid!Enter again");
                        while(!s.hasNextInt()){
                        System.out.println("Enter integers only!");
                        s.next();
                        }
                          opti = s.nextInt();
                        break;
                    }
                 }
                
                }while(!check2);
                break;
                
            }
            case 3:{
                 System.out.println("Enter Name ");
                String name = s.nextLine();
                while(!ValidString(name)){
                    System.out.println("! Invalid");
                    name = s.nextLine();
                }
                //input id:
                System.out.println("Enter Id ");
                while(!s.hasNextInt()){
                    System.out.println("Invalid! Enter input in Numbers:");
                    s.next();
                }
                int id = s.nextInt();
                s.nextLine();
                //input location:
                System.out.println("Enter Store Location ");
                String loc = s.nextLine();
                while(!ValidString(loc)){
                    System.out.println("! Invalid");
                    loc = s.nextLine();
                }
                StoreManager srm = new StoreManager(name,id,loc);
                 boolean check3 = false;
                 do{
                  
                System.out.println("------ Store manager -----");
                System.out.println("Press 1 ---> Print sales report");
                System.out.println("Press 2 ---> Calculate Bonus ");
                while(!s.hasNextInt()){
                    System.out.println("Enter integers only!");
                    s.next();
                }
               
                int opti = s.nextInt();
                switch(opti){
                    case 1:{
                        srm.PrintSalesReport();
                        break;
                    }
                    case 2:{
                        srm.calculateBonus();
                        break;
                    }
                    
                    case 0:{
                        System.out.println("Exit");
                        check3 =true;
                        break;
                    }
                    default:{
                        System.out.println("Invalid!Enter again");
                        while(!s.hasNextInt()){
                        System.out.println("Enter integers only!");
                        s.next();
                        }
                          opti = s.nextInt();
                        break;
                    }
                 }
                
                }while(!check3);
                break;
            }
            case 4:{
                check = true;
                System.out.println("Program End ----- GoodBye!");
                break;
            }
            default:{
                System.out.println("Invalid Enter again:");
                //while(!s.hasNextInt()){
                 //    System.out.println("Invalid! Enter input in Numbers:");
               //      s.next();
             //    }
            //    personOpt = s.nextInt();
                break;
            }
        
        }
        
        }while(!check);
        
        //sa.ProcessOrder();
        //sa.CreateBackOrder(0);
       
    }
     public static boolean ValidString(String name){
         return name.matches("[a-zA-Z ]+");
        }
}

