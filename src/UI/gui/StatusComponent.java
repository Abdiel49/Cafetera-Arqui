package UI.gui;

import UI.State;

import javax.swing.*;
import java.awt.*;

public class StatusComponent extends JPanel {

  private final String title;
  private       State  state;
  private JLabel label;
  private JRadioButton radioButton;

  public StatusComponent(String title, State state){
    this.title = title;
    this.state = state;
    initComponent();
    loadContend();
    this.setVisible(true);
  }

  private void initComponent(){
    this.setLayout(new FlowLayout());
//    this.setPreferredSize( new Dimension());
    this.radioButton = new JRadioButton(title);
    this.radioButton.setSelected(true);
//    this.label = new JLabel(title);
    this.add(radioButton);
  }

  private void loadContend(){

    this.add(label);
  }

  public void updateStatus(){
//    this.label.setText(title + ": \t" + this.state.getState());
  }
}
