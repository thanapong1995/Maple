import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Map extends JPanel implements KeyListener{
	Timer timer;
	Image m;
	Hero h;
	
	 Map() {
		 
		setLayout(null);
		m=new ImageIcon("src/map.png").getImage();
		h=new Hero();
		timer = new Timer(33, new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				repaint();
				
			}
		} );
		timer.start();
		addKeyListener(this);
	}
	 protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(m, 0, 0, getWidth(), getHeight(), null);
		h.draw(g);
		
	}
	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode() == e.VK_RIGHT){
			h.moveR();
			
		}
		if(e.getKeyCode()== e.VK_LEFT) {
			h.moveL();
			
		}
		if(e.getKeyCode()== e.VK_Z) {
			h.hit();
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

