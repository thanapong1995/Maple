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
	Timer timer3;
	Image i;
	Hero h;
	int n;
	static ArrayList<Monster> monsters;
	static ArrayList<Item> items;
	
	 Map() {
		 
		setLayout(null);
		i = new ImageIcon("src/map.png").getImage();
		h = new Hero();
		n=0;
		monsters = new ArrayList<Monster>();
		items = new ArrayList<Item>();
		
		timer1 = new Timer(2000, new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(n==20) {
					timer1.stop();
				}else {
					monsters.add(new Monster());
					n++;
				}
			}
		});
		timer1.start();

		
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
				}
				repaint();
			}
		} );
		timer2.start();
		timer3 = new Timer(33, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(checkMonsterHit()) {
					try {
						Thread.sleep(1000);
					}catch(Exception e1) {
						System.out.println(e1);
					}
				}
				repaint();
			}
		} );
		timer3.start();
		
		addKeyListener(this);
	}
	 protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(i, 0, 0, getWidth(), getHeight(), null);
		h.draw(g);
		for(int index = 0;index<monsters.size();index++) {
			monsters.get(index).draw(g);
		}
		for(int index = 0;index<items.size();index++) {
			items.get(index).draw(g);
		}
		
	}
	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode() == e.VK_RIGHT){
			checkhp();
			h.moveR();
			
		}
		if(e.getKeyCode()== e.VK_LEFT) {
			checkhp();
			h.moveL();
			
		}
		if(e.getKeyCode()== e.VK_Z) {
			checkHeroHit();
			h.heroHitMonster();
		}
	}
	 void checkHeroHit() {
		for(int index=0;index<monsters.size();index++) {
			if(h.direction==0) {
				if(monsters.get(index).x>h.x-50 && monsters.get(index).x<h.x+20) {
					herohit(monsters.get(index));
				}
			}
			else {
				if(monsters.get(index).x>h.x-20 && monsters.get(index).x<h.x+100) {
					herohit(monsters.get(index));
				}
			}
		}
	}
	
	  boolean checkMonsterHit() {
		for(int index=0;index<monsters.size();index++) {
			if(h.direction==0) {
				if(monsters.get(index).x>h.x-10 && monsters.get(index).x<h.x+20) {
					System.out.println(h.chack);
					monsterHit();
					return true;
				}
			}
			else {
				if(monsters.get(index).x>h.x-20 && monsters.get(index).x<h.x+70) {
					System.out.println(h.chack);
					monsterHit();
					return true;
				}
			}
		}
		return false;
	}
	
	 void checkhp() {
		for(int index=0;index<items.size();index++) {
			if(h.direction==0) {
				if(items.get(index).x>h.x-50 && items.get(index).x<h.x+10) {
					itemhp(items.get(index));
				}
			}
			else {
				if(items.get(index).x>h.x-10 && items.get(index).x<h.x+100) {
					itemhp(items.get(index));
				}
			}
		}
	}
	 void herohit(Monster monster) {
		monster.wasHit();
		
	}
	void itemhp(Item item) {
			item.wasHp();
	}
	  void monsterHit() {
		  if(h.chack==true) {
			  h.monsterHitHero();
			  Hero.hpoint--;
			  System.out.println(Hero.hpoint);
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