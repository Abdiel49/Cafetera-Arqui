package Cafetera;

import Enums.CoffeeType;
import Events.EventChange;

public interface Cafetera extends EventChange {
  void loadCoffee();
  void loadWater();
  boolean giveACoffee(CoffeeType coffeeType);

}
