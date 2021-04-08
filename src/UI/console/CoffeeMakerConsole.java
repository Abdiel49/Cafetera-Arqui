package UI.console;

import Cafetera.Cafetera;
import Enums.CoffeeType;
import Events.EventTypes;
import UI.State;

import java.util.Scanner;

public class CoffeeMakerConsole implements Console {

    private final Cafetera coffemaker;
    private boolean start, turnOn_Off;
    private String[] menuOptions;

    public CoffeeMakerConsole(Cafetera coffemaker){
        this.coffemaker = coffemaker;
        this.turnOn_Off     = false;
        this.coffemaker.subscribe(this);
    }

    @Override public void start(){
        this.start = true;
        while ( start ){
            displayMenu();
            int input = obtainValidInput();
            takeAction( input );
        }
    }

    private void displayMenu(){
        loadMenuOptions();
        println("\tCAFETERA\t"+ getSignal(State.TURN_ON_OFF));
        displayDetails();
        for (int i = 0; i < menuOptions.length; i++) {
            println( i + "\t" + menuOptions[i] );
        }

        println("Ingrese el 'Numero' de la opcion para realizar una accion");
    }

    private void loadMenuOptions(){
        this.menuOptions = new String[]{
            menuOptionOnOff(),
            "Cargar agua",
            "Cargar cafe",
            "Llenar una taza (200 ml)",
            "Vaciar el recipiente de Borra",
            "Salir"
        };
    }

    private String menuOptionOnOff(){
        return this.turnOn_Off ? "Apagar" : "Encender";
    }

    private void displayDetails(){
        println("######################################");
        println(  //"\tAgua "  + State.WATER .getState() +
            "\tCafe Servido:\t"  + getSignal(State.SUCCESS) +
                "\tBorra " + getSignal(State.BORRA_FILLED)  );
        println("######################################");
    }

    private int obtainValidInput(){
        while ( true ){
            int input = readInt();
            if( validateInput( input ))
                return input;
            else {
                println("Ingrese una opcion valida");
            }
        }
    }

    private int readInt(){
        Scanner in = new Scanner(System.in);
        return in.nextInt();
    }

    private boolean validateInput( int input ){
        return (input >= 0) && (input < menuOptions.length);
    }

    private void takeAction( int action ){
        switch (action){
            case 0 -> switchOnOff();
            case 1 -> loadWater();
            case 2 -> loadCoffee();
            case 3 -> giveACoffee();
            case 4 -> emptyBorra();
            case 5 -> stop();
        }
    }

    private void switchOnOff(){
        this.turnOn_Off = coffemaker.turnOnOff();
        State.TURN_ON_OFF.switchState();
    }

    private void stop(){
        start = false;
    }

    private void loadWater(){
        coffemaker.loadWater();
    }

    private void loadCoffee(){
        coffemaker.loadCoffee();
    }

    private void giveACoffee(){
        if (turnOn_Off) {
            coffemaker.giveACoffee(CoffeeType.COFFEE);
        }
    }

    private void emptyBorra(){
        coffemaker.emptyBorra();
    }

    @Override
    public void onEventOccurs(EventTypes event) {
        switch (event){
            case BORRA_EMPTIED -> State.BORRA_FILLED  .falseState();
            case BORRA_FILLED  -> State.BORRA_FILLED  .trueState();
            case SUCCESSFULLY -> State.SUCCESS .trueState();
            case UN_SUCCESS -> State.SUCCESS.falseState();
        }
        println( event.getMessage() );
    }

    private void println(String cad){
        System.out.println( cad );
    }

    private String getSignal(State state){
        String GREEN = "🟢", RED = "🔴" ;
        return state.getState() ? GREEN : RED;
    }
}
