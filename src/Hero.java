import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Array;
public class Hero {
	Image b[];
	int x,y,width,height;
	int i=1;
	int direction  ;
	public Hero() {
		b = new Image[4];
		b[1] = new ImageIcon("src/B.png").getImage();
		b[2] = new ImageIcon("src/C.png").getImage();
		b[3] = new ImageIcon("src/F.png").getImage();
		b[0] = new ImageIcon("src/A.png").getImage();
		x=50;
		y=500;
		width=100;
		height=120;
	}
	void moveR() {
		direction =1;
		x+=10;
		i++;
		if(i>3 )i=1;
		
	}
	void moveL() {
		direction =0;
		x-=10;
		i++;
		if(i>3)i=1;
	}
	void hit() {
		i=0;
		Timer t=new Timer(200, new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				i=1;
				
			}
		});
		t.setRepeats(false);
		t.start();
	}
	void draw(Graphics g) {
		if(direction == 0) {
			g.drawImage(b[i],x, y, width, height, null);
		}else{
			g.drawImage(b[i],x+width,y, -width, height, null);
		}
	}
	
	
	
		
	
}
