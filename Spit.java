import java.awt.Image;
import java.awt.Rectangle;
import java.util.Random;
import javax.swing.ImageIcon;


public class Spit extends MapItem {

 
  public double x;
  public double y;
  public Image img =new ImageIcon("./img/Monster/spit.png").getImage();
  public GamePanel gp;
  public int width, height;
  public boolean left = false, right = false, down = false, up = false;

  public int facing = 1;

  public Spit(GamePanel gp,double x,double y,int face) {
    this.gp = gp;
    this.x = x;
    this.y = y;
    this.width = 10;
	this.height = 10;
  this.facing = face;
  this.start();
  }

  public void run() {
    while (true) {
      if (this.gp.gameover) return;
      this.x += this.facing;
      for (Obstacle o : gp.obstacle) {
		if (this.getHitbox().intersects(o.getHitbox())) {
			gp.spit.remove(this);
			return;
		}
      }
     
        if (this.getHitbox().intersects(this.gp.character.getHitbox())) {
          gp.mainframe.HP -= (20-gp.mainframe.defend); 
          if(gp.mainframe.HP <= 0){
            
          }
          gp.spit.remove(this);
          return;
        }
      
      try {
        this.sleep(5);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
  }

  public double getX() {
    return x;
  }

  public double getY() {
    return y;
  }

  public int getWidth() {
    return width;
  }

  public int getHeight() {
    return height;
  }

  public int getFacing() {
    return facing;
  }

  public int _getState() {
    return 1;
  }

  public Image getImage() {
    return img;
  }


  public Rectangle getHitbox() {
    return new Rectangle((int) this.x, (int) this.y, 10, 10);
  }

}
