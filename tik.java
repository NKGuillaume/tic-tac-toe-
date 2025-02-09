import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.Timer;

public class tik implements ActionListener {
	Random random = new Random();
	JFrame frame = new JFrame();
	JPanel title_panel = new JPanel();
	JPanel button_panel = new JPanel();
	JLabel textField = new JLabel();
	JButton[] button = new JButton[9];
	boolean player1_turn;

	tik() {
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(800, 800);
		frame.getContentPane().setBackground(new Color(50, 50, 50));
		frame.setLayout(new BorderLayout());
		frame.setVisible(true);

		textField.setBackground(Color.red);
		textField.setForeground(Color.black);
		textField.setFont(new Font("INk FREE", Font.BOLD, 50));
		textField.setHorizontalAlignment(JLabel.CENTER);
		textField.setVerticalAlignment(JLabel.CENTER);
		textField.setText("TIC-TAC-TOE");
		textField.setOpaque(true);

		title_panel.setLayout(new BorderLayout());
		title_panel.setBounds(0, 0, 800, 100);
		button_panel.setLayout(new GridLayout(3, 3));
		button_panel.setBackground(Color.gray);
		for (int i = 0; i < 9; i++) {
			button[i] = new JButton();
			button_panel.add(button[i]);
			button[i].setFont(new Font("MV Boli", Font.BOLD, 120));
			button[i].setFocusable(false);
			button[i].addActionListener(this);
		}
		title_panel.add(textField);
		frame.add(title_panel, BorderLayout.NORTH);
		frame.add(button_panel);

		firstTurn();

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		for (int i = 0; i < 9; i++) {
			if (e.getSource() == button[i]) {
				if (player1_turn) {
					if (button[i].getText() == "") {
						button[i].setForeground(new Color(255, 0, 0));
						button[i].setText("X");
						player1_turn = false;
						textField.setText("O Turn");
						check();
					}
				} else {
					if (button[i].getText() == "") {
						button[i].setForeground(new Color(0, 0, 255));
						button[i].setText("O");
						player1_turn = true;
						textField.setText("X Turn");
						check();
					}

				}
			}
		}
	}

	public void firstTurn() {

		if (random.nextInt(2) == 0) {
			player1_turn = true;
			textField.setText("X turn");
		} else {
			player1_turn = false;
			textField.setText("O turn");
		}

	}

	public void check() {
		// check X Win conditions
		if ((button[0].getText() == "X") && (button[1].getText() == "X") && (button[2].getText() == "X")) {
			xWins(0, 1, 2);
		}
		if ((button[3].getText() == "X") && (button[4].getText() == "X") && (button[5].getText() == "X")) {
			xWins(3, 4, 5);
		}
		if ((button[6].getText() == "X") && (button[7].getText() == "X") && (button[8].getText() == "X")) {
			xWins(6, 7, 8);
		}
		if ((button[0].getText() == "X") && (button[3].getText() == "X") && (button[6].getText() == "X")) {
			xWins(0, 3, 6);
		}
		if ((button[1].getText() == "X") && (button[4].getText() == "X") && (button[7].getText() == "X")) {
			xWins(1, 4, 7);
		}
		if ((button[2].getText() == "X") && (button[5].getText() == "X") && (button[8].getText() == "X")) {
			xWins(2, 5, 8);
		}
		if ((button[0].getText() == "X") && (button[4].getText() == "X") && (button[8].getText() == "X")) {
			xWins(0, 4, 8);
		}
		if ((button[2].getText() == "X") && (button[4].getText() == "X") && (button[6].getText() == "X")) {
			xWins(2, 4, 6);
		}
//check O wins 
		if ((button[0].getText() == "O") && (button[1].getText() == "O") && (button[2].getText() == "O")) {
			oWins(0, 1, 2);
		}
		if ((button[3].getText() == "O") && (button[4].getText() == "O") && (button[5].getText() == "O")) {
			oWins(3, 4, 5);
		}
		if ((button[6].getText() == "O") && (button[7].getText() == "O") && (button[8].getText() == "O")) {
			oWins(6, 7, 8);
		}
		if ((button[0].getText() == "O") && (button[3].getText() == "O") && (button[6].getText() == "O")) {
			oWins(0, 3, 6);
		}
		if ((button[1].getText() == "O") && (button[4].getText() == "O") && (button[7].getText() == "O")) {
			oWins(1, 4, 7);
		}
		if ((button[2].getText() == "O") && (button[5].getText() == "O") && (button[8].getText() == "O")) {
			oWins(2, 5, 8);
		}
		if ((button[0].getText() == "O") && (button[4].getText() == "O") && (button[8].getText() == "O")) {
			oWins(0, 4, 8);
		}
		if ((button[2].getText() == "O") && (button[4].getText() == "O") && (button[6].getText() == "O")) {
			oWins(2, 4, 6);
		}

	}

	public void xWins(int a, int b, int c) {
		button[a].setBackground(Color.GREEN);
		button[b].setBackground(Color.GREEN);
		button[c].setBackground(Color.GREEN);

		for (int i = 0; i < 9; i++) {
			button[i].setEnabled(false);
		}
		textField.setText("X Wins");

	}

	public void oWins(int a, int b, int c) {
		button[a].setBackground(Color.GREEN);
		button[b].setBackground(Color.GREEN);
		button[c].setBackground(Color.GREEN);

		for (int i = 0; i < 9; i++) {
			button[i].setEnabled(false);
		}
		textField.setText("O Wins");

	}

}
