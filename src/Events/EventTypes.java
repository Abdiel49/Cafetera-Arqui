package Events;

public enum EventTypes {

      TURN_ON("CAFETERA ENCENDIDA"),
      TURN_OFF("CAFETERA APAGADA"),
      BORRA_FILLED  ("DEPOSITO DE BORRA LLENO"),
      BORRA_EMPTIED ("DEPOSITO DE BORRA FUE VACIADO"),

      COFFEE_FILLED ("DEPOSITO DE CAFE LLENO"),
      WATER_FILLED  ("DEPOSITO DE AGUA LLENO"),
    //  COFFEE_ERROR  ("NO HAY CAFESITO"),
    //  WATER_ERROR   ("NO HAY AWITA");

      UN_SUCCESS("NO SE PUDO SERVIR EL CAFE"),
      SUCCESSFULLY  ("☕\tCAFE SERVIDO CON EXICTO!\t☕");


      private final String value;
          EventTypes(String value){
            this.value = value;
      }
      public String getMessage(){
          return this.value;
      }
}
