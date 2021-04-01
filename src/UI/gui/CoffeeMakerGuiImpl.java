package UI.gui;

import Cafetera.Cafetera;
import Events.EventTypes;
import UI.State;

import javax.swing.*;
import java.awt.*;

public class CoffeeMakerGuiImpl implements  CoffeeMakerGui{

  private JFrame frame;
  private final Container container;

  private StatusContainer statusContainer;
  private ActionsContainer actionsContainer;

  private final Cafetera coffeeMaker;

  public CoffeeMakerGuiImpl(Cafetera coffeeMaker){
    this.coffeeMaker = coffeeMaker;
    this.coffeeMaker.subscribe(this);
    this.container = new Container();
    initComponents();

  }
  private void initComponents(){
    this.frame = new JFrame("Cafetera");
    this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.frame.setSize(400,400);
    this.frame.setVisible( false );

    this.statusContainer = new StatusContainer();
    this.actionsContainer = new ActionsContainer(this.coffeeMaker);
    this.container.add(this.statusContainer, BorderLayout.CENTER);
    this.container.add(this.actionsContainer, BorderLayout.EAST);

//    this.frame.getContentPane().add(new StatusContainer() );
//    this.frame.getContentPane().add(new ActionsContainer());

    this.frame.add(container);
    this.frame.pack();
  }

  @Override
  public void show() {
    this.frame.setVisible(true);
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
    this.statusContainer.refresh();
    System.out.println( event.getMessage() );
  }

}
