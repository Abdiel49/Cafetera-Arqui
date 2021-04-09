package com.UI.gui;

import javax.swing.JPanel;
import java.awt.GridLayout;

public class Container extends JPanel {

    public Container(){
        int ROWS = 5,
            COLS = 1,
            BORDER = 5;
        this.setVisible(true);
        this.setLayout( new GridLayout(ROWS, COLS, BORDER, BORDER));
    }
}
