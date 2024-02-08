import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class About extends JFrame implements ActionListener {
	//COLOR 
	Color black = new Color(0,0,0);
	Color white = new Color(0xf7f7f7);
	String text = new String();
	JPanel about = new JPanel();
	JLabel how = new JLabel();
	JLabel thanks = new JLabel("MANY THANKS FOR PLAYING", JLabel.CENTER);
	JButton backToHome = new JButton("Back To Home");
	About() {
		backToHome.setForeground(white);
		backToHome.setRolloverEnabled(false);
		backToHome.setBackground(black);
		backToHome.setFocusable(false);
		text ="<html>";
		text += "<br>ABOUT US: <br><br>";
		text += "- Coder: Tran Duc Khanh Thien - Java OOP Project <br><br>";
		text += "- Github: github.com/sp1deydev<br><br>";
		text += "- Facebook: facebook.com/emthienmatma<br><br><br>";
		
		how.setBackground(black);
		how.setForeground(white);
		thanks.setBackground(black);
		thanks.setForeground(white);
		how.setText(text);
		about.add(backToHome);
		about.add(how);
		about.add(thanks);
		about.setBackground(black);
		backToHome.addActionListener(this);
		
		add(about);
		setTitle("About");
		setResizable(false);
		setSize(400,300);
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
			Main.about.dispose();
		}
	}
}
