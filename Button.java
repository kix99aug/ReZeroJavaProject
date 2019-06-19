import java.awt.*;
import java.awt.event.*;
import java.util.HashMap;
import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;


public class Button extends JButton {
  ImageIcon Images[] = {null, null, null};
  PlaySounds mouseexited;

  Button(String name, int x, int y, int buttonW, int buttonH, AbstractPanel menu) {
    super();
    Images[0] = new ImageIcon(new ImageIcon("./img/btn/" + name + ".png").getImage()
        .getScaledInstance(buttonW, buttonH, Image.SCALE_FAST));
    Images[1] = new ImageIcon(new ImageIcon("./img/btn/" + name + "_r.png").getImage()
        .getScaledInstance(buttonW, buttonH, Image.SCALE_FAST));
    Images[2] = new ImageIcon(new ImageIcon("./img/btn/" + name + "_p.png").getImage()
        .getScaledInstance(buttonW, buttonH, Image.SCALE_FAST));
    this.setBounds(x, y, buttonW, buttonH);
    this.setIcon(Images[0]);
    this.setRolloverIcon(Images[1]);
    this.setPressedIcon(Images[2]);
    this.setBorder(null);
    this.setContentAreaFilled(false);
    this.addActionListener(menu);
    this.addMouseListener(new MouseAdapter() {
      public void mouseEntered(MouseEvent me) {
        new PlaySounds("./music/喀拉音效_r.wav").start();
      }

      public void mousePressed(MouseEvent me) {
        new PlaySounds("./music/click.wav").start();
      }

    });
    menu.add(this);
  }

}
