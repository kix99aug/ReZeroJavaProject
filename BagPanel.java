import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class BagPanel extends JPanel implements ActionListener {
    MainFrame mainframe = null;
    JButton nineButtons[]={
      new JButton(),new JButton(),new JButton(),new JButton(),new JButton(),new JButton(),new JButton(),new JButton(),new JButton()
    };
    //創array去判斷現在有沒有拿到道具 沒有的話就是空圖
    //JButton firstButton = new JButton();
    Image bgImage = new ImageIcon("./img/bg.png").getImage(); 
    ImageIcon startImage[] = {
        new ImageIcon(new ImageIcon("./img/black.jpg").getImage()),
      }; 
     BagPanel(MainFrame mf){
        this.mainframe = mf;
        this.setSize(this.mainframe.getSize());
        this.setLayout(null);
        for(int i=0;i<9;i++)
        {
          nineButtons[i].setBounds(700+50*i, 150,40, 40);
          nineButtons[i].setIcon(startImage[0]);
          nineButtons[i].setBorder(null);
          nineButtons[i].setContentAreaFilled(false);
          nineButtons[i].addActionListener(this);
          this.add(nineButtons[i]);
        }
    }
    public void actionPerformed(ActionEvent e) {

    }
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        //g.drawImage(bgImage, 0, 0,this.mainframe.getWidth(),this.mainframe.getHeight(),mainframe);
      }
}
