public enum CoffeeType {

  COFFEE(200, 20, 25);

  private final int water, coffee, borra;

  CoffeeType(int water, int coffe, int borra){
    this.water  = water;
    this.coffee = coffe;
    this.borra = borra;
  }

  public int[] getValues(){
    return new int[]{water, coffee, borra};
  }
}
