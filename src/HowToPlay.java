import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class HowToPlay extends JFrame implements ActionListener {
	//COLOR 
	Color black = new Color(0,0,0);
	Color white = new Color(0xf7f7f7);
	String text = new String();
	JPanel howToPlay = new JPanel();
	JLabel how = new JLabel();
	JButton backToHome = new JButton("Back To Home");
	HowToPlay() {
		backToHome.setForeground(white);
		backToHome.setRolloverEnabled(false);
		backToHome.setBackground(black);
		backToHome.setFocusable(false);
		text ="<html>";
		text += "<br>RULES FOR TIC-TAC-TOE: <br><br>";
		text += "1. The game is played on a grid that's 3 squares by 3 squares.<br><br>";
		text += "2. You are X, your friend (or the computer in this case) is O.<br>";
		text += "Players take turns putting their marks in empty squares.<br><br>";
		text += "3. The first player to get 3 of her marks in a row<br>";
		text += "(up, down, across, or diagonally) is the winner.<br><br>";
		text += "4. When all 9 squares are full, the game is over.<br>";
		text += "If no player has 3 marks in a row, the game ends in a tie.";
		how.setBackground(black);
		how.setForeground(white);
		how.setText(text);
		howToPlay.add(backToHome);
		howToPlay.add(how);
		howToPlay.setBackground(black);
		backToHome.addActionListener(this);
		
		add(howToPlay);
		setTitle("How To Play");
		setResizable(false);
		setSize(400,325);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		// ????? back to home bug
		if(e.getSource()==backToHome) {
			Main.menu = new Menu();
			Main.howToPlay.dispose();
		}
	}
}
