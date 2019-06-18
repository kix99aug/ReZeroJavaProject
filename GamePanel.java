import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class GamePanel extends AbstractPanel {
  MainFrame mainframe = null;

  Image skyImage = new ImageIcon("./img/sky1.png").getImage(); 
  Image groundImage = new ImageIcon("./img/ground1.png").getImage(); 

  Image obstacle[] = {
    new ImageIcon("./img/MapSource/obstacle3.png").getImage(),
    new ImageIcon("./img/MapSource/obstacle4.png").getImage(),
    new ImageIcon("./img/MapSource/obstacle5.png").getImage(),
    new ImageIcon("./img/MapSource/obstacle6.png").getImage()
  }; 
  int bgx = 0,bgy=0;

  Character character = new Character(this);
  Monster monster = new Monster(this);
  
  GamePanel(MainFrame mf){
    this.mainframe = mf;
    this.setSize(this.mainframe.getSize());
    this.setLayout(null);
    // Monster = new Monster();
    new Thread(){
		  public void run(){
        
			  while(true){
				  repaint();
				  try {
				  	Thread.sleep(10);
          }
          catch (InterruptedException e) {
			  		e.printStackTrace();
			  	}
			  } 
		  }
    }.start();
    
}
  public void actionPerformed(ActionEvent e) {
    
  }
  public void paint(Graphics g){
    super.paint(g);
    for(int i = 0;i<2560;i+=319){
      g.drawImage(skyImage, i, 0,mainframe);
      g.drawImage(groundImage, i, 320,mainframe);
    }
    for(int i = 0; i < 5;i++){
      g.drawImage(obstacle[this.mainframe.choose], this.mainframe.store_X[i], this.mainframe.store_Y[i]+i*80+320-214,175,214,mainframe);
    }
    g.drawImage(character.img,(int)character.x,(int)character.y,character.img.getWidth(this)*3,character.img.getHeight(this)*3,mainframe);
    g.drawImage(monster.img,(int)monster.x,(int)monster.y,monster.img.getWidth(this),monster.img.getHeight(this),mainframe);
    // g.drawImage(Monster.batimg[0], dx1, dy1, dx2);
  }
}
