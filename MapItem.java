import java.awt.Image;
import java.awt.Rectangle;
import javax.swing.ImageIcon;

public abstract class MapItem extends Thread{
  public abstract double getX();
  public abstract double getY();
  public abstract int getWidth();
  public abstract int getHeight();
	public abstract int getFacing();
  public abstract int _getState();
  public abstract Image getImage();
  public abstract Rectangle getHitbox();
}