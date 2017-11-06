package com.example.ktran.pa06;

import java.io.Serializable;
import java.text.DecimalFormat;

public class FoodItem implements Serializable{
    DecimalFormat formatter = new DecimalFormat("#0.00");

    String name;
    double cost;
    int order_num;

    public FoodItem(){

    }

    public FoodItem(String name, double cost){
        this.name = name;
        this.cost = cost;
    }

    /**
     *  Setters/Getters for our fields
     * @return fields
     */
    public int getOrder_num() {
        return order_num;
    }

    public void setOrder_num(int order_num) {
        this.order_num = order_num;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    /**
     * Returns the string type we want to see from the lists
     * @return
     */
    @Override
    public String toString() {
        return getName() + " ($" + formatter.format(getCost()) + ")    Order - " +  getOrder_num();
    }
}
