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
	public int width = 66*3 , height = 128*3;
    public boolean left = false, right = false, down = false, up = false;
    
    public int facing = 1;
	
	public Obstacle(GamePanel gp,int type) {
		this.gp = gp;
        Random ran = new Random();
        this.x = (double)ran.nextInt(1280);
        this.y = (double)ran.nextInt(400)+320-50*3;
        this.img = obstacleimg[type];
	}

	public boolean hit() {
		Rectangle myrect = new Rectangle((int) this.x, (int) this.y, this.width, this.height);
		Rectangle rect = null;
		return false;
    }
   
    public Rectangle getHitbox(){
		return new Rectangle((int) this.x + 16*3, (int) this.y + 24*3, 17*3, 12*3);
    }
    
}
