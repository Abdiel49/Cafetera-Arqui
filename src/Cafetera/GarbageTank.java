package Cafetera;
// borra tank use this
public class GarbageTank extends Tank{

  public GarbageTank(int capacity){
    super(capacity);
  }

  public boolean canFillUp(int quantity){
    return this.quantity + quantity <= capacity;
  }

  public void fillUp(int quantity){
    if( canFillUp(quantity)){
      this.quantity += quantity;
    }
  }

  public void drainTank(){
    this.quantity = 0;
  }
}
