import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MenuPanel extends AbstractPanel {
  MainFrame mainframe = null;

  Image bgImage = new ImageIcon("./img/bg.png").getImage(); 

  JButton startButton;
  JButton bagButton;
  JButton exitButton;

  JLabel logo=new JLabel();

  int buttonW = 240,buttonH = 64;
  ImageIcon LogoImg = new ImageIcon(new ImageIcon("./img/logo.png").getImage().getScaledInstance(300,250, Image.SCALE_FAST));
  MenuPanel(MainFrame mf){
    this.mainframe = mf;
    this.setSize(this.mainframe.getSize());
    this.setLayout(null);
    this.add(logo);
    logo.setBounds(490,40,300,250);
    logo.setBorder(null);
    logo.setIcon(LogoImg);
    this.setLayout(null);
    startButton = new Button("play",(1280-buttonW)/2,300,buttonW,buttonH,this);
    bagButton = new Button("inventory",(1280-buttonW)/2,400,buttonW,buttonH,this);
    exitButton = new Button("quit",(1280-buttonW)/2,500,buttonW,buttonH,this);    
  }
  public void actionPerformed(ActionEvent e) {
    if (e.getSource() == startButton) {
      this.mainframe.changeScene("game");
    }
    else if(e.getSource() == bagButton){
      this.mainframe.changeScene("bag");
    }
    else if(e.getSource() == exitButton){
      System.exit(0);
    }
    /*else if(e.getSource() == bagButton){
     // mf.getContentPane().add();
    }*/
} 
  public void paintComponent(Graphics g){
    super.paintComponent(g);
    g.drawImage(bgImage, 0, 0,this.mainframe.getWidth(),this.mainframe.getHeight(),mainframe);
  }
}
