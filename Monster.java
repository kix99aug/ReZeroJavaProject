import java.awt.Image;
import java.awt.Rectangle;
import java.util.Random;
import javax.swing.ImageIcon;


public class Monster extends MapItem {
	public Image[][] images = {
			{new ImageIcon("./img/Monster/chibi-monsters-files/previews/1.png").getImage(),
					new ImageIcon("./img/Monster/chibi-monsters-files/previews/2.png").getImage(),
					new ImageIcon("./img/Monster/chibi-monsters-files/previews/3.png").getImage()},
			{new ImageIcon("./img/Monster/chibi-monsters-files/previews/frog1.png").getImage(),
					new ImageIcon("./img/Monster/chibi-monsters-files/previews/frog2.png").getImage(),
					new ImageIcon("./img/Monster/chibi-monsters-files/previews/frog3.png").getImage()},
			{new ImageIcon("./img/Monster/chibi-monsters-files/previews/ghost1.png").getImage(),
					new ImageIcon("./img/Monster/chibi-monsters-files/previews/ghost2.png").getImage(),
					new ImageIcon("./img/Monster/chibi-monsters-files/previews/ghost3.png").getImage()},
			{new ImageIcon("./img/Monster/chibi-monsters-files/previews/skeleton1.png").getImage(),
					new ImageIcon("./img/Monster/chibi-monsters-files/previews/skeleton2.png").getImage(),
					new ImageIcon("./img/Monster/chibi-monsters-files/previews/skeleton3.png").getImage(),
					new ImageIcon("./img/Monster/chibi-monsters-files/previews/skeleton4.png").getImage()}};
	class Idle extends Thread {
		Monster monster;

		Idle(Monster monster) {
			this.monster = monster;
		}
		public void run(){
			
			if(monster.chooseMonster != 3){
				for(int i = 0;monster.state==0;i=(i+1)%3){
					monster.img = monster.images[monster.chooseMonster][i];
					try {
						this.sleep(200);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			} else {
				for (int i = 0; monster.state == 0; i = (i + 1) % 4) {
					monster.img = monster.images[monster.chooseMonster][i];
					try {
						this.sleep(200);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}

		}
	}

	Random ran = new Random();
	public int chooseMonster = ran.nextInt(4);
	public GamePanel gp;
	// public double x = 100, y = 500;
	public double x = (double)ran.nextInt(1000)+100,y = (double)ran.nextInt(400)+320-50;
	
	public int width, height;
	public Image img ;

	public boolean left = false, right = false, down = false, up = false;
	public int state = 0; // 0 = idle
	public int facing = 1;

	public Monster(GamePanel gp) {
		this.gp = gp;
		this.img = this.images[chooseMonster][0];
        this.width = this.img.getWidth(gp);
        this.height = this.img.getHeight(gp);
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
		Rectangle myrect = new Rectangle((int) this.x, (int) this.y, this.width, this.height);
		Rectangle rect = null;
		return false;
	}
	public Rectangle getHitbox(){
		return new Rectangle((int) this.x + 16*3, (int) this.y + 24*3, 17*3, 12*3);
	}
}
