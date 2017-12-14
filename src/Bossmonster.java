import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.Timer;

public class Bossmonster extends character{
	int r;
	double random;
	Timer t;
	Image boss[];
	 public Bossmonster() {
		hpoint = 5;
		r =  (Math.random() < 0.5) ? 0:MainFrame.width;//เขียนแบบสั้น
		boss = new Image[2];
		boss[0] = new ImageIcon("src/boss1.png").getImage();
		boss[1] = new ImageIcon("src/boss2.png").getImage();
	
		this.x=r;
		y = 375;
		width = 250;
		height = 250;
		
	}
	 void moveR() {
			direction =1;
			x+=2;
			
		}
		void moveL() {
			direction =0;
			x-=2;
		}
		int getX() {
			return this.x;
		}
	 void draw(Graphics g) {
			if(direction == 0) {
				g.drawImage(boss[i],x, y, width, height, null);
			}else{
				g.drawImage(boss[i],x+width,y, -width, height, null);
			}
		}
	 
	 void wasHit() {//มอนเตอร์โดนตี
		 i=1;
			t=new Timer(200, new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					i=0;
					
				}
			});
			t.setRepeats(false);
			t.start();
			hpoint--;
		}
}
