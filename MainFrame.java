import java.awt.*;
import java.awt.event.*;
import java.util.HashMap;
import javax.swing.*;
import javax.swing.event.*;
import java.io.*;
import java.io.IOException;
import java.util.Random;

public class MainFrame extends JFrame {
  HashMap<String, AbstractPanel> panels = new HashMap<String, AbstractPanel>();
  Image cursorImage = new ImageIcon("./img/cursor.png").getImage();
  Point hotspot = new Point(0, 0);
  String username;
  PlaySounds BGM;
  public int HP=100;
  public int Attack=20;
  public int defend=10;
  
  MainFrame(){
    super("Little Adventure");
    this.setCursor(getToolkit().createCustomCursor(cursorImage, hotspot, "Cursor"));
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setBounds((getToolkit().getScreenSize().width - 1280) / 2,
        (getToolkit().getScreenSize().height - 720) / 2, 1280, 720);
    this.setUndecorated(true);
    panels.put("inputname", new InputNamePanel(this));
    panels.put("menu", new MenuPanel(this));
    panels.put("bag", new BagPanel(this));

    panels.put("game", new GamePanel(this));
    for (JPanel p : panels.values()) {
      this.getContentPane().add(p);
    }
    changeScene("inputname");
    this.setVisible(true);
    BGM = new PlaySounds("./music/BGM.wav");
    BGM.run();
  }


  public void changeScene(String target) {
    for (JPanel p : panels.values()) {
      p.setVisible(false);
    }
    panels.get(target).setVisible(true);
    panels.get(target).requestFocus();
    // if(target=="menu") BGM._stop();
    if (target == "game") {
      GamePanel gp = ((GamePanel) panels.get(target));
      gp.newGame();
      gp.character.start();
      gp.character.breath();
      for (Monster m : gp.monster) {
        m.start();
        m.breath();
      }
      BGM.change("./music/鬼來電.wav", -20);
    }
    if (target == "bag") {
      BagPanel bp = ((BagPanel) panels.get(target));
      bp.bagcharacter.start();
    }
  }

}
