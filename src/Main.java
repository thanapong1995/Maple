import java.awt.*;
import javax.swing.*;
public class Main extends JFrame{
	
	public Main() {
		setTitle("Maple");
		setSize(1400, 750);
	}
	
	public static void main(String[] args) {
		JFrame f = new Main();
		f.setSize(1400, 750);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
	}

}
