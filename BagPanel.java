import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class BagPanel extends AbstractPanel {
    PlaySounds mouseexited;
    MainFrame mainframe = null;
    JButton closebutton = new JButton();
    JButton chose_armor_button = new JButton();
    JButton chose_weapon_button = new JButton();
    JButton chose_material_button = new JButton();
    JButton armorButtons[]={new JButton(),new JButton(),new JButton(),new JButton(),new JButton(),new JButton(),new JButton(),new JButton(),new JButton(),new JButton(),new JButton(),new JButton()};
    JButton weaponButtons[]={new JButton(),new JButton(),new JButton()};
    JButton materialButtons[]={new JButton(),new JButton(),new JButton()};
    JButton use=new JButton();
    JButton upgrade=new JButton();
    int wid_height=40;
    // ImageIcon use_Image=new ImageIcon(new ImageIcon("./img/btn/use.png").getImage().getScaledInstance( wid_height,  wid_height, Image.SCALE_DEFAULT));
    // ImageIcon upgrade_Image=new ImageIcon(new ImageIcon("./img/btn/upgrade.png").getImage().getScaledInstance( wid_height,  wid_height, Image.SCALE_DEFAULT));

    

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

        use.setSize(80,40);
        use.setLocation(975, 425);
        use.setBorder(null);
        use.setContentAreaFilled(false);
        use.addActionListener(this);
        this.add(use);
        upgrade.setSize(80, 40);
        upgrade.setLocation(975, 470);
        upgrade.setBorder(null);
        upgrade.setContentAreaFilled(false);
        upgrade.addActionListener(this);
        this.add(upgrade);

        int position_Y = 205;
        int position_X = 745;
        int rem = -1;
        for(int i=0;i<12;i++)
        {
          if (i == 5){position_Y+=62;rem = 0;}
          else if (i == 10){position_Y+=62;rem = 0;}
          else{rem++;} 
          armorButtons[i]=new SetButton(armorImages[i], position_X+(int)65*rem, position_Y, wid_height,wid_height, this);
          armorButtons[i].setVisible(false);
        }
        
         position_Y = 205;
         position_X = 745;
         rem = -1;
        for(int i=0;i<3;i++)
        {
          rem++;
          weaponButtons[i]=new SetButton(weaponImages[i], position_X+(int)65*rem, position_Y, wid_height,wid_height, this);
          weaponButtons[i].setVisible(false);
        }  
        //測試用陣列 之後要刪掉
        check_weapon[0]=1;
        check_weapon[1]=1;
        check_material[2]=1;
        check_material[0]=1;
        check_armor[1]=1;
        check_armor[4]=1;
        check_armor[3]=1;
        check_armor[10]=1;
        resetButton_position(weaponButtons,3,check_weapon);
        
        position_Y = 205;
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

        weaponButtons[2].setLocation(747,605);
        weaponButtons[2].setVisible(true);
        armorButtons[2].setLocation(747+65,605);
        armorButtons[2].setVisible(true);
        armorButtons[5].setLocation(747+130,605);
        armorButtons[5].setVisible(true);
        armorButtons[8].setLocation(747+195,605);
        armorButtons[8].setVisible(true);
        armorButtons[11].setLocation(747+260,605);
        armorButtons[11].setVisible(true);
        


    }
    //int 素材數量  n
    int  isWeapon=3;
    int index=0;
    public void actionPerformed(ActionEvent e) {
      for(int i=0;i<3;i++)
      {
        if(e.getSource() == weaponButtons[i])
        {
          isWeapon=1;
          index=i;
        }
        
      }
      for(int i=0;i<12;i++)
      {
        if(e.getSource() == armorButtons[i])
        {
          isWeapon=0;
          index=i;
        }
      }
      
      if(e.getSource() == use) 
      {
        if(isWeapon==1)change_weapon(index);
        else if(isWeapon==0) change_armor(index);
      }

      //按下右上叉叉
      if (e.getSource() == closebutton) {
        this.mainframe.changeScene("menu");
      }
      
      //按了武器欄的按鈕
      if (e.getSource() == chose_weapon_button) {
        for(JButton b:armorButtons){
          if(b.getY()<600)b.setVisible(false);
        }
        for(JButton b:materialButtons){
          if(b.getY()<600)b.setVisible(false);
        }
        
        resetButton_position(weaponButtons,3,check_weapon);

        chose_weapon_button.setIcon(chose_weapon_Image_p);
        chose_armor_button.setIcon(chose_armor_Image);
        chose_material_button.setIcon(chose_material_Image);
       
      }
      //按下素材欄按鈕
      if (e.getSource() == chose_material_button) {
        for(JButton b:armorButtons){
          if(b.getY()<600)b.setVisible(false);
        }

        resetButton_position(materialButtons,3,check_material);

        for(JButton b:weaponButtons){
          if(b.getY()<600)b.setVisible(false);
        }
        chose_weapon_button.setIcon(chose_weapon_Image);
        chose_armor_button.setIcon(chose_armor_Image);
        chose_material_button.setIcon(chose_material_Image_p);
        
        
      }

      //按下裝備欄按鈕
      if (e.getSource() == chose_armor_button) {
        resetButton_position(armorButtons,12,check_armor);

        for(JButton b:materialButtons){
          if(b.getY()<600)b.setVisible(false);
        }
        for(JButton b:weaponButtons){
          if(b.getY()<600) b.setVisible(false);
        }
        chose_weapon_button.setIcon(chose_weapon_Image);
        chose_armor_button.setIcon(chose_armor_Image_p);
        chose_material_button.setIcon(chose_material_Image); 

        chose_weapon_button.addMouseListener(new MouseAdapter(){
         public void mousePressed(MouseEvent me) {
          mouseexited = new PlaySounds("./music/click.wav");
          mouseexited.start();
       }
      });
      chose_armor_button.addMouseListener(new MouseAdapter(){
        public void mousePressed(MouseEvent me) {
         mouseexited = new PlaySounds("./music/click.wav");
         mouseexited.start();
      }
     });
     chose_material_button.addMouseListener(new MouseAdapter(){
      public void mousePressed(MouseEvent me) {
       mouseexited = new PlaySounds("./music/click.wav");
       mouseexited.start();
    }
   });

        
      }
    }
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.drawImage(bgImage, 0, 0,mainframe);
      }

      public void resetButton_position(JButton[] b,int n,int[] check)
      {
        int i=0;
        int position_Y = 205;
        int position_X = 745;
        int rem = -1;
        for(int j=0;j<n;j++)
        {
          if(check[j]!=0)
          {
            if (i == 5){position_Y+=62;rem = 0;}
            else if (i == 10){position_Y+=62;rem = 0;}
            else{rem++;} 
            // int y=b[j].getY();
            // System.out.println(y);
            b[j].setLocation(position_X+(int)65*rem, position_Y); 
            b[j].setVisible(true);
            i++;
            
            
          } 
          else if(b[j].getY()<600) b[j].setVisible(false);
        }
      }

      public void change_weapon(int n)
      {
        int x=weaponButtons[n].getX();
        int y=weaponButtons[n].getY();
        int i=0;
        for(JButton b:weaponButtons)
        {
          if(b.getY()==605)
          {
            b.setLocation(x,y);
            check_weapon[i] = 1;
          }
          i++;
        }
        weaponButtons[n].setLocation(747, 605);
        check_weapon[n]=0;
      }

      
      public void change_armor(int n)
      {

        int x=armorButtons[n].getX();
        int y=armorButtons[n].getY();
        int i=0;
       
        for(JButton b:armorButtons)
        {
          if(b.getX()==812&&n<=2)
          {
            b.setLocation(x,y);
            check_armor[i] = 1;
            armorButtons[n].setLocation(747+65, 605);
            break;
          }
          else if(b.getX()==877&&n<=5)
          {
            b.setLocation(x,y);
            check_armor[i] = 1;
            armorButtons[n].setLocation(747+130, 605);
            break;
          }
          else if(b.getX()==942&&n<=8)
          {
            b.setLocation(x,y);
            check_armor[i] = 1;
            armorButtons[n].setLocation(747+195, 605);
            break;
          }
          else if(b.getX()==1007&&n<=11)
          {
            b.setLocation(x,y);
            check_armor[i] = 1;
            armorButtons[n].setLocation(747+260, 605);
            break;
          }
          i++;
        }
        check_armor[n]=0;
      }
}
