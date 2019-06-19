import java.awt.*;
import java.awt.event.*;
import java.util.HashMap;
import javax.swing.*;
import javax.swing.event.*;
import java.io.*;
import java.io.IOException;
import java.util.Random;

public class MainFrame extends JFrame {
  HashMap<String,AbstractPanel> panels = new HashMap<String,AbstractPanel>();
  Image cursorImage = new ImageIcon("./img/cursor.png").getImage();
  Point hotspot = new Point(0, 0);
  String username;
  PlaySounds BGM;
   
  public int[] store_X = new int[8];
  public int[] store_Y = new int[8];
  public int choose ;
  MainFrame(){
    super("Little Adventure");
    this.setCursor(getToolkit().createCustomCursor(cursorImage, hotspot, "Cursor"));
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setBounds((getToolkit().getScreenSize().width-1280)/2,(getToolkit().getScreenSize().height-720)/2,1280, 720);
    this.setUndecorated(true);
    panels.put("inputname", new InputNamePanel(this));
    panels.put("menu", new MenuPanel(this));
    panels.put("bag", new BagPanel(this));
    positionXY();
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
      Random ran = new Random();
    this.choose = ran.nextInt(4);
    for(int i =0; i <8; i++){
      this.store_X[i] = ran.nextInt(1280);
      this.store_Y[i] = ran.nextInt(80);
      
    }
  }

  public void changeScene(String target){
    for(JPanel p : panels.values()){
      p.setVisible(false);
    }
    panels.get(target).setVisible(true);
    panels.get(target).requestFocus();
    //if(target=="menu") BGM._stop();
    if(target=="game") BGM.change("./music/gameoverBGM.wav");
  }
}
