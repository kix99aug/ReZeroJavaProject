import java.awt.Image;
import java.awt.Rectangle;
import javax.swing.ImageIcon;

public abstract class MapItem extends Thread{
	public double x, y;
	public int width, height;
	public Image img;
	public int facing;
  public int state;
  public abstract Rectangle getHitbox();
}