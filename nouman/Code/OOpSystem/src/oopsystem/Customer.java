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
public class Customer extends person {
    private String adress;
    private Payment py;

    //Constructor:
    public Customer(String name, int Id, String store_loc,String adress) {
        super(name, Id, store_loc);
        this.adress = adress;
       
    }
    //for GUI:
    public Customer(){
        
    }
   
    //Getter and Setter

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public Payment getPy() {
        return py;
    }

    public void setPy(Payment py) {
        this.py = py;
    }

    @Override
    public String toString() {
        return "Customer{" +" name=" + super.name+" id="+ super.Id +" Store=" +super.store_loc+  " adress=" + adress + ", py=" + py + '}';
    }

    


    
}
