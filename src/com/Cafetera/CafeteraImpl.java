package com.Cafetera;

import com.Enums.CoffeeMakers;
import com.Enums.CoffeeType;
import com.Events.EventListener;
import com.Events.EventTypes;

public class CafeteraImpl implements Cafetera {

    private EventListener listener;
    private final DrainTank waterTank, coffeeTank;
    private final GarbageTank borraTank;
    private boolean turnOn_OFf;

    public CafeteraImpl() {
        CoffeeMakers coffeMaker = CoffeeMakers.COMMON;
        this.turnOn_OFf = false;
        this.waterTank  = new DrainTank  (coffeMaker.WATTER_CAPACITY());
        this.coffeeTank = new DrainTank  (coffeMaker.COFFEE_CAPACITY());
        this.borraTank  = new GarbageTank(coffeMaker.BORRA_CAPACITY());
    }

    @Override public boolean turnOnOff(){
        this.turnOn_OFf = !this.turnOn_OFf;
        EventTypes event;
        event = turnOn_OFf ?
            EventTypes.TURN_ON :
            EventTypes.TURN_OFF;
        notifyListeners( event );
        return this.turnOn_OFf;
    }

    @Override public void loadCoffee() {
        coffeeTank.fillTank();
        notifyListeners(EventTypes.COFFEE_FILLED);
    }

    @Override public void loadWater() {
        waterTank.fillTank();
        notifyListeners( EventTypes.WATER_FILLED);
    }

    @Override public boolean giveACoffee(CoffeeType coffeeType) {
        EventTypes event;
        if( turnOn_OFf ){
            boolean result = checkTanks( coffeeType );
            event = result ?
                EventTypes.SUCCESSFULLY :
                EventTypes.UN_SUCCESS;
            notifyListeners( event );
            return true;
        }

        return false;
    }

    private boolean checkTanks(CoffeeType coffeeType){
        int coffeeAmount = coffeeType.getCoffee(),
            waterAmount  = coffeeType.getWater(),
            borraAmount  = coffeeType.getBorra();
        boolean water  = waterTank.canDrain ( waterAmount );
        boolean coffee = coffeeTank.canDrain( coffeeAmount );
        boolean borra  = borraTank.canFillUp( borraAmount );
        if(!borra){
            notifyListeners(EventTypes.BORRA_FILLED);
            return false;
        }
        if( !water || !coffee ){
            return false;
        }
        waterTank.drain(waterAmount);
        coffeeTank.drain(coffeeAmount);
        borraTank.fillUp(borraAmount);
        return true;
    }

    @Override public void emptyBorra(){
        this.borraTank.drainTank();
        notifyListeners(EventTypes.BORRA_EMPTIED);
    }

    @Override public void subscribe(EventListener listener) {
        this.listener = listener;
    }

    private void notifyListeners(EventTypes event){
        if(this.listener != null){
            this.listener.onEventOccurs(event);
        }
    }
}
