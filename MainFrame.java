import java.awt.*;
import java.util.HashMap;
import javax.swing.*;
import javax.swing.event.*;

public class MainFrame extends JFrame {
  HashMap<String,JPanel> panels = new HashMap<String,JPanel>();
  Image cursorImage = new ImageIcon("./img/cursor.png").getImage();
  Point hotspot = new Point(0, 0);

  MainFrame(){
    super("Game");
    this.setCursor(getToolkit().createCustomCursor(cursorImage, hotspot, "Cursor"));
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setSize(1280, 720);
    panels.put("inputname", new InputNamePanel(this));
    panels.put("menu", new MenuPanel(this));
    panels.put("bag", new BagPanel(this));
    panels.get("inputname").setVisible(false);
    panels.get("menu").setVisible(true);
    panels.get("bag").setVisible(false);
    
    this.getContentPane().add(panels.get("inputname"));
    this.getContentPane().add(panels.get("menu"));
    this.getContentPane().add(panels.get("bag"));
    for(JPanel p : panels.values()){
      this.getContentPane().add(p);
    }
    //changeScene("inputname");
    this.setVisible(true);
  }
  public void changeScene(String target){
    for(JPanel p : panels.values()){
      p.setVisible(false);
    }
    panels.get(target).setVisible(true);
  }
}
