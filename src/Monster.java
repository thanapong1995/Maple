import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.Timer;

public class Monster extends character{
	Image m2[];
	int r;
	double random;
	Timer t;

	 public Monster() {
		hpoint = 2;
		r =  (Math.random() < 0.5) ? 0:MainFrame.width;//��¹Ẻ���
		m2 = new Image[2];
		m2[0] = new ImageIcon("src/M2.png").getImage();
		m2[1] = new ImageIcon("src/M22.png").getImage();
		
		this.x=r;
		y = 570;
		width = 50;
		height = 35;
		
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
				g.drawImage(m2[i],x, y, width, height, null);
			}else{
				g.drawImage(m2[i],x+width,y, -width, height, null);
			}
		}

	 void wasHit() {//�͹����ⴹ��
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
			if(hpoint<=0) {
				Map.monsters.remove(this);
				random = Math.random()*10;
			if (random > 7)
				Map.items.add(new Item(this.x,this.y));
				
			}
		}
}
