import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class InputNamePanel extends JPanel implements ActionListener {
  MainFrame mainframe = null;

  Image bgImage = new ImageIcon("./img/bg.png").getImage(); 

  int buttonW = 190,buttonH = 80;
  ImageIcon startImage[] = {
    new ImageIcon(new ImageIcon("./img/btn/start.png").getImage().getScaledInstance(buttonW, buttonH, Image.SCALE_DEFAULT)),
    new ImageIcon(new ImageIcon("./img/btn/start_r.png").getImage().getScaledInstance(buttonW, buttonH, Image.SCALE_DEFAULT)),
    new ImageIcon(new ImageIcon("./img/btn/start_p.png").getImage().getScaledInstance(buttonW, buttonH, Image.SCALE_DEFAULT))
  }; 
  JButton startButton = new JButton();
  InputNamePanel(MainFrame mf){
    this.mainframe = mf;
    this.setSize(this.mainframe.getSize());
    this.setLayout(null);
    startButton.setBounds(1280/2-buttonW/2, 300, buttonW, buttonH);
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
      this.setVisible(false);
      this.mainframe.panels.get("menu").setVisible(true);
    }
  } 
  public void paintComponent(Graphics g){
    super.paintComponent(g);
    g.drawImage(bgImage, 0, 0,this.mainframe.getWidth(),this.mainframe.getHeight(),mainframe);
  }
}
