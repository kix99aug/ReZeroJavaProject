import java.awt.Image;
import java.awt.Rectangle;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class BAG_character extends Thread{
    Image img ;
    Image[] idle_imgs = {new ImageIcon("img/Character/adventurer-idle-00.png").getImage(),
    new ImageIcon("img/Character/adventurer-idle-01.png").getImage(),
    new ImageIcon("img/Character/adventurer-idle-02.png").getImage()};
    public BagPanel bp;
    BAG_character(BagPanel bp){
        this.bp = bp;
    }
public void run(){
        for(int i = 0;true;i=(i+1)%3){
            img=idle_imgs[i];
            bp.repaint();
                try {
                    this.sleep(200);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
        }
    }
}