import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class BagPanel extends AbstractPanel {
    MainFrame mainframe = null;
    JButton closebutton = new JButton();
    JButton tab1 = new JButton();
    JButton armorButtons[]={
      new JButton(),
      new JButton(),
      new JButton(),
      new JButton(),
      new JButton(),
      new JButton(),
      new JButton(),
      new JButton(),
      new JButton(),
      new JButton(),
      new JButton(),
      new JButton()
    };
    JButton weaponButtons[]={
      new JButton(),
      new JButton(),
      new JButton()
    };
    JButton materialButtons[]={
      new JButton(),
      new JButton(),
      new JButton()
    };
    int wid_height=40;
    //創array去判斷現在有沒有拿到道具 沒有的話就是空圖
    //JButton firstButton = new JButton();
    Image bgImage = new ImageIcon("./img/inventory/bagbg.png").getImage(); 
    ImageIcon armorImages[] = {
        new ImageIcon(new ImageIcon("./img/inventory/diamondarmor.png").getImage().getScaledInstance( wid_height,  wid_height, Image.SCALE_DEFAULT)),
        new ImageIcon(new ImageIcon("./img/inventory/ironarmor.png").getImage().getScaledInstance( wid_height,  wid_height, Image.SCALE_DEFAULT)),
        new ImageIcon(new ImageIcon("./img/inventory/woodarmor.png").getImage().getScaledInstance( wid_height,  wid_height, Image.SCALE_DEFAULT)),
        new ImageIcon(new ImageIcon("./img/inventory/diamondshoes.png").getImage().getScaledInstance( wid_height,  wid_height, Image.SCALE_DEFAULT)),
        new ImageIcon(new ImageIcon("./img/inventory/ironshoes.png").getImage().getScaledInstance( wid_height,  wid_height, Image.SCALE_DEFAULT)),
        new ImageIcon(new ImageIcon("./img/inventory/woodshoes.png").getImage().getScaledInstance( wid_height,  wid_height, Image.SCALE_DEFAULT)),
        new ImageIcon(new ImageIcon("./img/inventory/diamondhalmet.png").getImage().getScaledInstance( wid_height,  wid_height, Image.SCALE_DEFAULT)),
        new ImageIcon(new ImageIcon("./img/inventory/ironhalmet.png").getImage().getScaledInstance( wid_height,  wid_height, Image.SCALE_DEFAULT)),
        new ImageIcon(new ImageIcon("./img/inventory/woodhalmet.png").getImage().getScaledInstance( wid_height,  wid_height, Image.SCALE_DEFAULT)),
        new ImageIcon(new ImageIcon("./img/inventory/diamondpant.png").getImage().getScaledInstance( wid_height,  wid_height, Image.SCALE_DEFAULT)),
        new ImageIcon(new ImageIcon("./img/inventory/ironpant.png").getImage().getScaledInstance( wid_height,  wid_height, Image.SCALE_DEFAULT)),
        new ImageIcon(new ImageIcon("./img/inventory/woodpant.png").getImage().getScaledInstance( wid_height,  wid_height, Image.SCALE_DEFAULT))
      }; 
    /*  ImageIcon weaponImages[] = {
      
      };
      ImageIcon materialImages[] = {
        
      };*/
     BagPanel(MainFrame mf){
        this.mainframe = mf;
        this.setSize(this.mainframe.getSize());
        this.setLayout(null);
        int position_Y = 210;
        int position_X = 750;
        int rem = -1;
        for(int i=0;i<12;i++)
        {
          if (i == 5){position_Y+=58;rem = 0;}
          else if (i == 10){position_Y+=58;rem = 0;}
          else{rem++;} 
          armorButtons[i].setBounds(position_X+(int)62.5*rem,position_Y,40, 40);
          armorButtons[i].setIcon(armorImages[i]);
          armorButtons[i].setBorder(null);
          armorButtons[i].setContentAreaFilled(false);
          armorButtons[i].addActionListener(this);
          this.add(armorButtons[i]);
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

        closebutton = new Button("close",1063,45,83,98,this);

    }
    public void actionPerformed(ActionEvent e) {
      if (e.getSource() == closebutton) {
        this.mainframe.changeScene("menu");
      }
    }
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.drawImage(bgImage, 0, 0,mainframe);
      }
}
