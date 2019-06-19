import java.awt.Image;
import java.awt.Rectangle;
import java.util.Random;
import javax.swing.ImageIcon;


public class Spit extends MapItem {
	class Breath extends Thread {
		Spit spit;

		Breath(Spit spit) {
			this.spit = spit;
		}

		public void run() {

			try {
				this.sleep(200);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		}
	}

	
	Random ran = new Random();
	
	public GamePanel gp;
	// public double x = 100, y = 500;
	public double x = (double) ran.nextInt(1000) + 100, y = (double) ran.nextInt(400) + 320 - 50;

	public int width, height;
	public Image img = new ImageIcon("./img/Monster/spit.png").getImage();

	public boolean left = false, right = false, down = false, up = false;
	public int state = 0; // 0 = idle
	public int facing = 1;

	public Spit(GamePanel gp) {
		this.gp = gp;
		this.width = this.img.getWidth(gp);
		this.height = this.img.getHeight(gp);
		this.x = gp.
	}
	// 0 1 2
	// 3 4 5
	// 6 7 8

	public void run() {
		while (true) {

			
			try {
				this.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public boolean hit() {
		Rectangle myrect = new Rectangle((int) this.x, (int) this.y, this.width, this.height);
		Rectangle rect = null;
		return false;
	}

	void breath() {
		new Breath(this).start();
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
		return state;
	}

	public Image getImage() {
		return img;
	}

	public Rectangle getHitbox() {
		return new Rectangle((int) this.x + 5, (int) this.y + 25, 17 * 3, 14 * 3);
	}
}
