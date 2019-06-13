import java.awt.*;
import java.util.HashMap;
import javax.swing.*;

public class MainFrame extends JFrame {
  HashMap<String,JPanel> panels = new HashMap<String,JPanel>();
  MainFrame(){
    super("Game");
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setSize(1280, 720);
    panels.put("menu", new MenuPanel(this));
    panels.get("menu").setVisible(true);
    this.getContentPane().add(panels.get("menu"));
    this.setVisible(true);
  }
}
