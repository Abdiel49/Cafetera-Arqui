package UI.gui;

import Cafetera.Cafetera;
import Enums.CoffeeType;
import UI.State;

import javax.swing.*;
import java.awt.*;

public class ActionsContainer extends JPanel {

  private JButton onOff;
  private JButton loadCoffee;
  private JButton loadWater;
  private JButton giveMeCoffee;
  private JButton emptyBorra;

  private Cafetera coffeemaker;
  private boolean switchOnOff;

  public  ActionsContainer(Cafetera coffeemaker){
    this.coffeemaker = coffeemaker;
    this.switchOnOff = false;
    this.setLayout( new FlowLayout());
    initComponent();
    addActions();
    this.setVisible(true);
  }

  private void initComponent(){
    onOff = new JButton("ON/OFF");
    loadCoffee = new JButton("Cargar Cafe");
    loadWater = new JButton("Cargar Agua");
    giveMeCoffee = new JButton("Cargar Un cafe");
    emptyBorra = new JButton("Baciar Borra");

    this.add(onOff);
    this.add(loadWater);
    this.add(loadCoffee);
    this.add(giveMeCoffee);
    this.add(emptyBorra);
  }

  private void addActions(){
    onOff.addActionListener     (e -> switchOnOff());
    loadCoffee.addActionListener(e -> loadCoffee());
    loadWater.addActionListener (e -> loadWater());
    giveMeCoffee.addActionListener(e -> giveMeCoffee());
    emptyBorra.addActionListener(e -> emptyBorra());
  }

  private void switchOnOff(){
    this.switchOnOff = coffeemaker.turnOnOff();
    State.TURN_ON_OFF.switchState();
  }

  private void loadCoffee(){
      coffeemaker.loadCoffee();
  }

  private void loadWater(){
    coffeemaker.loadWater();
  }

  private void giveMeCoffee(){
    if(switchOnOff){
      coffeemaker.giveACoffee(CoffeeType.COFFEE);
    }
  }

  private void emptyBorra(){
    if(switchOnOff){
      coffeemaker.emptyBorra();
    }
  }
}
