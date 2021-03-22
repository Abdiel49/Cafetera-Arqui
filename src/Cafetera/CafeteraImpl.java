package Cafetera;

import Enums.CoffeeMakers;
import Enums.CoffeeType;
import Events.EventListener;
import Events.EventTypes;

public class CafeteraImpl implements Cafetera {

  private  final CoffeeMakers coffeMaker;
  private EventListener listener;
  private int WATER, COFFEE, BORRA;

  public CafeteraImpl() {
    this.coffeMaker = CoffeeMakers.COMMON;
  }

  @Override public void loadCoffee() {
    this.COFFEE = coffeMaker.COFFEE_CAPACITY();
    notifyListeners(EventTypes.COFFEE_FILLED);
  }

  @Override public void loadWater() {
    this.WATER = coffeMaker.WATTER_CAPACITY();
    notifyListeners( EventTypes.WATER_FILLED);
  }

  @Override public boolean giveACoffee(CoffeeType coffeeType) {
    if( canCoffeeBePrepared( coffeeType ) ){
      WATER   -= coffeeType.getWater();
      COFFEE  -= coffeeType.getCoffee();
      BORRA   += coffeeType.getBorra();
      notifyListeners( EventTypes.SUCCESSFULLY );
      return true;
    }
    return false;
  }

  private boolean canCoffeeBePrepared(CoffeeType coffeeType) {
    boolean water   = checkWaterTank  ( coffeeType.getWater() );
    boolean coffee  = checkCoffeeTank ( coffeeType.getCoffee());
    boolean borra   = checkBorraTank  ( coffeeType.getBorra() );
    return water && coffee && borra;
  }

  private boolean checkWaterTank(int waterValue) {
    if(WATER < waterValue) {
      notifyListeners( EventTypes.WATER_ERROR );
      return false;
    }
    return true;
  }

  private boolean checkCoffeeTank(int coffeValue){
    if(COFFEE < coffeValue) {
      notifyListeners( EventTypes.COFFEE_ERROR );
      return  false;
    }
    return true;
  }

  private boolean checkBorraTank(int borraValue){
    if((BORRA+borraValue) > coffeMaker.BORRA_CAPACITY()) {
      notifyListeners( EventTypes.BORRA_ERROR );
      return false;
    }
    return true;
  }

  @Override public void subscribe(EventListener listener) {
    this.listener = listener;
  }

  private void notifyListeners(EventTypes event){
    this.listener.onEventOccurs(event);
  }
}
