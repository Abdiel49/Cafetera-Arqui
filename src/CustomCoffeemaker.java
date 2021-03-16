import Exceptions.BorraException;
import Exceptions.CoffeException;
import Exceptions.WaterException;

public class CustomCoffeemaker extends Cafetera{

  private final int MAX_WATER   = 1500,
                    MAX_COFFEE  = 200,
                    MAX_BORRA   = 300;
  private int WATER, COFFEE, BORRA=0;

  public CustomCoffeemaker(){

  }

  void loadWater(){
    this.WATER = MAX_WATER;
  }

  void loadCoffee(){
    this.COFFEE = MAX_COFFEE;
  }

  boolean giveACoffee (CoffeeType coffeeType) {
    int[] coffeeValues = coffeeType.getValues();
    if( canCoffeeBePrepared( coffeeValues ) ){
      WATER   -= coffeeValues[0];
      COFFEE  -= coffeeValues[1];
      BORRA   += coffeeValues[2];
      return true;
    }
    return false;
  }

  private boolean canCoffeeBePrepared(int[] cValues){
    boolean resp = false;
    try{
      resp =  checkWaterTank(   cValues[0] ) &&
              checkCoffeeTank(  cValues[1] ) &&
              checkBorraTank(   cValues[2] );
    }catch (WaterException we){

    }catch (CoffeException ce){

    }catch (BorraException be){

    }
    return resp;
  }

  private boolean checkWaterTank(int waterValue)  throws WaterException{
    if(WATER >= waterValue)
      return true;
    else
      throw new WaterException("");
  }

  private boolean checkCoffeeTank(int coffeValue) throws CoffeException{
    if(COFFEE >= coffeValue)
      return true;
    else
      throw new CoffeException("");
  }

  private boolean checkBorraTank(int borraValue)  throws BorraException{
    if( (BORRA+borraValue) <= MAX_BORRA) {
      return true;
    } else
      throw new BorraException("cc");
  }

}
