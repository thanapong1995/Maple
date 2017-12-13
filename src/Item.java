import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.Timer;

public class Item extends character{
	Image i;
	int r;
	
	public Item(int x,int y) {
		i = new ImageIcon("src/Ba.png").getImage();
		this.x=x;
		this.y=y-15;
		width = 100;
		height = 100;
		
	}
	
	int getX() {
		return this.x;
	}
	
	void draw(Graphics g) {
		if(direction == 0) {
			g.drawImage(i,x, y, width, height, null);
		}else{
			g.drawImage(i,x+width,y, -width, height, null);
		}
	}
	
	 void wasHp() {
			if(Hero.hpoint<10) {
				Hero.hpoint++;
				System.out.println(Hero.hpoint);
				Map.items.remove(this);
			}
		}
}
