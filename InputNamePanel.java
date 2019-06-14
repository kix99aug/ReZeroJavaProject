import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class InputNamePanel extends AbstractPanel {
  MainFrame mainframe = null;

  Image bgImage = new ImageIcon("./img/bg.png").getImage(); 
  Image textboxImage = new ImageIcon("./img/inputname_textbox.png").getImage(); 

  int buttonW = 60,buttonH = 60;
  ImageIcon goImage[] = {
    new ImageIcon(new ImageIcon("./img/btn/check.png").getImage().getScaledInstance(buttonW, buttonH, Image.SCALE_FAST)),
    new ImageIcon(new ImageIcon("./img/btn/check_r.png").getImage().getScaledInstance(buttonW, buttonH, Image.SCALE_FAST)),
    new ImageIcon(new ImageIcon("./img/btn/check_p.png").getImage().getScaledInstance(buttonW, buttonH, Image.SCALE_FAST))
  }; 
  JButton goButton = new JButton();
  JTextField nameField = new JTextField("user1",10);
  Color C1 = new Color(186,191,194,0);

  InputNamePanel(MainFrame mf){
    this.mainframe = mf;
    this.setSize(this.mainframe.getSize());
    this.setLayout(null);
    goButton = new Button("go",null,795,420,60,60,this);
    goButton.addActionListener(this);
    nameField.setFont(new Font("NasuM",Font.BOLD,28));
    nameField.setBounds(475, 405, 260, 32);
    nameField.setVisible(true);
    nameField.setBorder(null);
    nameField.setOpaque(false);
    nameField.setForeground(new Color(255,255,255,255));
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
