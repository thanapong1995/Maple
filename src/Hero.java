import javax.swing.*;
import java.awt.*;
import java.lang.reflect.Array;
public class Hero {
	Image b[];
	int x,y,width,height;
	int i=1 ;
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
		x+=10;
		i++;
		if(i>3 )i=1;
	}
	void moveL() {
		x-=10;
		i++;
		if(i>3)i=1;
	}
	void hit() {
		i=0;
	}
	void draw(Graphics g) {
		g.drawImage(b[i], x, y, width, height, null);
		
	}
	
	
	
		
	
}
