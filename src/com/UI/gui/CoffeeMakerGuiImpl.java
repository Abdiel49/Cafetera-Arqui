package com.UI.gui;

import com.Cafetera.Cafetera;
import com.Events.EventTypes;
import com.UI.State;

public class CoffeeMakerGuiImpl implements  CoffeeMakerGui{

    private final Cafetera coffeeMaker;
    private MainFrame mainFrame;
    private ActionsContainer actionsContainer;

    public CoffeeMakerGuiImpl(Cafetera coffeeMaker){
        this.coffeeMaker = coffeeMaker;
        this.coffeeMaker.subscribe(this);
        initComponents();
    }
    
    private void initComponents(){
        mainFrame = new MainFrame("Cafetera");
        actionsContainer = new ActionsContainer( coffeeMaker );
        mainFrame.add( actionsContainer );
        mainFrame.pack();
    }

    @Override
    public void show() {
        mainFrame.setVisible(true);
    }

    @Override
    public void onEventOccurs(EventTypes event) {
        switch (event){
            case BORRA_EMPTIED -> State.BORRA_FILLED.trueState();
            case BORRA_FILLED  -> State.BORRA_FILLED.falseState();
            case SUCCESSFULLY  -> State.SUCCESS.trueState();
            case UN_SUCCESS    -> State.SUCCESS.falseState();
            case TURN_ON       -> State.TURN_ON_OFF.trueState();
            case TURN_OFF      -> State.TURN_ON_OFF.falseState();
        }
        actionsContainer.updateData(event);
    }
}
