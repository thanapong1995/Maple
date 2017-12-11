import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class Map extends JPanel implements KeyListener{
	Timer timer;
	Image i;
	Hero h;
	static ArrayList<Monster> monsters;
	
	 Map() {
		 
		setLayout(null);
		i = new ImageIcon("src/map.png").getImage();
		h = new Hero();
		monsters = new ArrayList<Monster>();
		for(int index = 0;index<3;index++) {
			monsters.add(new Monster());
		}
		timer = new Timer(33, new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				for(int index = 0;index<monsters.size();index++) {
				Monster m = monsters.get(index);
					if(h.getX()>m.getX()) {
					m.moveR();
				}else {
					m.moveL();
				}
			}
					
				repaint();
				
			}
		} );
		timer.start();
		addKeyListener(this);
	}
	 protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(i, 0, 0, getWidth(), getHeight(), null);
		h.draw(g);
		for(int index = 0;index<monsters.size();index++) {
			monsters.get(index).draw(g);
		}
		
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
			checkHit();
			h.hit();
		}
	}
	private void checkHit() {
		for(int index=0;index<monsters.size();index++) {
			if(h.direction==0) {
				if(monsters.get(index).x>h.x-50 && monsters.get(index).x<h.x+20) {
					hitting(monsters.get(index));
				}
			}
			else {
				if(monsters.get(index).x>h.x-20 && monsters.get(index).x<h.x+100) {
					hitting(monsters.get(index));
				}
			}
		}
	}
	private void hitting(Monster monster) {
		monster.wasHit();
		
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

