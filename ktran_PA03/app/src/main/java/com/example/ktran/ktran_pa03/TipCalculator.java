package com.example.ktran.ktran_pa03;

/**
 * Created by ktran on 10/3/17.
 */

public class TipCalculator {

    double bill;
    double percent_tip;

    public TipCalculator(double b, double pt){
        this.percent_tip = pt;
        this.bill = b;
    }
    //returns the tip amount based on the bill and the tip percent
    public double calculateTip(){
        return (this.percent_tip/100) * bill;
    }

    //returns the total bill based on the bill and calculateTip()
   public  double calculateTotalBill(){
       return calculateTip() + this.bill;
   }

   //Setters and getters for our field.
   public void set_bill(double b){
       this.bill = b;
   }

    public void set_percent_tip(double tip){
        this.percent_tip = this.percent_tip;
    }

    public double get_bill(){
        return this.bill;
    }

    public double get_tip(){
        return this.percent_tip;
    }

}
