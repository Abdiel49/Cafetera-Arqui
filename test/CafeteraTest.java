import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CafeteraTest {
  
  @Test public void prepareAndObtainCoffee(){
    Cafetera coffeemaker = new Cafetera();
    int coffee = 10, water = 350;
    coffeemaker.coffeeBrewing(water,coffee);
    assertTrue( coffeemaker.giveMeACoffee(350) );
  }

  @Test public void shouldNotGetACoffee(){
    Cafetera coffeemaker = new Cafetera();
    assertFalse( coffeemaker.giveMeACoffee(250) );
  }

  @Test public void shouldGetThreeCoffee(){
    Cafetera coffeemaker = new Cafetera();
    int coffee = 24, water = 760, coffeeQuantity = 250;
    coffeemaker.coffeeBrewing(water,coffee);
    coffeemaker.giveMeACoffee(coffeeQuantity);
    coffeemaker.giveMeACoffee(coffeeQuantity);
    coffeemaker.giveMeACoffee(coffeeQuantity);
    assertFalse( coffeemaker.giveMeACoffee(coffeeQuantity) );
  }

  @Test public void noCoffeeCupWithoutWater(){
    Cafetera coffeemaker = new Cafetera();
    int coffee = 18, water = 0;
    coffeemaker.coffeeBrewing(water,coffee);
    assertFalse(coffeemaker.giveMeACoffee(250));
  }

  @Test public void noCoffeeCupWithoutCoffee(){
    Cafetera coffeemaker = new Cafetera();
    int coffee = 0, water = 300;
    coffeemaker.coffeeBrewing(water,coffee);
    assertFalse(coffeemaker.giveMeACoffee(250));
  }

}