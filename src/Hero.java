import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Array;

public class Hero extends character{
	Image b[];
	static int hpoint;
	static boolean chack;
	Timer t1;
	Timer t2;
	public Hero() {

		hpoint =10;
		b = new Image[5];
		b[0] = new ImageIcon("src/B.png").getImage();
		b[1] = new ImageIcon("src/C.png").getImage();
		b[2] = new ImageIcon("src/F.png").getImage();
		b[3] = new ImageIcon("src/hitmonster.png").getImage();//√Ÿªµ’
		b[4] = new ImageIcon("src/hithero.png").getImage();//√Ÿª‚¥π¡Õπµ’
	}
	
	void moveR() {
		direction =1;
		x+=10;
		i++;
		if(i>2 )i=0;
		
	}
	
	int getX() {
		return this.x;
	}
	
	void moveL() {
		direction =0;
		x-=10;
		i++;
		if(i>2)i=0;
	}
	
	void heroHitMonster() {//Œ’‚√Ëµ’
		i=3;
		t1=new Timer(200, new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				i=0;
				
			}
		});
		t1.setRepeats(false);
		t1.start();
	}
	
	void monsterHitHero() {//¡Õπ‡µÕ√Ïµ’ Œ’‚√Ë
		i=4;
		chack = false;		
		t2=new Timer(200, new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				i=0;
				chack = true;
				hpoint--;
			}
		});
		t2.setRepeats(false);
		t2.start();
		
		System.out.println(hpoint);
	}
	
	
	void draw(Graphics g) {
		if(direction == 0) {
			g.drawImage(b[i],x, y, width, height, null);
		}else{
			g.drawImage(b[i],x+width,y, -width, height, null);
		}
	}
}
