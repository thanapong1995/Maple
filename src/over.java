import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class Over   {
	Image i ;
	public Over() {
		i = new ImageIcon("src/gameover.jpg").getImage();
	}
	void draw(Graphics g) {
		g.drawImage(i, 0, 0, 1400, 750,null);
	}
}
