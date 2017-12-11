import javax.swing.*;
import java.awt.*;

public class Map extends JPanel{

	Image m;
	JLabel bplay = new JLabel();
	 Map() {
		setLayout(null);
		m=new ImageIcon("src/map.png").getImage();
		
		
	}
	 protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(m, 0, 0, getWidth(), getHeight(), null);
	}
}

