package com.example.ktran.pa06;

/**
 * Created by ktran on 11/5/17.
 */

public class Pizza extends FoodItem {

    boolean mushrroms, pineapples, fish; // 3 check box
    boolean gluten_free; //switch
    boolean thin_crust; //radio
    boolean thicc_crust; //radio
    int s_bnar = 0; // weird bar


    public Pizza() {
        super("Pizza", 6.88);
    }

    /**
     *  Getters/Setters for all our fields.
     * @return
     */
    public boolean isMushrroms() {
        return mushrroms;
    }

    public void setMushrroms(boolean mushrroms) {
        this.mushrroms = mushrroms;
    }

    public boolean isPineapples() {
        return pineapples;
    }

    public void setPineapples(boolean pineapples) {
        this.pineapples = pineapples;
    }

    public boolean isFish() {
        return fish;
    }

    public void setFish(boolean fish) {
        this.fish = fish;
    }

    public boolean isGluten_free() {
        return gluten_free;
    }

    public void setGluten_free(boolean gluten_free) {
        this.gluten_free = gluten_free;
    }

    public boolean isThin_crust() {
        return thin_crust;
    }

    public void setThin_crust(boolean thin_crust) {
        this.thin_crust = thin_crust;
    }

    public boolean isThicc_crust() {
        return thicc_crust;
    }

    public void setThicc_crust(boolean thicc_crust) {
        this.thicc_crust = thicc_crust;
    }

    public int getS_bnar() {
        return s_bnar;
    }

    public void setS_bnar(int s_bnar) {
        this.s_bnar = s_bnar;
    }

}
