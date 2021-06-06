package com.tictactoe;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

public class Main extends JFrame implements ActionListener {
    JButton[] grids = new JButton[9];
    boolean gameOver = false;
    JLabel gridNumber = new JLabel();
    boolean circleTurn = false;
    int moveCount = 0;
    String[][] board = new String[3][3];
    Image icon = Toolkit.getDefaultToolkit().getImage("src/com/tictactoe/logo.png");

    Main() {

        setBounds(100, 100, 615, 630);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setIconImage(icon);
        setFocusable(false);
        setResizable(false);
        for (int i = 0; i < grids.length; i++) {
            gridNumber = new JLabel();
            gridNumber.setForeground(Color.white);
            gridNumber.setText(String.valueOf(i + 1));
            gridNumber.setSize(new Dimension(30, 30));
            grids[i] = new JButton();
            grids[i].setLayout(new BorderLayout());
            grids[i].setBackground(Color.darkGray);
            grids[i].setForeground(Color.red);
            grids[i].setFont(new Font("Arial", Font.BOLD, 32));
            grids[i].setName(String.valueOf(i));
            grids[i].setFocusable(false);
            grids[i].setSelected(false);
            grids[i].setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.lightGray));
            grids[i].add(gridNumber, BorderLayout.NORTH);
            grids[i].addActionListener(this);
            grids[i].setVisible(true);
            add(grids[i]);
        }
        setLayout(new GridLayout(3, 3));
        setVisible(true);
    }

    public static void main(String[] args) {
        new Main();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        GameLogic logic = new GameLogic();
        for (JButton grid : grids) {
            if (e.getSource() == grid && moveCount < 6) {
                boolean inputTurnIsCircle = circleTurn;
                circleTurn = logic.makeMove(grid, circleTurn);
                if (inputTurnIsCircle != circleTurn) {
                    moveCount++;
                }
            }
        }
        board[0][0] = grids[0].getName();
        board[0][1] = grids[1].getName();
        board[0][2] = grids[2].getName();
        board[1][0] = grids[3].getName();
        board[1][1] = grids[4].getName();
        board[1][2] = grids[5].getName();
        board[2][0] = grids[6].getName();
        board[2][1] = grids[7].getName();
        board[2][2] = grids[8].getName();
        System.out.println(Arrays.deepToString(board));
        if (!gameOver) {
            if (logic.checkWin("x", board).equals("x")) {
                System.out.println("x win");
                gameOver = true;
            }
            if (logic.checkWin("o", board).equals("o")) {
                System.out.println("o win");
                gameOver = true;
            }
        }

    }
}