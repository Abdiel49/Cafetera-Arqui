package com.Cafetera;

public abstract class Tank {

    protected final int capacity;
    protected       int quantity;

    public Tank( int capacity ){
        this.capacity = capacity;
        this.quantity = 0;
    }
}
