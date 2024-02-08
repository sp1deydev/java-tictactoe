import java.awt.Color;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Tictactoe extends JPanel implements ActionListener {
	
	//DECLARE VARIABLES
	int player1 = 0;
	int player2 = 0;
	int winner = -1;
	boolean gameDone = false;
	boolean XTurn = true;
	boolean tempTurn = true;
	int[][] board = new int[3][3];
	
	
	//BUTTON
	JButton playAgain = new JButton("Play Again");  
	JButton reset = new JButton("Reset");
	JButton backToHome = new JButton("Back To Home");
	
	
	//CONSTRUCTOR
	public Tictactoe() {
		//backToHome btn
		backToHome.setForeground(offwhite);
		backToHome.setRolloverEnabled(false);
		backToHome.setBackground(black);
		backToHome.setFocusable(false);
		
		//Reset btn
		reset.setForeground(offwhite);
		reset.setRolloverEnabled(false);
		reset.setBackground(black);
		reset.setFocusable(false);
		
		//Play again btn
		playAgain.setForeground(offwhite);
		playAgain.setRolloverEnabled(false);
		playAgain.setBackground(black);
		playAgain.setFocusable(false);
		
		//Other work
		add(backToHome);
		add(playAgain);
		add(reset);
		backToHome.addActionListener(this);
		reset.addActionListener(this);
		playAgain.addActionListener(this);
		playAgain.setVisible(false);
		addMouseListener(new XOListener());
	}
	
	//GRAPHIC VARIABLES
	int lineWidth = 5,
		lineLength = 300,
		x1 = 150, y1 = 150,
		x2 = 250, y2 =55,
		offset = 95,
		a,b,
		locI, locJ;
	
	
	
	
	//COLORS
	Color offwhite = new Color(0xf7f7f7);
	Color black = new Color(0,0,0);
	//FONTS
	Font font1 = new Font(" ", Font.BOLD, 15);
	
	//COMPONENT
	public void paintComponent(Graphics page) {
		super.paintComponent(page);
		drawBoard(page);
		drawUI(page);
		drawGame(page);
	}
	public void drawBoard(Graphics page) { //draw a board to play
		setBackground(black);
		page.setColor(offwhite);
		page.fillRoundRect(x1, y1, lineLength, lineWidth, 5,30);
		page.fillRoundRect(x1,y1+offset, lineLength, lineWidth, 5,30);
		page.fillRoundRect(x2,y2, lineWidth, lineLength, 30,5);
		page.fillRoundRect(x2+offset,y2, lineWidth, lineLength, 30,5);
	}
	public void drawUI(Graphics page) { //draw score, turn, notifications
		page.setColor(offwhite);
		page.setFont(font1);
		page.drawString("PLAYER 1(X)    -    PLAYER 2(O)",200,450);
		page.drawString(player1+"",240,475);
		page.drawString(player2+"",370,475);
		if(gameDone) { //when game done
			if(winner == 1) { //X wins
				page.drawString("X won this game!", 240,400);
			}
			else if(winner == 0) { // O wins
				page.drawString("O won this game!", 240,400);
			} else if(winner == 2) { //the game was tie
				page.drawString("The game was tie!", 235,400);
			}
		}
		else { // the game has not done yet
			if(XTurn) {
				page.drawString("X's turn", 275,400);
			}
			else {
				page.drawString("O's turn", 275,400);
			}
		}
	}
	public void drawGame(Graphics page) { //print X and O
		Image xImg = null;
		try { //GET X IMAGE
			xImg = ImageIO.read(new File("src/x-mark-48.png"));
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Image newXImg = xImg.getScaledInstance(50, 50, java.awt.Image.SCALE_SMOOTH);
		
		for(int i=0;i<3;i++) {
			for(int j=0;j<3;j++) {
				if(board[i][j]==0) {
					//do nothing
				} else if(board[i][j]==1) {
					page.drawImage(newXImg,180+offset*j, 80+offset*i, null);
				} else if(board[i][j]==2) {
					page.setColor(offwhite);
					page.fillOval(180+offset*j, 80+offset*i, 50, 50);
					page.setColor(black);
					page.fillOval(190+offset*j, 90+offset*i, 30, 30);
				}
			}
		}
		repaint();
	}
	//FULL BOARD
	public boolean fullBoard() {
		for(int i=0;i<3;i++) 
			for(int j=0;j<3;j++) {
				if(board[i][j]==0)
					return false;
			}
		return true;
	}
	//to know X win or O win
	public boolean whoWin(int who) {
		if(board[0][0] == who && board[0][1] == who && board[0][2] == who ||
		   board[1][0] == who && board[1][1] == who && board[1][2] == who ||
		   board[2][0] == who && board[2][1] == who && board[2][2] == who ) {
			return true;
		}
		if(board[0][0] == who && board[1][0] == who && board[2][0] == who ||
		   board[0][1] == who && board[1][1] == who && board[2][1] == who ||
		   board[0][2] == who && board[1][2] == who && board[2][2] == who ) {
			return true;
		}
		if(board[0][0] == who && board[1][1] == who && board[2][2] == who ||
		   board[2][0] == who && board[1][1] == who && board[0][2] == who) 
			return true;
		return false;
	}
	
	
	//CHECK WIN
	public void checkWin() {		
		if(whoWin(1)) { //CHECK X WIN
			winner = 1;
			gameDone  = true;
			player1++;
			XTurn = false;
			tempTurn = XTurn;
			playAgain.setVisible(true);
			reset.setVisible(false);
		} else if(whoWin(2)) { //CHECK O WIN
			winner = 0;
			gameDone  = true;
			player2++;
			XTurn = true;
			tempTurn = XTurn;
			playAgain.setVisible(true);
			reset.setVisible(false);
		} else if(fullBoard()) {
			winner = 2;
			gameDone  = true;
			XTurn = !XTurn;
			tempTurn = XTurn;
			playAgain.setVisible(true);
			reset.setVisible(false);
		}
	}
	
	
	
	//CLICK TO PLACE X AND O
	public class XOListener implements MouseListener {
		@Override
		public void mouseClicked(MouseEvent e) {
			locI = -1; locJ = -1;
			if(!gameDone) {
				a = e.getX(); b = e.getY();
				if(a>151 && a<249) {
					locJ = 0;
				} else if(a>256 && a<344) {
					locJ = 1;
				} else if(a>351 && a<445) {
					locJ = 2;
				} else {
					locJ = -1;
				}
				if(b>51 && b<148) {
					locI = 0;
				} else if(b>156 && b<240) {
					locI = 1;
				} else if(b>251 && b<345) {
					locI = 2;
				} else {
					locI = -1;
				}
			}
			if(locI != -1 && locJ != -1) {
				if(board[locI][locJ]==0) { //prevent over write
					if(XTurn) {
						board[locI][locJ] = 1;
						XTurn = false;
					}
					else {
						board[locI][locJ] = 2;
						XTurn = true;
					}
					checkWin();
				}
				
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


	//CLICK BUTTON
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		//PLAY AGAIN BUTTON
		if(e.getSource()==playAgain) {
			//LOSER PLAY FIRST
			if(winner == 1) 
				XTurn = false;
			else if(winner == 0)
				XTurn = true;
			else 
				XTurn = !XTurn;
			winner = -1;
			gameDone  = false;
			for(int i=0;i<3;i++)
				for(int j=0;j<3;j++) {
					board[i][j] = 0;
				}
			playAgain.setVisible(false);
			reset.setVisible(true);
		}
		//BACK TO HOME BUTTON
		if(e.getSource()==backToHome) {
			Main.menu = new Menu();
			Main.playZone.dispose();
		}
		//RESET BUTON
		if(e.getSource()==reset) {
			XTurn = tempTurn;
			for(int i=0;i<3;i++)
				for(int j=0;j<3;j++) {
					board[i][j] = 0;
				}
		}
			
			
	}
	
	
	
	
	
	
	

	
	
}
