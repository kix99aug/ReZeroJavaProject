import java.awt.*;
import java.awt.event.*;
import java.util.HashMap;
import javax.swing.*;



public class Button extends JButton {
  ImageIcon Images[] = {null,null,null}; 

  Button(String name,int x,int y,int buttonW,int buttonH,AbstractPanel menu) {
    super();
    Images[0]=new ImageIcon(new ImageIcon("./img/btn/"+name+".png").getImage().getScaledInstance(buttonW, buttonH, Image.SCALE_FAST));
    Images[1]=new ImageIcon(new ImageIcon("./img/btn/"+name+"_r.png").getImage().getScaledInstance(buttonW, buttonH, Image.SCALE_FAST));
    Images[2]=new ImageIcon(new ImageIcon("./img/btn/"+name+"_p.png").getImage().getScaledInstance(buttonW, buttonH, Image.SCALE_FAST));
    this.setBounds(x, y, buttonW, buttonH);
    this.setIcon(Images[0]);
    this.setRolloverIcon(Images[1]);
    this.setPressedIcon(Images[2]);
    this.setBorder(null);
    this.setContentAreaFilled(false);
    this.addActionListener(menu);
    menu.add(this);
  }

}