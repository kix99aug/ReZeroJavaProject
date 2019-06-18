import java.awt.Image;
import java.awt.Rectangle;
import javax.swing.ImageIcon;



public class Character extends Thread {
	class Idle extends Thread {
		Character character;
		Image[] idle_imgs = {new ImageIcon("img/Character/adventurer-idle-00.png").getImage(),
				new ImageIcon("img/Character/adventurer-idle-01.png").getImage(),
				new ImageIcon("img/Character/adventurer-idle-02.png").getImage()};
		Image[] run_imgs = {new ImageIcon("img/Character/adventurer-run-00.png").getImage(),
				new ImageIcon("img/Character/adventurer-run-01.png").getImage(),
				new ImageIcon("img/Character/adventurer-run-02.png").getImage(),
				new ImageIcon("img/Character/adventurer-run-01.png").getImage()};

		Idle(Character character) {
			this.character = character;
		}

		public void run() {
			while (true) {
				for (int i = 0; character.state == 0; i = (i + 1) % 3) {
					character.img = idle_imgs[i];
					try {
						this.sleep(200);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				for (int i = 0; character.state == 1; i = (i + 1) % 4) {
					character.img = run_imgs[i];
					try {
						this.sleep(200);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}
	}

	public GamePanel gp;
	public double x = 100, y = 500;
	public int width = 74, height = 100;
	public Image img;

	public boolean left = false, right = false, down = false, up = false;
	public int facing =1;
	public int state = 0; // 0 = idle

	public Character(GamePanel gp) {
		this.gp = gp;
		new Idle(this).start();
	}

	public void run() {
		while (true) {
			double move_x = (right ? 1 : 0) + (left ? -1 : 0);
			double move_y = (down ? 1 : 0) + (up ? -1 : 0);
			if (Math.abs(move_x) + Math.abs(move_y) == 2) {
				move_x /= Math.sqrt(2);
				move_y /= Math.sqrt(2);
			}
			// System.out.println(angle);
			if ((left || right || down || up) && (!(left&&right&&down&&up))) {
				this.state = 1;
				x += move_x;
				y += move_y;
				facing = (move_x < 0) ? -1 : 1;
				System.out.println(facing);
			} else this.state = 0;
			try {
				this.sleep(20);
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
}
