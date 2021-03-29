package UI.console;

import Cafetera.Cafetera;
import Enums.CoffeeType;
import Events.EventTypes;
import UI.State;

import java.util.Scanner;

public class CoffeMakerConsole implements Console {

  private final Cafetera coffemaker;
  private boolean start, turnOn;
  private String[] menuOptions;
  
  public CoffeMakerConsole(Cafetera coffemaker){
    this.coffemaker = coffemaker;
    this.turnOn     = false;
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
    println("\tCAFETERA\t"+ State.TURN_ON_OFF.getState());
    displayDetails();
    for(String menuOption : menuOptions){
      println( menuOption );
    }
    println("Ingrese el 'Numero' de la opcion para realizar una accion");
  }

  private void loadMenuOptions(){
    this.menuOptions = new String[]{
        " 0. " + menuOptionOnOff(),
        " 1. Cargar agua",
        " 2. Cargar cafe",
        " 3. Llenar una taza (200 ml)",
        " 4. Salir"
    };
  }

  private void displayDetails(){
    println("######################################");
    println(  "\tAgua "  + State.WATER .getState() +
              "\tCafe "  + State.COFFEE.getState() +
              "\tBorra " + State.BORRA .getState() );
    println("######################################");
  }

  private String menuOptionOnOff(){
    return this.turnOn ? "Apagar" : "Encender";
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
      case 4 -> stop();
    }
  }

  private void switchOnOff(){
    this.turnOn = !this.turnOn;
    State.TURN_ON_OFF.switchState();
  }

  private void stop(){
    println("Gracias vuelva prontos");
    start = false;
  }

  private void loadWater(){
    coffemaker.loadWater();
  }

  private void loadCoffee(){
    coffemaker.loadCoffee();
  }

  private void giveACoffee(){
    if (turnOn) {
      coffemaker.giveACoffee(CoffeeType.COFFEE);
    }
  }

  @Override
  public void onEventOccurs(EventTypes event) {
    switch (event){
      case WATER_FILLED   -> State.WATER  .blue();
      case WATER_ERROR    -> State.WATER  .red();
      case COFFEE_FILLED  -> State.COFFEE .blue();
      case COFFEE_ERROR   -> State.COFFEE .red();
      case BORRA_ERROR    -> State.BORRA  .red();
    }
    println( event.getMessage() );
  }

  private void println(String cad){
    System.out.println( cad );
  }
}
