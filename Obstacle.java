import java.awt.Image;
import java.awt.Rectangle;
import java.util.Random;
import javax.swing.ImageIcon;


public class Obstacle extends Thread {
    
    Image obstacle[] = {new ImageIcon("./img/MapSource/obstacle3.png").getImage(),
        new ImageIcon("./img/MapSource/obstacle4.png").getImage(),
        new ImageIcon("./img/MapSource/obstacle5.png").getImage(),
        new ImageIcon("./img/MapSource/obstacle6.png").getImage()};
    public double store_X;
    public double store_Y;
    public int choose ;
    public Image img ;
    public void positionXY(){
       
        Random ran = new Random();
        this.choose = ran.nextInt(4);
        this.store_X = (double)ran.nextInt(1280);
        this.store_Y = (double)ran.nextInt(80);
    }
	public GamePanel gp;
	// public double x = 100, y = 500;
	public int width = 74, height = 100;
	public Image img;
	public boolean left = false, right = false, down = false, up = false;
	
	public Obstacle(GamePanel gp) {
		this.gp = gp;
		positionXY();
	}

	public boolean hit() {
		Rectangle myrect = new Rectangle((int) this.store_X, (int) this.store_Y, this.width, this.height);
		Rectangle rect = null;
		return false;
    }
    public void run(){
			obstacle.img = 
    }
}
