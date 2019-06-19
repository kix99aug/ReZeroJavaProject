import java.awt.Image;
import java.awt.Rectangle;
import java.util.Random;
import javax.swing.ImageIcon;


public class Obstacle extends MapItem {
    
    Image obstacleimg[] = {new ImageIcon("./img/MapSource/obstacle3.png").getImage(),
        new ImageIcon("./img/MapSource/obstacle4.png").getImage(),
        new ImageIcon("./img/MapSource/obstacle5.png").getImage(),
        new ImageIcon("./img/MapSource/obstacle6.png").getImage()};
    public double x;
    public double y;
    public int choose ;
    public Image img ;
	public GamePanel gp;
	// public double x = 100, y = 500;
	public int width , height;
    public boolean left = false, right = false, down = false, up = false;
    
    public int facing = 1;
	
	public Obstacle(GamePanel gp,int type) {
		this.gp = gp;
        Random ran = new Random();
        
        this.img = obstacleimg[type];
        this.width = this.img.getWidth(gp)*2;
        this.height = this.img.getHeight(gp)*2;
        this.x = (double)ran.nextInt(1280);
        this.y = (double)ran.nextInt(400)+320-height;
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

   
    public Rectangle getHitbox(){
		return new Rectangle((int) this.x + 16*3, (int) this.y + 24*3, 17*3, 12*3);
    }
    
}
