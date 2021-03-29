package Cafetera;

import Enums.CoffeeMakers;
import Enums.CoffeeType;
import Events.EventListener;
import Events.EventTypes;

public class CafeteraImpl implements Cafetera {

  private EventListener listener;
  private final DrainTank waterTank, coffeeTank;
  private final FillingTank borraTank;
  private boolean turnOn_OFf;

  public CafeteraImpl() {
    CoffeeMakers coffeMaker = CoffeeMakers.COMMON;
    this.turnOn_OFf = false;
    this.waterTank  = new DrainTank  ( coffeMaker.WATTER_CAPACITY() );
    this.coffeeTank = new DrainTank  ( coffeMaker.COFFEE_CAPACITY() );
    this.borraTank  = new FillingTank( coffeMaker.BORRA_CAPACITY()  );
  }

  @Override public void turnOnOff(){
    this.turnOn_OFf = !this.turnOn_OFf;
    EventTypes event;
    event = this.turnOn_OFf ?
              EventTypes.TURN_OFF :
              EventTypes.TURN_ON;
    notifyListeners( event );
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
    boolean water   = waterTank.canDrain (coffeeType.getWater());
    boolean coffee  = coffeeTank.canDrain(coffeeType.getCoffee());
    boolean borra   = borraTank.canFillUp(coffeeType.getBorra());
    if(!borra){
      notifyListeners(EventTypes.BORRA_ERROR);
    }
    return turnOn_OFf && water && coffee && borra;
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
