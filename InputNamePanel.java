import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class InputNamePanel extends AbstractPanel implements ActionListener {
  MainFrame mainframe = null;

  Image bgImage = new ImageIcon("./img/bg.png").getImage(); 
  Image textboxImage = new ImageIcon("./img/inputname_textbox.png").getImage(); 

  int buttonW = 60,buttonH = 60;
  JButton goButton;
  JTextField nameField = new JTextField("Input name here",10);
  Color C1 = new Color(186,191,194,0);

  InputNamePanel(MainFrame mf){
    this.mainframe = mf;
    this.setSize(this.mainframe.getSize());
    this.setLayout(null);
    goButton = new Button("go",795,420,buttonW,buttonH,this);    
    nameField.setFont(new Font("NasuM",Font.BOLD,28));
    nameField.setBounds(475, 405, 260, 32);
    nameField.setVisible(true);
    nameField.setBorder(null);
    nameField.setOpaque(false);
    nameField.setForeground(new Color(255,255,255,255));
    nameField.enableInputMethods(false);
    this.add(nameField);
  }
  public void actionPerformed(ActionEvent e) {
    if (e.getSource() == goButton) {
      this.mainframe.changeScene("menu");
      this.mainframe.username = new String (nameField.getText());
      //((MenuPanel)this.mainframe.panels.get("menu")).testButton.setText(this.mainframe.username);  測試 JTextField 有無輸入進去
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
