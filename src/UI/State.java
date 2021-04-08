package UI;

public enum State {
    BORRA_FILLED(false),
    SUCCESS     (false),
    WATER       (false),
    COFFEE      (false),
    TURN_ON_OFF (false);

    private boolean state;

    State(boolean state){
        this.state = state;
    }
    public boolean getState(){
        return state;
    }
    public void falseState(){
        this.state = false;
    }

    public void trueState(){
        this.state = true;
    }

    public void switchState(){
        state = !state;
    }


}
