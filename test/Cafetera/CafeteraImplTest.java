package Cafetera;

import Enums.CoffeeType;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CafeteraImplTest {

  @Test void prepareAndObtainCoffee() {
    Cafetera coffeemaker = new CafeteraImpl();
    coffeemaker.loadWater();
    coffeemaker.loadCoffee();
    assertTrue( coffeemaker.giveACoffee( CoffeeType.COFFEE ) );
  }

  @Test void shouldNotGiveCoffeeWithoutWater() {
    Cafetera coffeemaker = new CafeteraImpl();
    coffeemaker.loadCoffee();
    assertFalse( coffeemaker.giveACoffee( CoffeeType.COFFEE ) );
  }

  @Test void shouldNotGiveCoffeeWithoutCoffee() {
    Cafetera coffeemaker = new CafeteraImpl();
    coffeemaker.loadWater();
    assertFalse( coffeemaker.giveACoffee( CoffeeType.COFFEE ) );
  }

  @Test void shouldNotGiveMoreThanSevenCoffees(){
    Cafetera coffeemaker = new CafeteraImpl();
    coffeemaker.loadWater();
    coffeemaker.loadCoffee();
    coffeemaker.giveACoffee( CoffeeType.COFFEE );
    coffeemaker.giveACoffee( CoffeeType.COFFEE );
    coffeemaker.giveACoffee( CoffeeType.COFFEE );
    coffeemaker.giveACoffee( CoffeeType.COFFEE );
    coffeemaker.giveACoffee( CoffeeType.COFFEE );
    coffeemaker.giveACoffee( CoffeeType.COFFEE );
    coffeemaker.giveACoffee( CoffeeType.COFFEE );
    assertFalse( coffeemaker.giveACoffee( CoffeeType.COFFEE ) );
  }
}