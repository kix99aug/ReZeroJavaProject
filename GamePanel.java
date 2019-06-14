import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class GamePanel extends AbstractPanel {
  MainFrame mainframe = null;

  Image bgImage = new ImageIcon("./img/bg.png").getImage(); 

  JButton startButton;
  JButton bagButton;
  JButton exitButton;

  JLabel logo=new JLabel();

  int buttonW = 190,buttonH = 80;
  ImageIcon LogoImg = new ImageIcon(new ImageIcon("./img/logo.png").getImage().getScaledInstance(300,250, Image.SCALE_FAST));
  GamePanel(MainFrame mf){
    this.mainframe = mf;
    this.setSize(this.mainframe.getSize());
    this.setLayout(null);
  }
  public void actionPerformed(ActionEvent e) {
} 
  public void paintComponent(Graphics g){
    super.paintComponent(g);
    g.drawImage(bgImage, 0, 0,this.mainframe.getWidth(),this.mainframe.getHeight(),mainframe);
  }
}
