import java.awt.*;
import javax.swing.*;

public class MainFrame extends JFrame {
   JPanel menu = null;
   JPanel bag = null;
  MainFrame(){
    super("Game");
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setSize(1280, 720);
    menu = new BagPanel(this);
    //bag= new BagPanel(this);
    menu.setVisible(true);
    //this.getContentPane().add(bag);
    this.getContentPane().add(menu);

    this.setVisible(true);
  }
}
