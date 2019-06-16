import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class GamePanel extends AbstractPanel {
  MainFrame mainframe = null;

  Image skyImage = new ImageIcon("./img/sky1.png").getImage(); 
  Image groundImage = new ImageIcon("./img/ground1.png").getImage(); 

  ImageIcon obstacle[] = {
    new ImageIcon(new ImageIcon("./img/MapSource/圖層7.png").getImage().getScaledInstance( 107,  85, Image.SCALE_DEFAULT)),
    new ImageIcon(new ImageIcon("./img/MapSource/圖層8.png").getImage().getScaledInstance( 107,  85, Image.SCALE_DEFAULT)),
    new ImageIcon(new ImageIcon("./img/MapSource/圖層9.png").getImage().getScaledInstance( 107,  85, Image.SCALE_DEFAULT)),
    new ImageIcon(new ImageIcon("./img/MapSource/圖層10.png").getImage().getScaledInstance( 107,  85, Image.SCALE_DEFAULT)),
    new ImageIcon(new ImageIcon("./img/MapSource/圖層11.png").getImage().getScaledInstance( 107,  85, Image.SCALE_DEFAULT)),
    new ImageIcon(new ImageIcon("./img/MapSource/圖層12.png").getImage().getScaledInstance( 107,  85, Image.SCALE_DEFAULT)),
  }; 
  int bgx = 0,bgy=0;

  GamePanel(MainFrame mf){
    this.mainframe = mf;
    this.setSize(this.mainframe.getSize());
    this.setLayout(null);
  }
  public void actionPerformed(ActionEvent e) {
    
  } 
  public void paint(Graphics g){
    super.paint(g);
    for(int i = 0;i<1280;i+=319){
      g.drawImage(skyImage, i, 0,mainframe);
      g.drawImage(groundImage, i, 320,mainframe);
    }
  }
}
