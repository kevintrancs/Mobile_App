/**
 * Class name: TipCalculator
 *
 * fields:
 *      double bill
 *      int percent_tip
 *
 * methods:
 *      calculateTip(): Calculates the tip
 *      calculateTotalBill(): Adds calculateTip + bill
 *
 *    A bunch of setters and getters I don't use.
 */

package com.example.ktran.ktran_pa03;

import android.util.Log;


public class TipCalculator {

    double bill;
    int percent_tip;

    public TipCalculator(double b, int pt){
        this.percent_tip = pt;
        this.bill = b;
    }

    /**
     * Setters and getters...
     *
     */
    public void set_bill(double b){
       this.bill = b;
   }

    public void set_percent_tip(int tip){

        this.percent_tip = tip;
    }

    public double get_bill(){

        return this.bill;
    }

    public int get_tip(){
        return this.percent_tip;

    }

    /**
     * Gets tip
     *
     * @param
     * @return tip
     */
    public double calculateTip(){
        return ((double)this.percent_tip/100) * bill;
    }

    /**
     * Gets total amount
     *
     * @param
     * @return total bill
     */
    public  double calculateTotalBill(){

        return calculateTip() + this.bill;
    }

}
