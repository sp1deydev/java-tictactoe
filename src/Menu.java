import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener; 

import javax.swing.JFrame;
import javax.swing.JPanel;


public class Menu extends JFrame {
	MenuDisplay menu = new MenuDisplay();
	Menu() {
		add(menu);
		setTitle("Menu - Tic Tac Toe");
		setResizable(false);
		setSize(400,380);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		addMouseListener(new HomeListener());
	}
	public class HomeListener implements MouseListener {
		public int location = -1, a = 0, b = 0;
		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub\
			a = e.getX();
			b = e.getY();
			System.out.println("Clicked => x: "+ a + " y: "+b);
			if(a>150 && a<246 && b>138 && b<157) {
				System.out.println("New Game");
				if(Main.modePlay) {
					Main.playZone = new Play();
					Main.menu.dispose();
				} else {
					Main.playZonePvE = new PlayPvE();
					Main.menu.dispose();
				}
			}
			if(a>144 && a<272 && b>178 && b<196) {
				System.out.println("Mode Play");
				Main.modePlay = !Main.modePlay;
			}
			if(a>142 && a<262 && b>215 && b<238) {
				System.out.println("How to play");
				Main.howToPlay = new HowToPlay();
				Main.menu.dispose();
			}
			if(a>180 && a<223 && b>260 && b<276) {
				System.out.println("About");
				Main.about = new About();
				Main.menu.dispose();
			}
			if(a>175 && a<226 && b>300 && b<318) {
				System.out.println("Quit");
				System.exit(0);
			}
			
			
		}

		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		
	}
}
