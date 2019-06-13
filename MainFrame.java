import java.awt.*;
import java.util.HashMap;
import javax.swing.*;
import javax.swing.event.*;

public class MainFrame extends JFrame {
  HashMap<String,JPanel> panels = new HashMap<String,JPanel>();
  Image cursorImage = new ImageIcon("./img/cursor.png").getImage();
  Point hotspot = new Point(0, 0);
  String cursorName = "Lightsaber Cursor";
  MainFrame(){
    super("Game");
    this.setCursor(getToolkit().createCustomCursor(cursorImage, hotspot, cursorName));
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setSize(1280, 720);
    panels.put("menu", new MenuPanel(this));
    panels.get("menu").setVisible(true);
    this.getContentPane().add(panels.get("menu"));
    this.setVisible(true);
  }
}
