package Enums;

public enum CoffeeMakers {

  COMMON(1500, 200, 300);

  private final int WATTER_CAPACITY,
                    COFFEE_CAPACITY,
                    BORRA_CAPACITY;

  CoffeeMakers(int water, int coffe, int borra) {
    this.WATTER_CAPACITY = water;
    this.COFFEE_CAPACITY = coffe;
    this.BORRA_CAPACITY  = borra;
  }

  public int WATTER_CAPACITY() {
    return WATTER_CAPACITY;
  }

  public int COFFEE_CAPACITY() {
    return COFFEE_CAPACITY;
  }

  public int BORRA_CAPACITY() {
    return BORRA_CAPACITY;
  }
}
