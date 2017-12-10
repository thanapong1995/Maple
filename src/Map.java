import javax.swing.*;
import java.awt.*;

public class Map extends JPanel{
	Image m = Toolkit.getDefaultToolkit().getImage("map.png");
	JLabel bplay = new JLabel();
	 Map() {
		setLayout(null);
		repaint();
	}
	public void painComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(m, 0, 0, getWidth(), getHeight(), null);
	}
}

