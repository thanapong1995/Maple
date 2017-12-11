import java.awt.*;
import javax.swing.*;
public class MainFrame extends JFrame {
	Map i;
	static int width = 1400;
	public MainFrame() {
	
	i = new Map();

	add(i);
	setSize(width,750);
//	setFocusable(true);
	setVisible(true);
	setLocationRelativeTo(null);
	setResizable(false); 	//ล็อกตัวขยาย
	setDefaultCloseOperation(EXIT_ON_CLOSE);
	i.requestFocusInWindow();//โฟกัสจอ
	}
	
}
