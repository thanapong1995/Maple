import javax.swing.*;
import java.awt.*;
public class Hero {
	Image b;
	int x,y,width,height;
	public Hero() {
		b = new ImageIcon("src/BBB.png").getImage();
		x=50;
		y=500;
		width=100;
		height=120;
	}
	
	void draw(Graphics g) {
		g.drawImage(b, x, y, width, height, null);
		
	}
	
	
	
		
	
}
