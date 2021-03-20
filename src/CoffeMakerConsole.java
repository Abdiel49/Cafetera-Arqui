import java.util.Scanner;

public class CoffeMakerConsole {

  private final CustomCoffeemaker coffemaker;
  private boolean start, turnOn;
  private String[] menuOptions;
  
  CoffeMakerConsole( CustomCoffeemaker coffemaker ){
    this.coffemaker = coffemaker;
    this.turnOn     = false;
  }

  public void start(){
    this.start = true;
    while ( start ){
      showMenu();
      int input = obtainValidInput();
      takeAction( input );
    }
  }
  
  private void showMenu(){
    loadMenuOptions();
    println("\t***\tCAFETERA\t***");
    for(String menuOption : menuOptions){
      println( menuOption );
    }
    println("ingrese el numero de la opcion para realizar una accion");
  }

  private void loadMenuOptions(){
    this.menuOptions = new String[]{
        " 0. " + menuOptionOnOff(),
        " 1. Cargar agua",
        " 2. Cargar cafe",
        " 3. Llenar una taza (200 ml) "
    };
  }

  private String menuOptionOnOff(){
    return this.turnOn ? "Apagar" : "Encender";
  }

//  private void showDetails(){  } need getters

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
//      case 4 -> stop();
    }
  }

  private void switchOnOff(){
    this.turnOn = !this.turnOn;
  }

//  private void stop(){
//    println("Gracias vuelva prontos");
//    start = false;
//  }

  private void loadWater(){
    coffemaker.loadWater();
    println("Recipiente de: Agua, lleno");
  }

  private void loadCoffee(){
    coffemaker.loadCoffee();
    println("Recipiente de: Cafe, lleno");
  }

  private void giveACoffee(){
    if (turnOn && coffemaker.giveACoffee(CoffeeType.COFFEE)) {
      println("Disfrute su Cafe!");
    } else {
      println("En este momento no es posible, " +
              "asegurece de cargar los recipientes");
    }
  }

  private void println(String cad){
    System.out.println( cad );
  }
}
