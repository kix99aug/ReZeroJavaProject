import java.awt.Image;
import java.awt.Rectangle;
import javax.swing.ImageIcon;



public class Character extends Thread {
	class Idle extends Thread {
		Character character;
		Image[] imgs = {
			new ImageIcon("img/Character/adventurer-idle-00.png").getImage(),
			new ImageIcon("img/Character/adventurer-idle-01.png").getImage(),
			new ImageIcon("img/Character/adventurer-idle-02.png").getImage()
		};
		Idle(Character character){
			this.character = character;
		}
		public void run(){
			for(int i = 0;character.state==0;i=(i+1)%3){
				character.img = imgs[i];
				try {
					this.sleep(200);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}
	public GamePanel gp;
	public double x = 100, y = 500;
	public int width = 74, height = 100;
	public Image img = new ImageIcon("img/Character/adventurer-idle-00.png").getImage();

	public boolean left = false, right = false, down = false, up = false;
	public int state = 0; //0 = idle

	public Character(GamePanel gp) {
		this.gp = gp;
		new Idle(this).start();
	}

	public void run() {
		while (true) {
			try {
				this.sleep(20);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public boolean hit() {
		Rectangle myrect = new Rectangle((int)this.x, (int)this.y, this.width, this.height);
		Rectangle rect = null;
		return false;
	}
}
