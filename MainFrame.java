import java.awt.*;
import java.util.HashMap;
import javax.swing.*;
import javax.swing.event.*;
import java.io.*;
import java.io.IOException;

public class MainFrame extends JFrame {
  HashMap<String,JPanel> panels = new HashMap<String,JPanel>();
  Image cursorImage = new ImageIcon("./img/cursor.png").getImage();
  Point hotspot = new Point(0, 0);
  String username;
  Thread P;
  MainFrame(){
    //File BGM = new File("");
    super("Game");
    

    this.setCursor(getToolkit().createCustomCursor(cursorImage, hotspot, "Cursor"));
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setSize(1280, 720);
    this.setUndecorated(true);
    panels.put("inputname", new InputNamePanel(this));
    panels.put("menu", new MenuPanel(this));
    panels.put("bag", new BagPanel(this));
    panels.put("game", new GamePanel(this));
    for(JPanel p : panels.values()){
      this.getContentPane().add(p);
    }
    changeScene("inputname");
    this.setVisible(true);
    P = new PlaySounds("./music/BGM.wav");
    P.run(); 
  }
  public void changeScene(String target){
    for(JPanel p : panels.values()){
      p.setVisible(false);
    }
    panels.get(target).setVisible(true);
  }
}
