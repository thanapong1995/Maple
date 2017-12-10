import javax.swing.*;
import java.awt.*;

public class Map extends JPanel{
	Image m = Toolkit.getDefaultToolkit().getImage("map.png");
//	JLabel bplay = new JLabel();

	 Map() {
//			setLayout(null);
//			bplay.setBounds(450,175, 195, 80);
//			this.add(bplay);
//			repaint();
	}
	 protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(m, 0, 0, getWidth(), getHeight(), this);
	 }
}