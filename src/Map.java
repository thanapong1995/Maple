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
	Image start;
	Hero h;
	Over o;
	Bossmonster boss;
	int n;
	int s;
	static ArrayList<Monster> monsters;
	static ArrayList<Item> items;
	
	 Map() {
		 
		setLayout(null);
		i = new ImageIcon("src/map.png").getImage();
		h = new Hero();
		o = new Over();
		boss = new Bossmonster();
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
				checkMonsterHit();
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
//				if(h.getX()-220>boss.getX()) {
//					boss.moveR();
//				}
//				else if(h.getX()+60<boss.getX()){
//					boss.moveL();
//				}
				
				repaint();
				
				if(h.hpoint<=0 || boss.hpoint<=0) {
					timer2.stop();
					timer1.stop();
					//for(int index = 0;index<monsters.size();index++) {
						//monsters.get(index).stopThread();
					//}
				}
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
		for(int index = 0;index<items.size();index++) {
			items.get(index).draw(g);
		}
//		if(n==20) {
//			boss.draw(g);
//		}
		if(h.hpoint<=0 || boss.hpoint<=0) {
			
			o.draw(g);
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
	 void checkHeroHit() {//àªç¤ÎÕâÃèµÕÁÍ¹â´¹äËÁ
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
//		if(h.direction==0) {
//			if(boss.getX()>h.x-220 && boss.getX()<h.x+20) {
//				
//			}
//		}else {if(boss.getX()>h.x-20 && boss.getX()<h.x+100) {
//			
//		}
//			
//		}
	}
	
	  void checkMonsterHit() {//àªç¤ÁÍ¹àµÍÃìà´Ô¹¼èÒ¹
		for(int index=0;index<monsters.size();index++) {
			if(h.direction==0) {
				if(monsters.get(index).x>h.x-10 && monsters.get(index).x<h.x+20) {
					monsterHit();
					
				}
			}
			else {
				if(monsters.get(index).x>h.x-20 && monsters.get(index).x<h.x+70) {
					monsterHit();
				}
			}
		}
	}
	
	 void checkhp() {//àªç¤à¡çºHP
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
			  h.monsterHitHero();
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