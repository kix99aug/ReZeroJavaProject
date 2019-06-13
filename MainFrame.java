import java.awt.*;
import java.awt.event.*;
import java.util.HashSet;
import java.util.Set;
import javax.swing.*;
import javax.swing.event.*;

public class MainFrame extends JFrame {
  JPanel menu = null;
  
  Image cursorImage = new ImageIcon("./img/cursor.png").getImage();
  Point hotspot = new Point(0, 0);
  String cursorName = "Lightsaber Cursor";
  MainFrame(){
    super("Game");
    this.setCursor(getToolkit().createCustomCursor(cursorImage, hotspot, cursorName));
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setSize(1280, 720);
    menu = new MenuPanel(this);
    menu.setVisible(true);
    this.getContentPane().add(menu);
    this.setVisible(true);
  }
}
