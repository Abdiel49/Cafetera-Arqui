import Cafetera.Cafetera;
import Cafetera.CafeteraImpl;
import UI.console.Console;
import UI.console.CoffeeMakerConsole;
import UI.gui.CoffeeMakerGui;
import UI.gui.CoffeeMakerGuiImpl;

public class Main {
    public static void main(String[] args) {
        Cafetera coffeemaker = new CafeteraImpl();
        Console  console     = new CoffeeMakerConsole(coffeemaker);
        console.start();
        CoffeeMakerGui gui = new CoffeeMakerGuiImpl( coffeemaker );
        gui.show();
    }
}
