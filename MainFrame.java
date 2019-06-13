import java.awt.*;
import javax.swing.*;

public class MainFrame extends JFrame {
  JPanel menu = null;
  MainFrame(){
    super("Game");
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setSize(1280, 720);
    menu = new MenuPanel(this);
    menu.setVisible(true);
    this.getContentPane().add(menu);
    this.setVisible(true);
  }
}
