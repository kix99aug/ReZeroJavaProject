import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class BagPanel extends AbstractPanel {
    MainFrame mainframe = null;
    JButton closebutton = new JButton();
    JButton chose_armor_button = new JButton();
    JButton chose_weapon_button = new JButton();
    JButton chose_material_button = new JButton();
    JButton armorButtons[]={new JButton(),new JButton(),new JButton(),new JButton(),new JButton(),new JButton(),new JButton(),new JButton(),new JButton(),new JButton(),new JButton(),new JButton()};
    JButton weaponButtons[]={new JButton(),new JButton(),new JButton()};
    JButton materialButtons[]={new JButton(),new JButton(),new JButton()};
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
     ImageIcon weaponImages[] = {
        new ImageIcon(new ImageIcon("./img/inventory/diamondarrow.png").getImage().getScaledInstance( wid_height,  wid_height, Image.SCALE_DEFAULT)),
        new ImageIcon(new ImageIcon("./img/inventory/ironarrow.png").getImage().getScaledInstance( wid_height,  wid_height, Image.SCALE_DEFAULT)),
        new ImageIcon(new ImageIcon("./img/inventory/woodarrow.png").getImage().getScaledInstance( wid_height,  wid_height, Image.SCALE_DEFAULT))
      };
      ImageIcon materialImages[] = {
        new ImageIcon(new ImageIcon("./img/inventory/diamond.png").getImage().getScaledInstance( wid_height,  wid_height, Image.SCALE_DEFAULT)),
        new ImageIcon(new ImageIcon("./img/inventory/iron.png").getImage().getScaledInstance( wid_height,  wid_height, Image.SCALE_DEFAULT)),
        new ImageIcon(new ImageIcon("./img/inventory/wood.png").getImage().getScaledInstance( wid_height,  wid_height, Image.SCALE_DEFAULT))
      };

      ImageIcon chose_armor_Image_p =new ImageIcon(new ImageIcon("./img/btn/ActiveB_p.png").getImage().getScaledInstance(64, 70, Image.SCALE_FAST));
      ImageIcon chose_weapon_Image_p =new ImageIcon(new ImageIcon("./img/btn/ActiveA_p.png").getImage().getScaledInstance(64, 70, Image.SCALE_FAST));
      ImageIcon chose_material_Image_p =new ImageIcon(new ImageIcon("./img/btn/ActiveC_p.png").getImage().getScaledInstance(64, 70, Image.SCALE_FAST));
      ImageIcon chose_weapon_Image =new ImageIcon(new ImageIcon("./img/btn/ActiveA.png").getImage().getScaledInstance(64, 70, Image.SCALE_FAST));
      ImageIcon chose_material_Image =new ImageIcon(new ImageIcon("./img/btn/ActiveC.png").getImage().getScaledInstance(64, 70, Image.SCALE_FAST));
      ImageIcon chose_armor_Image =new ImageIcon(new ImageIcon("./img/btn/ActiveB.png").getImage().getScaledInstance(64, 70, Image.SCALE_FAST));

      int[] check_armor={0,0,0,0,0,0,0,0,0,0,0,0};
      int[] check_weapon={0,0,0};
      int[] check_material={0,0,0};

     BagPanel(MainFrame mf){
        this.mainframe = mf;
        this.setSize(this.mainframe.getSize());
        this.setLayout(null);
        int position_Y = 210;
        int position_X = 745;
        int rem = -1;
        for(int i=0;i<12;i++)
        {
          if (i == 5){position_Y+=58;rem = 0;}
          else if (i == 10){position_Y+=58;rem = 0;}
          else{rem++;} 
          armorButtons[i]=new SetButton(armorImages[i], position_X+(int)65*rem, position_Y, wid_height,wid_height, this);
          armorButtons[i].setVisible(false);
        }  
         position_Y = 210;
         position_X = 745;
         rem = -1;
        for(int i=0;i<3;i++)
        {
          rem++;
          weaponButtons[i]=new SetButton(weaponImages[i], position_X+(int)65*rem, position_Y, wid_height,wid_height, this);
          weaponButtons[i].setVisible(false);
        }  
        check_weapon[1]=1;
        resetButton_position(weaponButtons,3,check_weapon);
        
        position_Y = 210;
        position_X = 745;
        rem = -1;
       for(int i=0;i<3;i++)
       {
         rem++;
         materialButtons[i]=new SetButton(materialImages[i], position_X+(int)65*rem, position_Y, wid_height,wid_height, this);
         materialButtons[i].setVisible(false);
       }  
        //以下建立圖標
        chose_armor_button=new SetButton(chose_armor_Image,1085,248,64,70,this);
        chose_weapon_button=new SetButton(chose_weapon_Image_p,1085,179, 64,70,this);
        chose_material_button=new SetButton(chose_material_Image,1085,315, 64,70,this);
        //右上叉叉
        closebutton = new Button("close",1063,45,83,98,this);

    }
    public void actionPerformed(ActionEvent e) {
      //按下右上叉叉
      if (e.getSource() == closebutton) {
        this.mainframe.changeScene("menu");
      }
      
      //按了武器欄的按鈕
      if (e.getSource() == chose_weapon_button) {
        for(JButton b:armorButtons){
          b.setVisible(false);
        }
        for(JButton b:materialButtons){
          b.setVisible(false);
        }
        check_weapon[1]=1;
        resetButton_position(weaponButtons,3,check_weapon);
          // int position_Y = 210;
          // int position_X = 745;
          // int rem = -1;

          // for(int j=0;j<3;j++)
          // {
          //   if(check_weapon[j]!=0)
          //   {
          //     rem++;
          //     weaponButtons[j].setLocation(position_X+(int)65*rem, position_Y);
          //     weaponButtons[j].setVisible(true);
          //   } 
          //   else weaponButtons[j].setVisible(false);
          // }
        chose_weapon_button.setIcon(chose_weapon_Image_p);
        chose_armor_button.setIcon(chose_armor_Image);
        chose_material_button.setIcon(chose_material_Image);
       
      }
      //按下素材欄按鈕
      if (e.getSource() == chose_material_button) {
        for(JButton b:armorButtons){
          b.setVisible(false);
        }
        check_material[2]=1;
        check_material[0]=1;
        resetButton_position(materialButtons,3,check_material);

          // int position_Y = 210;
          // int position_X = 745;
          // int rem = -1;
          // for(int j=0;j<3;j++)
          // {
          //   if(check_material[j]!=0)
          //   {
          //     rem++;
          //     materialButtons[j].setLocation(position_X+(int)65*rem, position_Y);
          //     materialButtons[j].setVisible(true);
          //   } 
          //   else materialButtons[j].setVisible(false);
          // }

        for(JButton b:weaponButtons){
          b.setVisible(false);
        }
        chose_weapon_button.setIcon(chose_weapon_Image);
        chose_armor_button.setIcon(chose_armor_Image);
        chose_material_button.setIcon(chose_material_Image_p);     
      }

      //按下裝備欄按鈕
      if (e.getSource() == chose_armor_button) {
        int i=0;
        check_armor[1]=1;
        check_armor[5]=1;
        check_armor[11]=1;

        resetButton_position(armorButtons,12,check_armor);
        // int position_Y = 210;
        // int position_X = 745;
        // int rem = -1;
        // for(int j=0;j<12;j++)
        // {
        //   if(check_armor[j]!=0)
        //   {
        //     if (j == 5){position_Y+=58;rem = 0;}
        //     else if (j == 10){position_Y+=58;rem = 0;}
        //     else{rem++;} 
        //     armorButtons[j].setLocation(position_X+(int)65*rem, position_Y);
        //     armorButtons[j].setVisible(true);
        //   } 
        //   else armorButtons[j].setVisible(false);
        // }

        for(JButton b:materialButtons){
          b.setVisible(false);
        }
        for(JButton b:weaponButtons){
          b.setVisible(false);
        }
        chose_weapon_button.setIcon(chose_weapon_Image);
        chose_armor_button.setIcon(chose_armor_Image_p);
        chose_material_button.setIcon(chose_material_Image);     
      }
    }
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.drawImage(bgImage, 0, 0,mainframe);
      }

      public void resetButton_position(JButton[] b,int n,int[] check)
      {
        int i=0;
        int position_Y = 210;
        int position_X = 745;
        int rem = -1;
        for(int j=0;j<n;j++)
        {
          if(check[j]!=0)
          {
            if (j == 5){position_Y+=58;rem = 0;}
            else if (j == 10){position_Y+=58;rem = 0;}
            else{rem++;} 
            b[j].setLocation(position_X+(int)65*rem, position_Y);
            b[j].setVisible(true);
          } 
          else b[j].setVisible(false);
        }
      }

    
}
