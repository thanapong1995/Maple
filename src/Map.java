import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class Map extends JPanel implements KeyListener{
	Timer timer1;
	Timer timer2;
	Image i;
	Hero h;
	int n;
	static ArrayList<Monster> monsters;
	
	 Map() {
		 
		setLayout(null);
		i = new ImageIcon("src/map.png").getImage();
		h = new Hero();
		n=0;
		monsters = new ArrayList<Monster>();
		
		timer1 = new Timer(2000, new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(n==20) {
					timer1.stop();
				}else {
					monsters.add(new Monster());
					n++;
				}
				repaint();
			}
		});
		timer1.start();
		
//		for(int index = 0;index<10;index++) {
//			monsters.add(new Monster());
//		}
		timer2 = new Timer(33, new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				for(int index = 0;index<monsters.size();index++) {
				Monster m = monsters.get(index);
					if(h.getX()>m.getX()) {
					m.moveR();
				}else if(h.getX()+55<m.getX()){
					m.moveL();
				}
					;
			}
					
				repaint();
				
			}
		} );
		timer2.start();
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
			h.hitmonster();
		}
	}
	private void checkHit() {
		for(int index=0;index<monsters.size();index++) {
			if(h.direction==0) {
				if(monsters.get(index).x>h.x-50 && monsters.get(index).x<h.x+10) {
					hitting(monsters.get(index));
				}
			}
			else {
				if(monsters.get(index).x>h.x-10 && monsters.get(index).x<h.x+100) {
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

