package Events;

public enum EventTypes {

  BORRA_ERROR   ("EL DEPOSITO DE BORRA LLENO"),
  COFFEE_FILLED ("DEPOSITO DE CAFE LLENO"),
  COFFEE_ERROR  ("NO HAY CAFESITO"),
  SUCCESSFULLY  ("☕\tCAFE SERVIDO CON EXICTO!\t☕"),
  WATER_ERROR   ("NO HAY AWITA"),
  WATER_FILLED  ("DEPOSITO DE AGUA LLENO"),
  TURN_OFF      (""),
  TURN_ON       ("");

  private final String value;
  EventTypes(String value){
    this.value = value;
  }
  public String getMessage(){
    return this.value;
  }
}
