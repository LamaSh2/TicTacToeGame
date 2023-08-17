import java.awt.EventQueue;
import javax.swing.ImageIcon; 
import javax.swing.JFrame;
import java.awt.BorderLayout;
import javax.swing.JPanel;
//import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.JLabel;
import java.awt.Image;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.MatteBorder;
import javax.swing.border.CompoundBorder;


public class TicTacToeGame {

	private JFrame frame;
	private JButton btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9; 
	private JTextField xCount;
	private JTextField oCount;
	private int xCount1 = 0; //We named it xCount1/oCount1 because we used xCount/oCount before
	private int oCount1 = 0;
	private String startGame="X";
	private JLabel currentPlayerLabel;

	String[][] availableBoxes = new String[3][3];
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
	    EventQueue.invokeLater(new Runnable() {
	        public void run() {
	            try {
	                // Create the landing page
	                JFrame landingPage = new JFrame();
	                landingPage.setBounds(100, 100, 600, 400);
	                landingPage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	                landingPage.getContentPane().setLayout(new BorderLayout(0, 0));
	                landingPage.getContentPane().setBackground(Color.DARK_GRAY);
	                
	                // Create and scale the logo
	                ImageIcon originalIcon = new ImageIcon(getClass().getResource("Tic tac toe logo.png"));
	                Image originalImage = originalIcon.getImage();
	                Image scaledImage = originalImage.getScaledInstance(100, 60, Image.SCALE_SMOOTH);
	                ImageIcon scaledIcon = new ImageIcon(scaledImage);
	                
	                // Add your logo
	                JLabel logo = new JLabel(scaledIcon);
	                logo.setForeground(new Color(0, 0, 0));
	                logo.setHorizontalAlignment(SwingConstants.CENTER);
	                landingPage.getContentPane().add(logo, BorderLayout.CENTER);
	                
	                // Add a start game button
	                JButton startButton = new JButton("Start Game");
	                startButton.setFont(new Font("Tahoma", Font.BOLD, 16));
	                startButton.setBackground(new Color(255, 255, 255));
	                startButton.addActionListener(new ActionListener() {
	                    public void actionPerformed(ActionEvent e) {
	                        // Start the game when the button is clicked
	                        TicTacToeGame window = new TicTacToeGame();
	                        window.frame.setVisible(true);
	                        // Close the landing page
	                        landingPage.dispose();
	                    }
	                });
	                landingPage.getContentPane().add(startButton, BorderLayout.SOUTH);
	                
	                // Show the landing page
	                landingPage.setVisible(true);
	            } catch (Exception e) {
	                e.printStackTrace();
	            }
	        }
	    });
	}
	/**
	 * Create the application.
	 */
	public TicTacToeGame() {
		initialize();
	}
	private boolean checkBoxes() {
	    for (int i =0; i<3; i++) {
	        for (int j =0; j<3; j++) {
	            if (availableBoxes[i][j]==null) {
	                return false;
	            }	
	        }
	    }
	    return true;
	}
	
	private void eraseBoxes() {
		btn1.setText(null);
		btn2.setText(null);
		btn3.setText(null);
		btn4.setText(null);
		btn5.setText(null);
		btn6.setText(null);
		btn7.setText(null);
		btn8.setText(null);
		btn9.setText(null);
		
		for (int i=0; i<3; i++) {
			for (int j=0; j<3; j++) {
				availableBoxes[i][j]=null;
			}
		}
	}
	
	/*
	 * X winning options
	 */
	private boolean horizontalX() {
	    if (availableBoxes[0][0]=="X" && availableBoxes[0][1]=="X" && availableBoxes[0][2]=="X") {
	        return true;
	    }
	    if(availableBoxes[1][0]=="X" && availableBoxes[1][1]=="X" && availableBoxes[1][2]=="X") {
	        return true;
	    }
	    if (availableBoxes[2][0]=="X" && availableBoxes[2][1]=="X" && availableBoxes[2][2]=="X") {
	        return true;
	    }
	    return false;
	}
	private boolean verticalX() {
	    if (availableBoxes[0][0]=="X" && availableBoxes[1][0]=="X" && availableBoxes[2][0]=="X") {
	        return true;
	    }
	    if(availableBoxes[0][1]=="X" && availableBoxes[1][1]=="X" && availableBoxes[2][1]=="X") {
	        return true;
	    }
	    if (availableBoxes[0][2]=="X" && availableBoxes[1][2]=="X" && availableBoxes[2][2]=="X") {
	        return true;
	    }
	    return false;
	}
	private boolean diagonalX() {
        if (availableBoxes[0][0]=="X" && availableBoxes[1][1]=="X" && availableBoxes[2][2]=="X") {
        return true;
        }if (availableBoxes[0][2]=="X" && availableBoxes[1][1]=="X" && availableBoxes[2][0]=="X") {
        	return true;
        }
        return false;
	}

	/*
	 * Y winning Options
	 */
	
	private boolean horizontalO() {

		 if (availableBoxes[0][0]=="O" && availableBoxes[0][1]=="O" && availableBoxes[0][2]=="O") {
	           return true;
	        }if(availableBoxes[1][0]=="O" && availableBoxes[1][1]=="O" && availableBoxes[1][2]=="O") {
	           return true;
	        }if (availableBoxes[2][0]=="O" && availableBoxes[2][1]=="O" && availableBoxes[2][2]=="O") {
	          return true;
	        }
		return false;
	}
	private boolean verticalO() {

		  if (availableBoxes[0][0]=="O" && availableBoxes[1][0]=="O" && availableBoxes[2][0]=="O") {
	      return true;
	        }if(availableBoxes[0][1]=="O" && availableBoxes[1][1]=="O" && availableBoxes[2][1]=="O") {
	        	return true;
	        }if(availableBoxes[0][2]=="O" && availableBoxes[1][2]=="O" && availableBoxes[2][2]=="O") {
	        	return true;
	        }return false;
		
	}
	private boolean diagonalO() {

        if (availableBoxes[0][0]=="O" && availableBoxes[1][1]=="O" && availableBoxes[2][2]=="O") {
        	return true;
        }if (availableBoxes[0][2]=="O" && availableBoxes[1][1]=="O" && availableBoxes[2][0]=="O") {
        	return true;
        }
        return false;
	}
	
	private void winner() {
	    if (horizontalX() || verticalX() || diagonalX()) {
	        xCount1++;
	        System.out.println(xCount);
	        xCount.setText(String.valueOf(xCount1));
	        JOptionPane.showMessageDialog(frame, "Player X Wins", "Tic Tac Toe", JOptionPane.INFORMATION_MESSAGE);
	        eraseBoxes();
	        return; // return from the method as we found a winner
	    }
	    if (horizontalO() || verticalO() || diagonalO()) {
	        oCount1++;
	        System.out.println(oCount);
	        oCount.setText(String.valueOf(oCount1));
	        JOptionPane.showMessageDialog(frame, "Player O Wins", "Tic Tac Toe", JOptionPane.INFORMATION_MESSAGE);
	        eraseBoxes();
	        return; // return from the method as we found a winner
	    }
	    if (checkBoxes()) {
	        JOptionPane.showMessageDialog(frame, "TIE", "Tic Tac Toe", JOptionPane.INFORMATION_MESSAGE);
	        eraseBoxes();
	    }
	}
	
	private void choosePlayer() {
	    if (startGame.equalsIgnoreCase("X")) {
	        startGame = "O";
	        currentPlayerLabel.setText("Current Player: O");
	        currentPlayerLabel.setForeground(Color.RED);
	    } else {
	        startGame = "X";
	        currentPlayerLabel.setText("Current Player: X");
	        currentPlayerLabel.setForeground(Color.BLUE);
	    }
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 600, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new BorderLayout(0, 0));
		
		currentPlayerLabel = new JLabel("Current Player: X");
		currentPlayerLabel.setHorizontalAlignment(SwingConstants.CENTER);
		currentPlayerLabel.setFont(new Font("Tahoma", Font.BOLD, 22));
		frame.getContentPane().add(currentPlayerLabel, BorderLayout.NORTH);
		
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(new GridLayout(3, 5, 2, 2));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new CompoundBorder());
		panel.add(panel_1);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		btn1 = new JButton("");
		btn2 = new JButton("");
		btn3 = new JButton("");
		btn4 = new JButton("");
		btn5 = new JButton("");
		btn6 = new JButton("");
		btn7 = new JButton("");
		btn8 = new JButton("");
		btn9 = new JButton("");
		
		
		btn1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (availableBoxes[0][0]==null) {
					btn1.setText(startGame);
					availableBoxes[0][0]=startGame;
					if (startGame.equalsIgnoreCase("X")) {
						btn1.setForeground(Color.blue);
					}else {
						btn1.setForeground(Color.red);
					}
					winner();
					if (!checkBoxes()) {//if the game continues switch player 
						choosePlayer();
					}
					
				}else {
					 JFrame frame = new JFrame("Error");
			            JOptionPane.showMessageDialog(frame, "Block already chosen, pick another box.", "Error", JOptionPane.OK_OPTION);
				}
					
				}
		});
		btn1.setFont(new Font("Tahoma", Font.BOLD, 35));
		btn1.setBackground(new Color(75, 75, 75));
		btn1.setBorder(new MatteBorder(0,0,2,2,Color.white));
		panel_1.add(btn1, BorderLayout.CENTER);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new CompoundBorder());
		panel.add(panel_2);
		panel_2.setLayout(new BorderLayout(0, 0));
		
		
		btn2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (availableBoxes[0][1]==null) {
					btn2.setText(startGame);
					availableBoxes[0][1]=startGame;
					if (startGame.equalsIgnoreCase("X")) {
						btn2.setForeground(Color.blue);
					}else {
						btn2.setForeground(Color.red);
					}
					choosePlayer();
					winner();
				}else {
					 JFrame frame = new JFrame("Error");
			            JOptionPane.showMessageDialog(frame, "Block already chosen, pick another box.", "Error", JOptionPane.OK_OPTION);
				}
			}
		});
		btn2.setFont(new Font("Tahoma", Font.BOLD, 35));
		btn2.setBackground(new Color(75, 75, 75));
		btn2.setBorder(new MatteBorder(0,0,2,2,Color.white));

		panel_2.add(btn2, BorderLayout.CENTER);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new CompoundBorder());
		panel.add(panel_3);
		panel_3.setLayout(new BorderLayout(0, 0));
		
		
		btn3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (availableBoxes[0][2]==null) {
					btn3.setText(startGame);
					availableBoxes[0][2]=startGame;
					if (startGame.equalsIgnoreCase("X")) {
						btn3.setForeground(Color.blue);
					}else {
						btn3.setForeground(Color.red);
					}
					choosePlayer();
					winner();
				}else {
					 JFrame frame = new JFrame("Error");
			            JOptionPane.showMessageDialog(frame, "Block already chosen, pick another box.", "Error", JOptionPane.OK_OPTION);
				}
			}
		});
		btn3.setFont(new Font("Tahoma", Font.BOLD, 35));
		btn3.setBackground(new Color(75, 75, 75));
		btn3.setBorder(new MatteBorder(0,0,2,2,Color.white));

		panel_3.add(btn3, BorderLayout.CENTER);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBorder(null);
		panel.add(panel_4);
		panel_4.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel = new JLabel("Player X");
		lblNewLabel.setForeground(new Color(0, 128, 255));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 22));
		panel_4.add(lblNewLabel, BorderLayout.CENTER);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBorder(null);
		panel.add(panel_5);
		panel_5.setLayout(new BorderLayout(0, 0));
		
		xCount = new JTextField();
		xCount.setForeground(new Color(0, 128, 255));
		xCount.setFont(new Font("Tahoma", Font.BOLD, 22));
		xCount.setHorizontalAlignment(SwingConstants.CENTER);
		xCount.setText("0");
		panel_5.add(xCount, BorderLayout.CENTER);
		xCount.setColumns(10);
		
		JPanel panel_6 = new JPanel();
		panel_6.setBorder(new CompoundBorder());
		panel.add(panel_6);
		panel_6.setLayout(new BorderLayout(0, 0));
		
		
		btn4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (availableBoxes[1][0]==null) {
					btn4.setText(startGame);
					availableBoxes[1][0]=startGame;
					if (startGame.equalsIgnoreCase("X")) {
						btn4.setForeground(Color.blue);
					}else {
						btn4.setForeground(Color.red);
					}
					choosePlayer();
					winner();
				}else {
					 JFrame frame = new JFrame("Error");
			            JOptionPane.showMessageDialog(frame, "Block already chosen, pick another box.", "Error", JOptionPane.OK_OPTION);
				}
			}
		});
		btn4.setFont(new Font("Tahoma", Font.BOLD, 35));
		btn4.setBackground(new Color(75, 75, 75));
		btn4.setBorder(new MatteBorder(0,0,2,2,Color.white));

		panel_6.add(btn4, BorderLayout.CENTER);
		
		JPanel panel_7 = new JPanel();
		panel_7.setBorder(new CompoundBorder());
		panel.add(panel_7);
		panel_7.setLayout(new BorderLayout(0, 0));
		
		
		btn5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (availableBoxes[1][1]==null) {
					btn5.setText(startGame);
					availableBoxes[1][1]=startGame;
					if (startGame.equalsIgnoreCase("X")) {
						btn5.setForeground(Color.blue);
					}else {
						btn5.setForeground(Color.red);
					}
					choosePlayer();
					winner();
				}else {
					 JFrame frame = new JFrame("Error");
			            JOptionPane.showMessageDialog(frame, "Block already chosen, pick another box.", "Error", JOptionPane.OK_OPTION);
				}
			}
		});
		btn5.setFont(new Font("Tahoma", Font.BOLD, 35));
		btn5.setBackground(new Color(75, 75, 75));
		btn5.setBorder(new MatteBorder(0,0,2,2,Color.white));

		panel_7.add(btn5, BorderLayout.CENTER);
		
		JPanel panel_8 = new JPanel();
		panel_8.setBorder(new CompoundBorder());
		panel.add(panel_8);
		panel_8.setLayout(new BorderLayout(0, 0));
		
		
		btn6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (availableBoxes[1][2]==null) {
					btn6.setText(startGame);
					availableBoxes[1][2]=startGame;
					if (startGame.equalsIgnoreCase("X")) {
						btn6.setForeground(Color.blue);
					}else {
						btn6.setForeground(Color.red);
					}
					choosePlayer();
					winner();
				}else {
					 JFrame frame = new JFrame("Error");
			            JOptionPane.showMessageDialog(frame, "Block already chosen, pick another box.", "Error", JOptionPane.OK_OPTION);
				}
			}
		});
		btn6.setFont(new Font("Tahoma", Font.BOLD, 35));
		btn6.setBackground(new Color(75, 75, 75));
		btn6.setBorder(new MatteBorder(0,0,2,2,Color.white));

		panel_8.add(btn6, BorderLayout.CENTER);
		
		JPanel panel_9 = new JPanel();
		panel_9.setBorder(null);
		panel.add(panel_9);
		panel_9.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel_1 = new JLabel("Player O");
		lblNewLabel_1.setForeground(new Color(255, 0, 0));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 22));
		panel_9.add(lblNewLabel_1, BorderLayout.CENTER);
		
		JPanel panel_10 = new JPanel();
		panel_10.setBorder(null);
		panel.add(panel_10);
		panel_10.setLayout(new BorderLayout(0, 0));
		
		oCount = new JTextField();
		oCount.setFont(new Font("Tahoma", Font.BOLD, 22));
		oCount.setForeground(new Color(255, 0, 0));
		oCount.setHorizontalAlignment(SwingConstants.CENTER);
		oCount.setText("0");
		panel_10.add(oCount, BorderLayout.CENTER);
		oCount.setColumns(10);
		
		JPanel panel_11 = new JPanel();
		panel_11.setBorder(new CompoundBorder());
		panel.add(panel_11);
		panel_11.setLayout(new BorderLayout(0, 0));
		
		
		btn7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (availableBoxes[2][0]==null) {
					btn7.setText(startGame);
					availableBoxes[2][0]=startGame;
					if (startGame.equalsIgnoreCase("X")) {
						btn7.setForeground(Color.blue);
					}else {
						btn7.setForeground(Color.red);
					}
					choosePlayer();
					winner();
				}else {
					 JFrame frame = new JFrame("Error");
			            JOptionPane.showMessageDialog(frame, "Block already chosen, pick another box.", "Error", JOptionPane.OK_OPTION);
				}
			}
		});
		btn7.setFont(new Font("Tahoma", Font.BOLD, 35));
		btn7.setBackground(new Color(75, 75, 75));
		btn7.setBorder(new MatteBorder(0,0,2,2,Color.white));

		panel_11.add(btn7, BorderLayout.CENTER);
		
		JPanel panel_12 = new JPanel();
		panel_12.setBorder(new CompoundBorder());
		panel.add(panel_12);
		panel_12.setLayout(new BorderLayout(0, 0));
		
		
		btn8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (availableBoxes[2][1]==null) {
					btn8.setText(startGame);
					availableBoxes[2][1]=startGame;
					if (startGame.equalsIgnoreCase("X")) {
						btn8.setForeground(Color.blue);
					}else {
						btn8.setForeground(Color.red);
					}
					choosePlayer();
					winner();
				}else {
					 JFrame frame = new JFrame("Error");
			            JOptionPane.showMessageDialog(frame, "Block already chosen, pick another box.", "Error", JOptionPane.OK_OPTION);
				}
			}
		});
		btn8.setFont(new Font("Tahoma", Font.BOLD, 35));
		btn8.setBackground(new Color(75, 75, 75));
		btn8.setBorder(new MatteBorder(0,0,2,2,Color.white));

		panel_12.add(btn8, BorderLayout.CENTER);
		
		JPanel panel_13 = new JPanel();
		panel_13.setBorder(new CompoundBorder());
		panel.add(panel_13);
		panel_13.setLayout(new BorderLayout(0, 0));
		
		
		btn9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (availableBoxes[2][2]==null) {
					btn9.setText(startGame);
					availableBoxes[2][2]=startGame;
					if (startGame.equalsIgnoreCase("X")) {
						btn9.setForeground(Color.blue);
					}else {
						btn9.setForeground(Color.red);
					}
					choosePlayer();
					winner();
				}else {
					 JFrame frame = new JFrame("Error");
			            JOptionPane.showMessageDialog(frame, "Block already chosen, pick another box.", "Error", JOptionPane.OK_OPTION);
				}
			}
		});
		btn9.setFont(new Font("Tahoma", Font.BOLD, 35));
		btn9.setBackground(new Color(75, 75, 75));
		btn9.setBorder(new MatteBorder(0,0,2,2,Color.white));

		panel_13.add(btn9, BorderLayout.CENTER);
		
		JPanel panel_14 = new JPanel();
		panel_14.setBorder(new CompoundBorder());
		panel.add(panel_14);
		panel_14.setLayout(new BorderLayout(0, 0));
		
		JButton btnReset = new JButton("RESET");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn1.setText(null);
				btn2.setText(null);
				btn3.setText(null);
				btn4.setText(null);
				btn5.setText(null);
				btn6.setText(null);
				btn7.setText(null);
				btn8.setText(null);
				btn9.setText(null);
				
				for (int i=0; i<3; i++) {
					for (int j=0; j<3; j++) {
						availableBoxes[i][j]=null;
					}
				}
				
				xCount1=0;
				oCount1=0;
				
				xCount.setText(String.valueOf(xCount1));
				oCount.setText(String.valueOf(oCount1));
			}
		});
		btnReset.setForeground(new Color(255, 255, 255));
		btnReset.setBackground(new Color(75, 75, 75));
		btnReset.setFont(new Font("Tahoma", Font.BOLD, 22));
		panel_14.add(btnReset, BorderLayout.CENTER);
		
		JPanel panel_15 = new JPanel();
		panel_15.setBorder(new CompoundBorder());
		panel.add(panel_15);
		panel_15.setLayout(new BorderLayout(0, 0));
		
		JButton btnExit = new JButton("EXIT");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame = new JFrame("Exit");
				if (JOptionPane.showConfirmDialog(frame, "Confirm you want to exit", "Tic Tac Toe", JOptionPane.YES_NO_OPTION)==JOptionPane.YES_OPTION) {
					System.exit(0);
					
				}
			}
		});
		btnExit.setForeground(new Color(255, 255, 255));
		btnExit.setBackground(new Color(75, 75, 75));
		btnExit.setFont(new Font("Tahoma", Font.BOLD, 22));
		panel_15.add(btnExit, BorderLayout.CENTER);
	}

}
