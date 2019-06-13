import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MenuPanel extends JPanel implements ActionListener {
  MainFrame mainframe = null;

  Image bgImage = new ImageIcon("./img/bg.png").getImage(); 

  JButton startButton = new JButton();
  JButton bagButton = new JButton();
  JButton exitButton = new JButton();

  JLabel logo=new JLabel();

  int buttonW = 190,buttonH = 80;
  ImageIcon LogoImg[] = {
    new ImageIcon(new ImageIcon("./img/logo.png").getImage().getScaledInstance(300,250, Image.SCALE_DEFAULT))
  }; 
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
<<<<<<< HEAD
    this.setLayout(null);
    startButton.setBounds(1280/2-buttonW/2, 400, buttonW, buttonH);
=======

    this.setLayout(null);
    this.add(logo);
    logo.setBounds(490,40,300,250);
    logo.setBorder(null);
    logo.setIcon(LogoImg[0]);
    this.setLayout(null);

    startButton.setBounds(1280/2-buttonW/2, 300, buttonW, buttonH);
>>>>>>> 9d1962fa8b68223444d1a5adddc474ad80ecc5c9
    startButton.setIcon(startImage[0]);
    startButton.setRolloverIcon(startImage[1]);
    startButton.setPressedIcon(startImage[2]);
    startButton.setBorder(null);
    startButton.setContentAreaFilled(false);
    startButton.addActionListener(this);
    this.add(startButton);
<<<<<<< HEAD
  }
  public void actionPerformed(ActionEvent e) {
    if (e.getSource() == startButton) {
      //super.
=======

    bagButton.setBounds(1280/2-buttonW/2, 400, buttonW, buttonH);
    bagButton.setIcon(bagImage[0]);
    bagButton.setRolloverIcon(bagImage[1]);
    bagButton.setPressedIcon(bagImage[2]);
    bagButton.setBorder(null);
    bagButton.setContentAreaFilled(false);
    bagButton.addActionListener(this);
    this.add(bagButton);

    exitButton.setBounds(1280/2-buttonW/2, 500, buttonW, buttonH);
    exitButton.setIcon(exitImage[0]);
    exitButton.setRolloverIcon(exitImage[1]);
    exitButton.setPressedIcon(exitImage[2]);
    exitButton.setBorder(null);
    exitButton.setContentAreaFilled(false);
    exitButton.addActionListener(this);
    this.add(exitButton);
    
  }
  public void actionPerformed(ActionEvent e) {
    if (e.getSource() == startButton) {
      startButton.setLocation(startButton.getX()-1, startButton.getY()-1);
>>>>>>> 9d1962fa8b68223444d1a5adddc474ad80ecc5c9
    }
    else if(e.getSource() == exitButton){
      System.exit(0);
    }
<<<<<<< HEAD
=======
    /*else if(e.getSource() == bagButton){
     // mf.getContentPane().add();
    }*/
>>>>>>> 9d1962fa8b68223444d1a5adddc474ad80ecc5c9
} 
  public void paintComponent(Graphics g){
    super.paintComponent(g);
    g.drawImage(bgImage, 0, 0,this.mainframe.getWidth(),this.mainframe.getHeight(),mainframe);
  }
<<<<<<< HEAD
}
=======
}
>>>>>>> 9d1962fa8b68223444d1a5adddc474ad80ecc5c9
