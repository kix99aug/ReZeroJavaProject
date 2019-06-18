import java.awt.*;
import java.awt.event.*;
import java.util.HashMap;
import javax.swing.*;



public class SetButton extends JButton {

  SetButton( ImageIcon Image,int x,int y,int buttonW,int buttonH,AbstractPanel menu) {
    super();
    this.setBounds(x, y, buttonW, buttonH);
    this.setIcon(Image);
    this.setBorder(null);
    this.setContentAreaFilled(false);
    this.addActionListener(menu);
    menu.add(this);
  }

}