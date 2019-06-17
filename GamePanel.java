import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Random;

public class GamePanel extends AbstractPanel {

  MainFrame mainframe = null;
  Image skyImage = new ImageIcon("./img/sky1.png").getImage(); 
  Image groundImage = new ImageIcon("./img/ground1.png").getImage(); 

  Image obstacle[] = {
    new ImageIcon("./img/MapSource/obstacle2.png").getImage(),
    new ImageIcon("./img/MapSource/obstacle3.png").getImage(),
    new ImageIcon("./img/MapSource/obstacle4.png").getImage(),
    new ImageIcon("./img/MapSource/obstacle5.png").getImage(),
    new ImageIcon("./img/MapSource/obstacle6.png").getImage()
  }; 
  int bgx = 0,bgy=0;
  Random ran = new Random();
  GamePanel(MainFrame mf){
    this.mainframe = mf;
    this.setSize(this.mainframe.getSize());
    this.setLayout(null);
  }
  public void actionPerformed(ActionEvent e) {
    
  } 
  public void paint(Graphics g){
    super.paint(g);
    for(int i = 0;i<2560;i+=319){
      g.drawImage(skyImage, i, 0,mainframe);
      g.drawImage(groundImage, i, 320,mainframe);
    }
    for(int i = 0; i < 8;i++){
      g.drawImage(obstacle[ran.nextInt(5)], ran.nextInt(2560), ran.nextInt(50)+i*50+320-214,175,214,mainframe);
    }
  }
}
