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
public class card extends Payment {
    
    private long card_num;
    private String expiry_date;
//expiry date
    
    //Constructor:
    
    public card(long card_num,double amount,String date) {
        super(amount);
        this.expiry_date =date;
        this.card_num = card_num;
        System.out.println("Payment type = CARD");
        super.setType("card");
    }

    public void setDate(String date){
        this.expiry_date = date;
    }
    public String getDate(){
        return expiry_date;
    }
    public long getCard_num() {
        return card_num;
    }

    public void setCard_num(int card_num) {
        this.card_num = card_num;
    }

    @Override
    public String toString() {
        return "card{" + "card_num=" + card_num + ", expiry_date=" + expiry_date + '}';
    }
 
    
}
