package UI.gui;

import javax.swing.JFrame;
import java.awt.Dimension;

public class MainFrame extends JFrame {
    public MainFrame(String title){
        super(title);
        initFrame();
    }

    private void initFrame(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setPreferredSize( new Dimension(250,250));
        this.setVisible( false );
    }
}
