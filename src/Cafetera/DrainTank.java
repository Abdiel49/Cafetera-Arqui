package Cafetera;
// the coffee tank and water tank use this
public class DrainTank extends Tank{

  public DrainTank(int capacity){
    super(capacity);
  }

  public boolean canDrain(int quantity){
    return this.quantity - quantity >= 0;
  }

  public void drain(int quantity){
    if(canDrain(quantity)){
      this.quantity -= quantity;
    }
  }

  public void fillTank(){
    this.quantity = this.capacity;
  }
}
