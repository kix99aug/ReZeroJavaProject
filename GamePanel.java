import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.ArrayList;
import java.util.Random;
import java.util.Comparator;

public class GamePanel extends AbstractPanel  implements KeyListener {
  MainFrame mainframe = null;
  PlaySounds soundofzombie;
  PlaySounds shootingsound;

  Image skyImage = new ImageIcon("./img/sky1.png").getImage();
  Image groundImage = new ImageIcon("./img/ground1.png").getImage();


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
  Obstacle obstacle[] = new Obstacle[5];
  GamePanel(MainFrame mf){
    
    soundofzombie = new PlaySounds("./music/soundofzombie.wav");
    shootingsound = new PlaySounds("./music/shootingsound.wav");

    this.mainframe = mf;
    this.setSize(this.mainframe.getSize());
    this.setLayout(null);
    character.start();
    // Monster = new Monster();
    int choose = new Random().nextInt(4);
    for(int i = 0; i < 5; i++){
      monster[i] = new Monster(this);
      obstacle[i] = new Obstacle(this,choose);
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
      g.drawImage(obstacle[i].img,(int)obstacle[i].x,(int)obstacle[i].y,-obstacle[i].img.getWidth(this),monster[i].img.getHeight(this),mainframe);
    }
    // g.drawImage(character.img,(int)character.x,(int)character.y,character.img.getWidth(this)*3,character.img.getHeight(this)*3,mainframe);
    for(int i = 0; i < 5; i++){
      g.drawImage(monster[i].img,(int)monster[i].x,(int)monster[i].y,-monster[i].img.getWidth(this),monster[i].img.getHeight(this),mainframe);
    }
    ArrayList<MapItem> items = new ArrayList<MapItem>();
    items.add(character);
    for(Obstacle i : obstacle){
      items.add(i);
    }
    for(Monster i : monster){
      items.add(i);
    }
    items.sort(new Comparator<MapItem>() {
      @Override
      public int compare(MapItem i1,MapItem i2){
        return (i1.getHitbox().y+i1.getHitbox().height)-(i2.getHitbox().y+i2.getHitbox().height);
      }
    });
    for(MapItem i : items){
      g.drawImage(i.img,
        (int) i.x + ((i.facing == -1) ? i.img.getWidth(this) * 3 : 0),
        (int) i.y,
        i.width ,
        i.height, mainframe);
        g.drawRect(i.getHitbox().x,i.getHitbox().y,i.getHitbox().width,i.getHitbox().height);
    }
    // g.drawImage(character.img,
    //     (int) character.x + ((character.facing == -1) ? character.img.getWidth(this) * 3 : 0),
    //     (int) character.y, character.img.getWidth(this) * 3 * character.facing,
    //     character.img.getHeight(this) * 3, mainframe);
    // g.drawRect(character.getHitbox().x,character.getHitbox().y,character.getHitbox().width,character.getHitbox().height);
  }
}
