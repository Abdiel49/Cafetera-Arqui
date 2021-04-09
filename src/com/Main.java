package com;

import com.Cafetera.Cafetera;
import com.Cafetera.CafeteraImpl;

import com.UI.console.CoffeeMakerConsole;
import com.UI.console.Console;
import com.UI.gui.CoffeeMakerGui;
import com.UI.gui.CoffeeMakerGuiImpl;

public class Main {
    public static void main(String[] args) {
        Cafetera coffeemaker = new CafeteraImpl();
        Console console     = new CoffeeMakerConsole(coffeemaker);
        console.start();
        CoffeeMakerGui gui = new CoffeeMakerGuiImpl( coffeemaker );
        gui.show();
    }
}
