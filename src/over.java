import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class over  {
	Image i ;
	public over() {
		i = new ImageIcon("src/gameover.jpg").getImage();
	}
	void draw(Graphics g) {
		g.drawImage(i, 0, 0, getWidth(), getHeight(),null);
	}
}
