import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class Start extends JPanel   {
	Image i ;
	public Start() {
		i = new ImageIcon("src/Start.jpg").getImage();
	}
	 protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(i, 0, 0, getWidth(),getHeight(),null);
	}
}
