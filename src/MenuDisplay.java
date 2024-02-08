import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JPanel;

public class MenuDisplay extends JPanel {
	int space = 40;
	//COLOR
	Color black = new Color(0,0,0);
	Color white = new Color(0xf7f7f7);
	
	//CONSTRUCTOR
	MenuDisplay() {
		setBackground(black);
	}
	public void paintComponent(Graphics page) {
		super.paintComponent(page);
		displayInfor(page);
	}
	public void displayInfor(Graphics page) {
		if(Main.modePlay) {
			page.setFont(new Font(null,Font.BOLD, 45));
			page.setColor(white);
			page.drawString("TIC TAC TOE", 55, 50);
			page.setFont(new Font(null,Font.ROMAN_BASELINE, 16));
			page.drawString("NEW GAME", 153, 125);
			page.drawString("MODE PLAY: PvP", 132, 125+space);
			page.drawString("HOW TO PLAY", 140, 125+2*space);
			page.drawString("ABOUT", 168, 125+3*space);
			page.drawString("QUIT", 175, 125+4*space);
		}
		else {
			page.setFont(new Font(null,Font.BOLD, 45));
			page.setColor(white);
			page.drawString("TIC TAC TOE", 55, 50);
			page.setFont(new Font(null,Font.ROMAN_BASELINE, 16));
			page.drawString("NEW GAME", 153, 125);
			page.drawString("MODE PLAY: PvE", 132, 125+space);
			page.drawString("HOW TO PLAY", 140, 125+2*space);
			page.drawString("ABOUT", 168, 125+3*space);
			page.drawString("QUIT", 175, 125+4*space);
		}
		repaint();
	}
}
