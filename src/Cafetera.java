public class Cafetera {

  private int coffeeQuantity; // equals to milliliters of coffee

  public void coffeeBrewing(int water, int coffee ){
    this.coffeeQuantity = (water > 0 && coffee > 0 ) ?  water : 0;
  }

  public boolean giveMeACoffee(int quantity){
    if( thereIsStillCoffee( quantity ) ){
      this.coffeeQuantity -= quantity;
      return true;
    }
    return false;
  }

  public  boolean thereIsStillCoffee( int quantity ){
    return coffeeQuantity >= quantity ;
  }
}
