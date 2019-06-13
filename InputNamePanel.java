import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class InputNamePanel extends JPanel implements ActionListener {
  MainFrame mainframe = null;

  Image bgImage = new ImageIcon("./img/bg.png").getImage(); 
  Image textboxImage = new ImageIcon("./img/inputname_textbox.png").getImage(); 

  int buttonW = 60,buttonH = 60;
  ImageIcon goImage[] = {
    new ImageIcon(new ImageIcon("./img/btn/check.png").getImage().getScaledInstance(buttonW, buttonH, Image.SCALE_DEFAULT)),
    new ImageIcon(new ImageIcon("./img/btn/check_r.png").getImage().getScaledInstance(buttonW, buttonH, Image.SCALE_DEFAULT)),
    new ImageIcon(new ImageIcon("./img/btn/check_p.png").getImage().getScaledInstance(buttonW, buttonH, Image.SCALE_DEFAULT))
  }; 
  JButton goButton = new JButton();
  JTextField nameField = new JTextField("user1",10);
  Color C1 = new Color(186,191,194,0);

  InputNamePanel(MainFrame mf){
    this.mainframe = mf;
    this.setSize(this.mainframe.getSize());
    this.setLayout(null);
    goButton.setBounds(795, 420, buttonW, buttonH);
    goButton.setIcon(goImage[0]);
    goButton.setRolloverIcon(goImage[1]);
    goButton.setPressedIcon(goImage[2]);
    goButton.setBorder(null);
    goButton.setContentAreaFilled(false);
    goButton.addActionListener(this);
    this.add(goButton);
    
    nameField.setFont(new Font("NasuM",Font.BOLD,32));
    nameField.setBounds(460, 400, 300, 40);
    nameField.setVisible(true);
    nameField.setBorder(null);
    nameField.setOpaque(false);
    this.add(nameField);
  }
  public void actionPerformed(ActionEvent e) {
    if (e.getSource() == goButton) {
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
