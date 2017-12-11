import java.awt.*;
import javax.swing.*;
public class MainFrame extends JFrame {
	Map m;
	public MainFrame() {
	
	m = new Map();
	add(m);
	setSize(1400,750);
	setFocusable(true);
	setVisible(true);
	setLocationRelativeTo(null);
	setResizable(false); 	//ล็อกตัวขยาย
	setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
}
