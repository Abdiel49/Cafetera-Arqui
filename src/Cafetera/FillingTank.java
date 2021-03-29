package Cafetera;
// borra tank use this
public class FillingTank extends Tank{

  public FillingTank(int capacity){
    super(capacity);
  }

  public boolean canFillUp(int quantity){
    if(this.quantity + quantity <= capacity){
      this.quantity += quantity;
      return true;
    }
    return false;
  }

  public void drainTank(){
    this.quantity = 0;
  }
}
