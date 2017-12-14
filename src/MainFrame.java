import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.*;
public class MainFrame extends JFrame implements KeyListener {
	Map i;
	Start start;
	int s;
	static int width = 1400;
	public MainFrame() {
		start = new Start();
		add(start);
		setSize(width,750);
		setVisible(true);
		setLocationRelativeTo(null);
		setResizable(false); 	//ÅçÍ¡µÑÇ¢ÂÒÂ
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		requestFocusInWindow();//â¿¡ÑÊ¨Í
		addKeyListener(this);
		
	}
	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode() == e.VK_SPACE) {
			remove(start);
			i = new Map();
			add(i);
			setVisible(true);
			//i.validate();
			//i.repaint();
			i.requestFocusInWindow();//â¿¡ÑÊ¨Í	
		}
		
	}
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}
