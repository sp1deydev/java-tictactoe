import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;

public class PlayPvE extends JFrame {
	
	
	JButton backToHome = new JButton("Back To Home");
	TictactoePvE ticTacToe = new TictactoePvE();
	PlayPvE() {
		setTitle("Tic Tac Toe");
		setResizable(false);
		setSize(600,550);
		setLocationRelativeTo(null);
		add(ticTacToe);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		
	}
}
