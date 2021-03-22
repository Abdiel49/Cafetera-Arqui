package Events;

public enum EventTypes {
  SUCCESSFULLY  ("☕\tCAFE SERVIDO CON EXICTO!\t☕"),
  WATER_ERROR   ("NO HAY AWITA"),
  COFFEE_ERROR  ("NO HAY CAFESITO"),
  BORRA_ERROR   ("EL DEPOSITO DE BORRA LLENO"),
  WATER_FILLED  ("DEPOSITO DE AGUA LLENO"),
  COFFEE_FILLED ("DEPOSITO DE CAFE LLENO");

  private final String value;
  EventTypes(String value){
    this.value = value;
  }
  public String getMessage(){
    return this.value;
  }
}
