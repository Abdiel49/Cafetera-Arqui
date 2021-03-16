public class Main {
  public static void main(String[] args) {
    CustomCoffeemaker coffeemaker = new CustomCoffeemaker();
    CoffeMakerConsole console     = new CoffeMakerConsole(coffeemaker);
    console.start();
  }
}
