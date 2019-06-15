import java.awt.Image;
import java.awt.Rectangle;

import javax.swing.ImageIcon;

public class Character extends Thread{
	
	public GamePanel gp;
	
	public boolean jumpFlag=true;
	
	public int x=0,y=358;
	public int xspeed=5,yspeed=1;
	public int width=30,height=32;
	public Image img = new ImageIcon("image/mari1.png").getImage();
	
	public boolean left=false,right=false,down=false,up=false;
	
	public String Dir_Up="Up",Dir_Left="Left",Dir_Right="Right",Dir_Down="Down";
	
	
	public Character ( GamePanel gp) {
		this.gp=gp;
	}
	
	public void run(){
		while(true){
			if(left){
				if(hit(Dir_Left)){
					this.xspeed=0;
				}
				
				if(this.x>=0){
					this.x-=this.xspeed;
					this.img=new ImageIcon("image/mari_left.gif").getImage();
				}
				
				this.xspeed=5;
			}
			
			if(right){
				
				if(hit(Dir_Right)){
					this.xspeed=0;
				}
				if(this.x<400){
					this.x+=this.xspeed;
					this.img=new ImageIcon("image/mari_right.gif").getImage();
				}
				
				if(this.x>=400){
					gp.bgx-=this.xspeed;
					this.img=new ImageIcon("image/mari_right.gif").getImage();
				}
				this.xspeed=5;
			}
			
			if(up){

				if(jumpFlag && !isGravity){
					jumpFlag=false;
					new Thread(){
						public void run(){
							jump();
							jumpFlag=true;
						}
					}.start();
				}
			}
			
			try {
				this.sleep(20);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	
	public void jump(){
		int jumpHeigh=0;
		for (int i = 0; i < 150; i++) {
			this.y-=this.yspeed;
			jumpHeigh++;
			if(hit(Dir_Up)){
				break;
			}
			try {
				Thread.sleep(5);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		for (int i = 0; i <jumpHeigh; i++) {
			this.y+=this.yspeed;
			if(hit(Dir_Down)){
				this.yspeed=0;
			}
			try {
				Thread.sleep(5);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			
		}
		this.yspeed=1;
	}
	
	//�����ײ
	public boolean hit(String dir){
		Rectangle myrect = new Rectangle(this.x,this.y,this.width,this.height);
		Rectangle rect =null;		
		return false;
	}
	
	//����Ƿ�����
	public boolean isGravity=false;
	
	public void Gravity(){
			new Thread(){
				public void run(){
					
					while(true){
						try {
							sleep(10);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
						
						if(!jumpFlag){
							
						}
						
						while(true){
							if(!jumpFlag){
								break;
							}
							
							if(hit(Dir_Down)){
								break;
							}
							
							if(y>=358){
								isGravity=false;
							}
							else{
								isGravity=true;
								y+=yspeed;
							}
							
							try {
								sleep(10);
							} catch (InterruptedException e) {
								e.printStackTrace();
							}
					}
				}
				}
			}.start();
	
	}
}
