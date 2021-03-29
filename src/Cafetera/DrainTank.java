package Cafetera;
// the coffee tank and water tank use this
public class DrainTank extends Tank{

  public DrainTank(int capacity){
    super(capacity);
  }

  public boolean canDrain(int quantity){
    if(this.quantity - quantity >= 0){
      this.quantity -= quantity;
      return true;
    }
    return false;
  }

  public void fillTank(){
    this.quantity = this.capacity;
  }
}
