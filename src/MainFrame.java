import javax.swing.*;
public class MainFrame extends JFrame {
	Map m;
	public MainFrame() {
	setSize(1400,750);
	m = new Map();
	add(m);	
	setFocusable(true);
	setVisible(true);
	setResizable(false); 	//ล็อกตัวขยาย
	setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
}