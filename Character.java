import java.awt.Image;
import java.awt.Rectangle;
import javax.swing.ImageIcon;

public class Character extends MapItem {
	class Breath extends Thread {
		Character character;
		// Image arrow = new ImageIcon("");
		Image[] idle_imgs = {new ImageIcon("img/Character/adventurer-idle-00.png").getImage(),
				new ImageIcon("img/Character/adventurer-idle-01.png").getImage(),
				new ImageIcon("img/Character/adventurer-idle-02.png").getImage()};
		Image[] run_imgs = {new ImageIcon("img/Character/adventurer-run-00.png").getImage(),
				new ImageIcon("img/Character/adventurer-run-01.png").getImage(),
				new ImageIcon("img/Character/adventurer-run-02.png").getImage()};
		// new ImageIcon("img/Character/adventurer-run-01.png").getImage()};
		Image[] shoot_imgs = {new ImageIcon("img/Character/adventurer-bow-00.png").getImage(),
				new ImageIcon("img/Character/adventurer-bow-01.png").getImage(),
				new ImageIcon("img/Character/adventurer-bow-02.png").getImage(),
				new ImageIcon("img/Character/adventurer-bow-03.png").getImage(),
				new ImageIcon("img/Character/adventurer-bow-04.png").getImage(),
				new ImageIcon("img/Character/adventurer-bow-05.png").getImage(),
				new ImageIcon("img/Character/adventurer-bow-06.png").getImage(),
				new ImageIcon("img/Character/adventurer-bow-07.png").getImage(),
				new ImageIcon("img/Character/adventurer-bow-08.png").getImage(),};
		Image[] die_imgs = {new ImageIcon("img/Character/adventurer-get-up-06.png").getImage(),
				new ImageIcon("img/Character/adventurer-get-up-05.png").getImage(),
				new ImageIcon("img/Character/adventurer-get-up-04.png").getImage(),
				new ImageIcon("img/Character/adventurer-get-up-03.png").getImage(),
				new ImageIcon("img/Character/adventurer-get-up-02.png").getImage(),
				new ImageIcon("img/Character/adventurer-get-up-01.png").getImage(),
				new ImageIcon("img/Character/adventurer-get-up-00.png").getImage()};

		Breath(Character character) {
			this.character = character;
		}

		public void run() {
			while (true) {
				if (character.gp.gameover)
					return;
				for (int i = 0; character.state == 0; i = (i + 1) % 3) {
					character.img = idle_imgs[i];
					try {
						this.sleep(200);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				for (int i = 0; character.state == 1; i = (i + 1) % 3) {
					character.img = run_imgs[i];
					try {
						this.sleep(200);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				for (int i = 0; character.state == 2; i = (i + 1) % 9) {
					character.img = shoot_imgs[i];
					if (i == 8) {
						character.gp.shoot
								.add(new Shoot(gp, (character.facing > 0) ? character.x + 129 : character.x - 18,
										character.y + 60, character.facing));
						new PlaySounds("./music/shootingsound.wav").start();
					}
					try {
						this.sleep(75);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				for (int i = 0; character.state == 3; i = (i + 1) % 7) {
					
					
					try {
						if(gp.monster.size() != 0){
							character.img = die_imgs[i];
							this.sleep(200);
						}
						else{
							this.sleep(0);
						}
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					if (i == 6) {
						character.gp.gameover = true;
						character.gp.mainframe.BGM.change("./music/tobecontinue.wav");
						return;
					}
				}
			}
		}
	}

	public GamePanel gp;
	public double x = 100, y = 500;
	public int width = 150, height = 111;
	public Image img;

	public boolean left = false, right = false, down = false, up = false;
	public int facing = 1;
	public int state = 2; // 0 = idle

	public Character(GamePanel gp) {
		this.gp = gp;
	}

	public void run() {
		while (true) {
			if (this.state == 3)
				return;
			double move_x = (right ? 1 : 0) + (left ? -1 : 0);
			double move_y = (down ? 1 : 0) + (up ? -1 : 0);
			if (Math.abs(move_x) + Math.abs(move_y) == 2) {
				move_x /= Math.sqrt(2);
				move_y /= Math.sqrt(2);
			}
			// System.out.println(angle);
			if ((left || right || down || up) && (!(left && right && down && up))
					&& ((0 < (x + 16 * 3 + move_x))
							&& ((x + 16 * 3 + move_x) < (1280 - this.getHitbox().getWidth())))
					&& ((320 < (y + 24 * 3 + move_y))
							&& ((y + 24 * 3 + move_y) < (720 - this.getHitbox().getHeight())))) {
				this.state = 1;
				x += move_x;
				y += move_y;
				boolean unwalkable = false;
				for (Obstacle o : gp.obstacle) {
					if (unwalkable)
						break;
					else {
						unwalkable = this.getHitbox().intersects(o.getHitbox());
					}
				}
				if (unwalkable) {
					x -= move_x;
					y -= move_y;
				}

				facing = (move_x < 0) ? -1 : (move_x == 0) ? facing : 1;
			} else
				this.state = 2;

			try {
				this.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	void breath() {
		new Breath(this).start();
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
		return state;
	}

	public Image getImage() {
		return img;
	}

	public Rectangle getHitbox() {
		return new Rectangle((int) this.x + 16 * 3, (int) this.y + 24 * 3, 17 * 3, 12 * 3);
	}
}
