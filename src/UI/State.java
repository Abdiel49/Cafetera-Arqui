package UI;

public enum State {
  TURN_ON_OFF ("🔴"),
  WATER       ("🔴"),
  COFFEE      ("🔴"),
  BORRA       ("🔘");

  private final String BLUE = "🔘", RED = "🔴"; // GREEN = "🟢";
  private String value;

  State(String state){
    this.value = state;
  }
  public String getState(){
    return this.value;
  }
  public void red(){
    this.value = RED;
  }
  public void blue(){
    this.value = BLUE;
  }
  public void switchState(){
    this.value = this.value.equals(BLUE) ? RED : BLUE;
  }

}
