import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class InputNamePanel extends JPanel implements ActionListener {
  MainFrame mainframe = null;

  Image bgImage = new ImageIcon("./img/bg.png").getImage(); 
  Image textboxImage = new ImageIcon("./img/inputname_textbox.png").getImage(); 

  int buttonW = 60,buttonH = 60;
  ImageIcon startImage[] = {
    new ImageIcon(new ImageIcon("./img/btn/check.png").getImage().getScaledInstance(buttonW, buttonH, Image.SCALE_DEFAULT)),
    new ImageIcon(new ImageIcon("./img/btn/check_r.png").getImage().getScaledInstance(buttonW, buttonH, Image.SCALE_DEFAULT)),
    new ImageIcon(new ImageIcon("./img/btn/check_p.png").getImage().getScaledInstance(buttonW, buttonH, Image.SCALE_DEFAULT))
  }; 
  JButton startButton = new JButton();
  InputNamePanel(MainFrame mf){
    this.mainframe = mf;
    this.setSize(this.mainframe.getSize());
    this.setLayout(null);
    startButton.setBounds(795, 420, buttonW, buttonH);
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
      this.mainframe.changeScene("menu");
    }
  } 
  public void paintComponent(Graphics g){
    super.paintComponent(g);
    g.drawImage(bgImage, 0, 0,this.getWidth(),this.getHeight(),mainframe);
    g.setColor(new Color(0,0,0,128));
    g.fillRect(0,0,this.getWidth(),this.getHeight());
    g.drawImage(textboxImage, this.getWidth()/2-this.getWidth()/6, this.getHeight()/2-this.getHeight()/6,this.getWidth()/3,this.getHeight()/3,mainframe);
  }
}
