package com.Cafetera;

import com.Enums.CoffeeType;
import com.Events.EventChange;

public interface Cafetera extends EventChange {
  boolean giveACoffee(CoffeeType coffeeType);
  boolean turnOnOff();
  void loadCoffee();
  void loadWater();
  void emptyBorra();
}
