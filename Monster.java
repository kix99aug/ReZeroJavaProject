import java.awt.Image;
import java.awt.Rectangle;
import java.util.Random;
import javax.swing.ImageIcon;

public class Monster extends MapItem {
	public Image[][] images = {
			{ new ImageIcon("./img/Monster/chibi-monsters-files/previews/1.png").getImage(),
					new ImageIcon("./img/Monster/chibi-monsters-files/previews/2.png").getImage(),
					new ImageIcon("./img/Monster/chibi-monsters-files/previews/3.png").getImage() },
			{ new ImageIcon("./img/Monster/chibi-monsters-files/previews/frog1.png").getImage(),
					new ImageIcon("./img/Monster/chibi-monsters-files/previews/frog2.png").getImage(),
					new ImageIcon("./img/Monster/chibi-monsters-files/previews/frog3.png").getImage() },
			{ new ImageIcon("./img/Monster/chibi-monsters-files/previews/ghost1.png").getImage(),
					new ImageIcon("./img/Monster/chibi-monsters-files/previews/ghost2.png").getImage(),
					new ImageIcon("./img/Monster/chibi-monsters-files/previews/ghost3.png").getImage() },
			{ new ImageIcon("./img/Monster/chibi-monsters-files/previews/skeleton1.png").getImage(),
					new ImageIcon("./img/Monster/chibi-monsters-files/previews/skeleton2.png").getImage(),
					new ImageIcon("./img/Monster/chibi-monsters-files/previews/skeleton3.png").getImage(),
					new ImageIcon("./img/Monster/chibi-monsters-files/previews/skeleton4.png").getImage() } };

	class Breath extends Thread {
		Monster monster;

		Breath(Monster monster) {
			this.monster = monster;
		}

		public void run() {
      if (monster.gp.gameover) return;

			if (monster.chooseMonster != 3) {
				for (int i = 0; monster.state == 0; i = (i + 1) % 3) {
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

	public boolean shoot;
	Random ran = new Random();
	public int chooseMonster = ran.nextInt(4);
	public GamePanel gp;
	// public double x = 100, y = 500;
	public double x = (double) ran.nextInt(1000) + 100, y = (double) ran.nextInt(400) + 320 - 50;

	public int width, height;
	public Image img;

	public boolean left = false, right = false, down = false, up = false;
	public int state = 0; // 0 = idle
	public int facing = 1;

	public Monster(GamePanel gp) {
		this.gp = gp;
		this.img = this.images[chooseMonster][0];
		this.width = this.img.getWidth(gp);
		this.height = this.img.getHeight(gp);
		if (this.chooseMonster == 0) {
			this.shoot = true;
		} else {
			this.shoot = false;
		}
	}
	// 0 1 2
	// 3 4 5
	// 6 7 8

	public void run() {
		while (true) {

      if (this.gp.gameover) return;
			double min_x = this.x,min_y =  this.y,min_dis = (this.x-gp.character.x)*(this.x-gp.character.x)+(this.y-gp.character.y)*(this.y-gp.character.y);
			double org_x = this.x,org_y = this.y;
			for(int i =0;i<9;i++){
				this.x = org_x;
				this.y = org_y;
				this.x +=(i%3-1)*40  / ((i % 2 == 0)? Math.sqrt(2) : 1) ;
				this.y +=((int)(i/3)-1)*40 / ((i % 2 == 0)? Math.sqrt(2) : 1);
				boolean unwalkable = false;
				if(this.getHitbox().intersects(gp.character.getHitbox())){
					//attack
					this.x = org_x;
					this.y = org_y;
					break;
				} else for (Obstacle o : gp.obstacle){
					unwalkable = this.getHitbox().intersects(o.getHitbox());
					if (unwalkable) break;
				}
				if (!unwalkable) {
					double dis = (this.x-gp.character.x)*(this.x-gp.character.x)+(this.y-gp.character.y)*(this.y-gp.character.y);
					if (dis < min_dis) {
						min_x = this.x;
						min_y = this.y;
						min_dis = dis;
					}
				}
			}
			this.x = org_x;
			this.y = org_y;
			double offset_x = min_x - this.x ,offset_y =  min_y- this.y ;
			for(int i = 0;i< 50;i++){
				if(this.chooseMonster != 0){
					this.x += offset_x/50;
					this.y += offset_y/50;
					if(offset_x<0){
						this.facing = -1;
					}
					else{
						this.facing = 1;
					}
				}else{
					this.facing = (gp.character.x - this.x < 0)? -1 :1;
				}
				
				try {
					this.sleep(20-this.chooseMonster*5);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			// double store_X, store_Y;
			// store_X = this.x - gp.character.x - gp.character.getWidth() / 2 + this.width / 2;
			// store_Y = this.y - gp.character.y - gp.character.getHeight() / 2 + this.height / 2;
			// this.facing = store_X < 0 ? 1 : -1;
			// this.x -= 1 * (store_X > 0 ? 1 : -1);
			// this.y -= 1 * (store_Y > 0 ? 1 : -1);
			// boolean unwalkable = this.getHitbox().intersects(gp.character.getHitbox());
			// for (Obstacle o : gp.obstacle){
			// 	if (unwalkable) {
					
						
					
			// 		//this.x+= 1*(store_X/Math.abs(store_X));
			// 		break;
			// 	}else{
			// 		//this.x-= 1*(store_X/Math.abs(store_X));
			// 		unwalkable = this.getHitbox().intersects(o.getHitbox());
			// 		if(unwalkable){
			// 			this.y+=1;
			// 		}
			// 	}
			// }
			// if (unwalkable) {
			// 	this.x += 1 * (store_X > 0 ? 1 : -1);
			// 	this.y += 1 * (store_Y > 0 ? 1 : -1);
			// } 
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
