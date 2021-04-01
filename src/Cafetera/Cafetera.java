package Cafetera;

import Enums.CoffeeType;
import Events.EventChange;

public interface Cafetera extends EventChange {
  boolean giveACoffee(CoffeeType coffeeType);
  boolean turnOnOff();
  void loadCoffee();
  void loadWater();
  void emptyBorra();
}
