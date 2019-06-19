import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class GamePanel extends AbstractPanel  implements KeyListener {
  MainFrame mainframe = null;
  PlaySounds soundofzombie;
  PlaySounds shootingsound;

  Image skyImage = new ImageIcon("./img/sky1.png").getImage();
  Image groundImage = new ImageIcon("./img/ground1.png").getImage();

  Image obstacle[] = {new ImageIcon("./img/MapSource/obstacle3.png").getImage(),
      new ImageIcon("./img/MapSource/obstacle4.png").getImage(),
      new ImageIcon("./img/MapSource/obstacle5.png").getImage(),
      new ImageIcon("./img/MapSource/obstacle6.png").getImage()};
  int bgx = 0, bgy = 0;

  public void keyPressed(KeyEvent e) {
    System.out.println(e.getKeyCode());
    switch(e.getKeyCode()){
      case 37:this.character.left=true;
      break;
      case 38:this.character.up=true;
      break;
      case 39:this.character.right=true;
      break;
      case 40:this.character.down=true;
      break;
    }
  }

  public void keyReleased(KeyEvent e) {
    System.out.println(e.getKeyCode());
    switch(e.getKeyCode()){
      case 37:this.character.left=false;
      break;
      case 38:this.character.up=false;
      break;
      case 39:this.character.right=false;
      break;
      case 40:this.character.down=false;
      break;
    }
  }

  public void keyTyped(KeyEvent e) {
  }


  Character character = new Character(this);
  Monster monster[] = new Monster[5];
  
  GamePanel(MainFrame mf){
    
    soundofzombie = new PlaySounds("./music/soundofzombie.wav");
    shootingsound = new PlaySounds("./music/shootingsound.wav");

    this.mainframe = mf;
    this.setSize(this.mainframe.getSize());
    this.setLayout(null);
    character.start();
    // Monster = new Monster();
    for(int i = 0; i < 5; i++){
      monster[i] = new Monster(this);
    }
    new Thread(){
  
		  public void run(){
			  while(true){
				  repaint();
          try {
            Thread.sleep(10);
          } catch (InterruptedException e) {
            e.printStackTrace();
          }
        }
      }
    }.start();
    this.addKeyListener(this);
    this.setFocusable(true);

  }

  public void actionPerformed(ActionEvent e) {

  }

  public void paint(Graphics g) {
    super.paint(g);
    for (int i = 0; i < 2560; i += 319) {
      g.drawImage(skyImage, i, 0, mainframe);
      g.drawImage(groundImage, i, 320, mainframe);
    }
    for (int i = 0; i < 5; i++) {
      g.drawImage(obstacle[this.mainframe.choose], this.mainframe.store_X[i],
          this.mainframe.store_Y[i] + i * 80 + 320 - 214, 175, 214, mainframe);
    }
    // g.drawImage(character.img,(int)character.x,(int)character.y,character.img.getWidth(this)*3,character.img.getHeight(this)*3,mainframe);
    for(int i = 0; i < 5; i++){
      g.drawImage(monster[i].img,(int)monster[i].x,(int)monster[i].y,-monster[i].img.getWidth(this),monster[i].img.getHeight(this),mainframe);
    }
    
    g.drawImage(character.img,
        (int) character.x + ((character.facing == -1) ? character.img.getWidth(this) * 3 : 0),
        (int) character.y, character.img.getWidth(this) * 3 * character.facing,
        character.img.getHeight(this) * 3, mainframe);
    g.drawRect(character.getHitbox().x,character.getHitbox().y,character.getHitbox().width,character.getHitbox().height);
  }
}
