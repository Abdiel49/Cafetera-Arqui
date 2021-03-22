import UI.Console;
import UI.CoffeMakerConsole;
import Cafetera.Cafetera;
import Cafetera.CafeteraImpl;

public class Main {
  public static void main(String[] args) {
    Cafetera coffeemaker = new CafeteraImpl();
    Console  console     = new CoffeMakerConsole(coffeemaker);
    console.start();
  }
}
