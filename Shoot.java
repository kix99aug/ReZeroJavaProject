import java.awt.Image;
import java.awt.Rectangle;
import java.util.Random;
import javax.swing.ImageIcon;


public class Shoot extends MapItem {

  Image arrowImages[] = {new ImageIcon("./img/diamondarrow.png").getImage(),
      new ImageIcon("./img/ironarrow.png").getImage(),
      new ImageIcon("./img/woodarrow.png").getImage()};
  public double x;
  public double y;
  public int choose;
  public Image img;
  public GamePanel gp;
  // public double x = 100, y = 500;
  public int width, height;
  public boolean left = false, right = false, down = false, up = false;

  public int facing = 1;

  public Shoot(GamePanel gp) {
    this.gp = gp;
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
