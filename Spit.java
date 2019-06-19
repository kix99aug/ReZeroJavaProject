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

  public Spit(GamePanel gp,double x,double y) {
    this.gp = gp;
    this.x = x;
    this.y = y;
    this.width = 30;
    this.height = 6;
  }

  public boolean hit() {
    Rectangle myrect = new Rectangle((int) this.x, (int) this.y, this.width, this.height);
    Rectangle rect = null;
    return false;
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
    return new Rectangle((int) this.x + 45, (int) this.y + this.height - 36, 15 * 3, 12 * 3);
  }

}
