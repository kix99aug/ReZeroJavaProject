import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class InputNamePanel extends JPanel implements ActionListener {
  MainFrame mainframe = null;

  Image bgImage = new ImageIcon("./img/bg.png").getImage(); 
  Image bg2Image = new ImageIcon("./img/InputNameBG.png").getImage(); 

  int buttonW = 190,buttonH = 80;
  ImageIcon startImage[] = {
    new ImageIcon(new ImageIcon("./img/btn/start.png").getImage().getScaledInstance(buttonW, buttonH, Image.SCALE_DEFAULT))
    //new ImageIcon(new ImageIcon("./img/btn/start_r.png").getImage().getScaledInstance(buttonW, buttonH, Image.SCALE_DEFAULT)),
    //new ImageIcon(new ImageIcon("./img/btn/start_p.png").getImage().getScaledInstance(buttonW, buttonH, Image.SCALE_DEFAULT))
  }; 
  JButton goButton = new JButton();
  JTextField nameField = new JTextField("user1",10);

  InputNamePanel(MainFrame mf){
    this.mainframe = mf;
    this.setSize(this.mainframe.getSize());
    this.setLayout(null);
    goButton.setBounds(1280/2-buttonW/2, 300, buttonW, buttonH);
    goButton.setIcon(startImage[0]);
    //goButton.setRolloverIcon(startImage[1]);
    //goButton.setPressedIcon(startImage[2]);
    goButton.setBorder(null);
    goButton.setContentAreaFilled(false);
    goButton.addActionListener(this);
    this.add(goButton);

    nameField.setVisible(true);
    nameField.setBounds(1280/2-200,300,200,40);
    nameField.setFont(new Font("微軟正黑體",Font.BOLD,25));
    this.add(nameField);
  }
  public void actionPerformed(ActionEvent e) {
    if (e.getSource() == goButton) {
      this.mainframe.changeScene("menu");
    }
  } 
  public void paintComponent(Graphics g){
    super.paintComponent(g);
    g.drawImage(bgImage, 0, 0,this.mainframe.getWidth(),this.mainframe.getHeight(),mainframe);
    g.drawImage(bg2Image, 0, 0,this.mainframe.getWidth(),this.mainframe.getHeight(),mainframe);
  }

}
