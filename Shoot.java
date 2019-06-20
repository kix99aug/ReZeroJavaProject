import java.awt.Image;
import java.awt.Rectangle;
import java.util.Random;
import javax.swing.ImageIcon;


public class Shoot extends MapItem {

  Image arrowImages[] = {new ImageIcon("./img/diamondarrow.png").getImage(),
      new ImageIcon("./img/ironarrow.png").getImage(),
      new ImageIcon("./img/woodarrow.png").getImage()};
  public double x;
  public double y;
  public Image img;
  public GamePanel gp;

  public int width, height;
  public boolean left = false, right = false, down = false, up = false;

  public int facing = 1;

  public Shoot(GamePanel gp, double x, double y, int facing) {
    this.gp = gp;
    this.img = arrowImages[0];
    this.x = x;
    this.y = y;
    this.width = 30;
    this.height = 6;
    this.facing = facing;

    this.start();
  }

  public void run() {
    BagPanel bg = ((BagPanel)(gp.mainframe.panels.get("bag")));
    while (true) {
      if (this.gp.gameover) return;
      this.x += this.facing;
      for (Obstacle o : gp.obstacle) {
        if (this.getHitbox().intersects(o.getHitbox())) return;
      }
      for (Monster m : gp.monster){
        if (this.getHitbox().intersects(m.getHitbox())) {
          m.HP-=(gp.mainframe.Attack);
          if(m.HP<=0){
            Random ran = new Random();
            int quality = ran.nextInt(100);
            int equip = ran.nextInt(100);
            int which = ran.nextInt(4);
            if(quality<=70){
              //調素材
              if(equip<60){
                bg.check_material[2]++;
              }
              else if(equip<90){
                bg.check_material[1]++;
              }
              else{
                bg.check_material[0]++;
              }
            }
            else{
              //裝備
              if(equip<60){

              }
              else if(equip<85){
                bg.check_armor[which*3+1] = 1;
              }
              else if(equip<90){
                bg.check_armor[which*3+0] = 1;
              }
              else if(equip<97){
                bg.check_weapon[1] = 1;
              }
              else{
                bg.check_weapon[0] = 1;

              }
            }
            m.dead =true;
            gp.monster.remove(m);
          }
          gp.shoot.remove(this);
          if(gp.monster.size() == 0){
            this.gp.character.state = 3;
          }
          
          return;
          
         
        }
      }
      try {
        this.sleep(5);
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


  public Rectangle getHitbox() {
    return new Rectangle((int) this.x + 22, (int) this.y, 8, 6);
  }

}
