package com.UI.gui;

import javax.swing.JButton;
import java.util.Timer;
import java.util.TimerTask;

public class ActionStatusButton extends JButton {

    private Colors colorState;
    private final boolean timeOut;

    public ActionStatusButton(String title, boolean timeOut){
        super(title);
        this.timeOut = timeOut;
        this.setFocusable(false);
        colorState = Colors.INACTIVE;
        changeBrackground();
    }

    public void changeColorState(Colors colorState){
        this.colorState = colorState;
        changeBrackground();
    }

    private void changeBrackground(){
        this.setBackground( colorState.getColor() );
//         setTimeOut
        if(timeOut){
            Timer timer = new Timer();
            TimerTask task = new TimerTask() {
                @Override
                public void run() {
                    colorState = Colors.INACTIVE;
                    setBackground( colorState.getColor() );
                }
            };
            timer.schedule( task, 1400);
        }
    }




}
