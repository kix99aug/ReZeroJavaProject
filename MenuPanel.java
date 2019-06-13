import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MenuPanel extends JPanel implements ActionListener {
  MainFrame mainframe = null;
  JButton startButton = new JButton();
  JButton bagButton = new JButton();
  JButton exitButton = new JButton();
  int buttonW = 190,buttonH = 80;
  Image bgImage = new ImageIcon("./img/bg.png").getImage(); 
  ImageIcon startImage[] = {
    new ImageIcon(new ImageIcon("./img/btn/start.png").getImage().getScaledInstance(buttonW, buttonH, Image.SCALE_DEFAULT)),
    new ImageIcon(new ImageIcon("./img/btn/start_r.png").getImage().getScaledInstance(buttonW, buttonH, Image.SCALE_DEFAULT)),
    new ImageIcon(new ImageIcon("./img/btn/start_p.png").getImage().getScaledInstance(buttonW, buttonH, Image.SCALE_DEFAULT))
  }; 
  ImageIcon bagImage[] = {
    new ImageIcon(new ImageIcon("./img/btn/bag.png").getImage().getScaledInstance(buttonW, buttonH, Image.SCALE_DEFAULT)),
    new ImageIcon(new ImageIcon("./img/btn/bag_r.png").getImage().getScaledInstance(buttonW, buttonH, Image.SCALE_DEFAULT)),
    new ImageIcon(new ImageIcon("./img/btn/bag_p.png").getImage().getScaledInstance(buttonW, buttonH, Image.SCALE_DEFAULT))
  }; 
  ImageIcon exitImage[] = {
    new ImageIcon(new ImageIcon("./img/btn/exit.png").getImage().getScaledInstance(buttonW, buttonH, Image.SCALE_DEFAULT)),
    new ImageIcon(new ImageIcon("./img/btn/exit_r.png").getImage().getScaledInstance(buttonW, buttonH, Image.SCALE_DEFAULT)),
    new ImageIcon(new ImageIcon("./img/btn/exit_p.png").getImage().getScaledInstance(buttonW, buttonH, Image.SCALE_DEFAULT))
  }; 
  MenuPanel(MainFrame mf){
    this.mainframe = mf;
    this.setSize(this.mainframe.getSize());
    this.setLayout(null);
    startButton.setBounds(1280/2-buttonW/2, 400, buttonW, buttonH);
    startButton.setIcon(startImage[0]);
    startButton.setRolloverIcon(startImage[1]);
    startButton.setPressedIcon(startImage[2]);
    startButton.setBorder(null);
    startButton.setContentAreaFilled(false);
    startButton.addActionListener(this);
    this.add(startButton);
  }
  public void actionPerformed(ActionEvent e) {
    if (e.getSource() == startButton) {
      //super.
    }
    else if(e.getSource() == exitButton){
      System.exit(0);
    }
} 
  public void paintComponent(Graphics g){
    super.paintComponent(g);
    g.drawImage(bgImage, 0, 0,this.mainframe.getWidth(),this.mainframe.getHeight(),mainframe);
  }
}