package UI.gui;

import UI.State;

import javax.swing.*;
import java.awt.*;

public class StatusContainer extends JPanel {

  private StatusComponent coffeeMakerStatus;
  private StatusComponent coffeeStatus;
  private StatusComponent borraStatus;

  public StatusContainer(){
    this.setLayout( new FlowLayout());
//    this.setAlignmentX(Component.LEFT_ALIGNMENT);
    initComponents();
    this.setVisible(true);
  }

  private void initComponents(){
    this.coffeeMakerStatus = new StatusComponent("CAFETERA", State.TURN_ON_OFF);
    this.coffeeStatus      = new StatusComponent("CAFE", State.SUCCESS);
    this.borraStatus       = new StatusComponent("BORRA", State.BORRA_FILLED);

    this.add(coffeeMakerStatus);
    this.add(coffeeStatus);
    this.add(borraStatus);
  }

  private void updateData(){
//    c
  }

  public void refresh(){
    this.coffeeMakerStatus.updateStatus();
    this.coffeeStatus.updateStatus();
    this.borraStatus.updateStatus();
  }
}
