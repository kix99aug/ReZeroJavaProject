import java.awt.*;
import java.util.HashMap;
import javax.swing.*;
import javax.swing.event.*;
import java.io.*;
import java.io.IOException;
import java.util.Random;

public class MainFrame extends JFrame {
  HashMap<String,JPanel> panels = new HashMap<String,JPanel>();
  Image cursorImage = new ImageIcon("./img/cursor.png").getImage();
  Point hotspot = new Point(0, 0);
  String username;
  PlaySounds BGM;
   
  public int[] store_X;
  public int[] store_Y;
  public int[] choose;
  MainFrame(){
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
    BGM = new PlaySounds("./music/BGM.wav");
    BGM.run();
  }
  public void positionXY(){
    for(int i =0; i <8; i++){
      Random ran = new Random();
      this.store_X[i] = ran.nextInt(2560);
      this.store_Y[i] = ran.nextInt(50);
      this.choose[i] = ran.nextInt(5);
    }
  }
  public void changeScene(String target){
    for(JPanel p : panels.values()){
      p.setVisible(false);
    }
    panels.get(target).setVisible(true);
    //if(target=="menu") BGM._stop();
    if(target=="game") BGM.change("./music/gameoverBGM.wav");
  }
}
