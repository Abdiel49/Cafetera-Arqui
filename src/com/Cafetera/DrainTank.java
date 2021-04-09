package com.Cafetera;
// the coffee tank and water tank use this
public class DrainTank extends Tank{

    public DrainTank(int capacity){
        super(capacity);
    }

    public boolean canDrain(int quantity){
        return this.quantity - quantity >= 0;
    }

    public boolean drain(int quantity){
        if(canDrain(quantity)){
            this.quantity -= quantity;
            return true;
        }
        return false;
    }

    public void fillTank(){
        this.quantity = this.capacity;
    }
}
