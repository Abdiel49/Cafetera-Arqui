import Enums.CoffeeMakers;
import Enums.CoffeeType;
import Events.EventChange;
import Events.EventListener;
import Events.EventTypes;

public class CustomCoffeemaker extends Cafetera implements EventChange {
  
  private  final CoffeeMakers coffeMaker;
  private EventListener listener;
  private int WATER, COFFEE, BORRA;

  public CustomCoffeemaker(){
    this.coffeMaker = CoffeeMakers.COMMON;
  }

  public void loadWater(){
    this.WATER = coffeMaker.WATTER_CAPACITY();
  }

  public void loadCoffee(){
    this.COFFEE = coffeMaker.COFFEE_CAPACITY();
  }

  public boolean giveACoffee (CoffeeType coffeeType) {
    if( canCoffeeBePrepared( coffeeType ) ){
      WATER   -= coffeeType.getWater();
      COFFEE  -= coffeeType.getCoffee();
      BORRA   += coffeeType.getBorra();
      return true;
    }
    return false;
  }

  private boolean canCoffeeBePrepared(CoffeeType coffeeType) {
    boolean resp = false;
    if( checkWaterTank  ( coffeeType.getWater()  ) &&
        checkCoffeeTank ( coffeeType.getCoffee() ) &&
        checkBorraTank  ( coffeeType.getBorra()  ) ){
      notifyListeners( EventTypes.SUCCESSFULLY );
    }
    return resp;
  }

  private boolean checkWaterTank(int waterValue) {
    if(WATER < waterValue) {
      notifyListeners( EventTypes.WATER_ERROR );
      return false;
    }
    return false;
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

  @Override
  public void subscribe(EventListener listener) {
    this.listener = listener;
  }

  private void notifyListeners(EventTypes event){
    this.listener.onEventOccurs(event);
  }
}
