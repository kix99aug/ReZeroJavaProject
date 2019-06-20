import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.ArrayList;
import java.util.Random;
import java.util.Comparator;

public class GamePanel extends AbstractPanel implements KeyListener {
  MainFrame mainframe = null;
  Image skyImage = new ImageIcon("./img/sky1.png").getImage();
  Image groundImage = new ImageIcon("./img/ground1.png").getImage();

  boolean gameover = false;
  int bgx = 0, bgy = 0;
  int tobecontinue_x = 1280;

  public void keyPressed(KeyEvent e) {
    System.out.println(e.getKeyCode());
    switch (e.getKeyCode()) {
      case 37:
        this.character.left = true;
        break;
      case 38:
        this.character.up = true;
        break;
      case 39:
        this.character.right = true;
        break;
      case 40:
        this.character.down = true;
        break;
    }
  }

  public void keyReleased(KeyEvent e) {
    System.out.println(e.getKeyCode());
    switch (e.getKeyCode()) {
      case 37:
        this.character.left = false;
        break;
      case 38:
        this.character.up = false;
        break;
      case 39:
        this.character.right = false;
        break;
      case 40:
        this.character.down = false;
        break;
    }
  }

  public void keyTyped(KeyEvent e) {
  }


  public Character character;
  // public Monster monster[] = new Monster[5];
  // public Obstacle obstacle[] = new Obstacle[5];
  public ArrayList<Monster> monster;
  public ArrayList<Obstacle> obstacle;
  public ArrayList<Shoot> shoot;
  public ArrayList<Spit> spit;

  class PrintScreen extends Thread {
    GamePanel gp;

    PrintScreen(GamePanel gp) {
      this.gp = gp;
    }

    public void run() {
      int count = 0;
      while (true) {
        repaint();
        if (gp.gameover)
          count++;
        if (count == 1800) {
          gp.mainframe.changeScene("menu");
          return;
        }
        try {
          Thread.sleep(5);
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
      }
    }
  }

  GamePanel(MainFrame mf) {
    this.mainframe = mf;
    this.setSize(this.mainframe.getSize());
    this.setLayout(null);
    this.addKeyListener(this);
    this.setFocusable(true);
  }

  public void newGame() {
    gameover = false;
    tobecontinue_x = 1280;
    character = new Character(this);

    monster = new ArrayList<Monster>();
    obstacle = new ArrayList<Obstacle>();
    shoot = new ArrayList<Shoot>();
    spit = new ArrayList<Spit>();
    int choose = new Random().nextInt(4);
    for (int i = 0; i < 5; i++) {
      monster.add(new Monster(this));

      obstacle.add(new Obstacle(this, choose));
    }
    new PrintScreen(this).start();
  }

  public void actionPerformed(ActionEvent e) {

  }

  public void paint(Graphics g) {
    super.paint(g);
    for (int i = 0; i < 1280; i += 319) {
      g.drawImage(skyImage, i, 0, mainframe);
      g.drawImage(groundImage, i, 320, mainframe);
    }
    ArrayList<MapItem> items = new ArrayList<MapItem>();
    items.add(character);
    for (Obstacle i : obstacle) {
      items.add(i);
    }
    for (Monster i : monster) {
      items.add(i);
    }
    for (Shoot s : shoot) {
      items.add(s);
    }
    for (Spit s : spit) {
      items.add(s);
    }
    items.sort(new Comparator<MapItem>() {
      @Override
      public int compare(MapItem i1, MapItem i2) {
        return (i1.getHitbox().y + i1.getHitbox().height)
            - (i2.getHitbox().y + i2.getHitbox().height);
      }
    });
    for (MapItem i : items) {
      g.drawImage(i.getImage(), (int) i.getX() + ((i.getFacing() == -1) ? i.getWidth() : 0),
          (int) i.getY(), i.getWidth() * i.getFacing(), i.getHeight(), mainframe);
      // g.drawRect(i.getHitbox().x, i.getHitbox().y, i.getHitbox().width, i.getHitbox().height);
    }
    g.drawImage(new ImageIcon("./img/hpbar.png").getImage(),(int)character.x,(int)character.y-20,152,20,mainframe);
    g.setColor(new Color(255, 0, 0,100));
    g.fillRect((int)character.x+24, (int)character.y-20+4, 104*character.hp/ mainframe.HP, 12);

    if (this.gameover) {
      g.setColor(new Color(180, 120, 30, 100));
      g.fillRect(0, 0, 1280, 720);
      g.drawImage(new ImageIcon("./img/tobecontinue.png").getImage(),
          (tobecontinue_x > 50) ? tobecontinue_x -= 3 : 50, 600, 256, 110, this);
    }
  }
}
