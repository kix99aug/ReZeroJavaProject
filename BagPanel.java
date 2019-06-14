import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class BagPanel extends AbstractPanel {
    MainFrame mainframe = null;
    JButton nineButtons[]={
      new JButton(),new JButton(),new JButton(),new JButton(),new JButton(),new JButton(),new JButton(),new JButton(),new JButton()
    };
    int wid_height=40;
    //創array去判斷現在有沒有拿到道具 沒有的話就是空圖
    //JButton firstButton = new JButton();
    Image bgImage = new ImageIcon("./img/bagbg.png").getImage(); 
    ImageIcon Images[] = {
        new ImageIcon(new ImageIcon("./img/diamondarmor.png").getImage().getScaledInstance( wid_height,  wid_height, Image.SCALE_DEFAULT)),
        new ImageIcon(new ImageIcon("./img/ironarmor.png").getImage().getScaledInstance( wid_height,  wid_height, Image.SCALE_DEFAULT)),
        new ImageIcon(new ImageIcon("./img/woodarmor.png").getImage().getScaledInstance( wid_height,  wid_height, Image.SCALE_DEFAULT)),
        new ImageIcon(new ImageIcon("./img/diamondarrow.png").getImage().getScaledInstance( wid_height,  wid_height, Image.SCALE_DEFAULT)),
        new ImageIcon(new ImageIcon("./img/ironarrow.png").getImage().getScaledInstance( wid_height,  wid_height, Image.SCALE_DEFAULT)),
        new ImageIcon(new ImageIcon("./img/woodarrow.png").getImage().getScaledInstance( wid_height,  wid_height, Image.SCALE_DEFAULT)),
        new ImageIcon(new ImageIcon("./img/diamond.png").getImage().getScaledInstance( wid_height,  wid_height, Image.SCALE_DEFAULT)),
        new ImageIcon(new ImageIcon("./img/iron.png").getImage().getScaledInstance( wid_height,  wid_height, Image.SCALE_DEFAULT)),
        new ImageIcon(new ImageIcon("./img/wood.png").getImage().getScaledInstance( wid_height,  wid_height, Image.SCALE_DEFAULT))
      }; 
     BagPanel(MainFrame mf){
        this.mainframe = mf;
        this.setSize(this.mainframe.getSize());
        this.setLayout(null);
        int position_Y = 210;
        int position_X = 790;
        int rem = -1;
        for(int i=0;i<9;i++)
        {
          if (i == 5){position_Y+=58;rem = 0;}
          else{rem++;} 
          nineButtons[i].setBounds(position_X+(int)62.5*rem,position_Y,40, 40);
          nineButtons[i].setIcon(Images[i]);
         // nineButtons[i].setRolloverIcon(Images[i]);
         // nineButtons[i].setPressedIcon(Images[i]);
          nineButtons[i].setBorder(null);
          nineButtons[i].setContentAreaFilled(false);
          nineButtons[i].addActionListener(this);
          this.add(nineButtons[i]);
        }

      /*  for(int i=0;i<5;i++)
        {
          nineButtons[i].setBounds(position_X+(int)62.5*rem,position_Y,40, 40);
          nineButtons[i].setIcon(Images[i]);
         // nineButtons[i].setRolloverIcon(Images[i]);
         // nineButtons[i].setPressedIcon(Images[i]);
          nineButtons[i].setBorder(null);
          nineButtons[i].setContentAreaFilled(false);
          nineButtons[i].addActionListener(this);
          this.add(nineButtons[i]);
        }*/
    }
    public void actionPerformed(ActionEvent e) {

    }
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.drawImage(bgImage, 0, 0,this.mainframe.getWidth(),this.mainframe.getHeight(),mainframe);
      }
}
