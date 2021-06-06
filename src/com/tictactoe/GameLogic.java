package com.tictactoe;

import javax.swing.*;


public class GameLogic extends JFrame {
    int n = 3;
    Icon crossIcon = new ImageIcon("src/com/tictactoe/cross.png");
    Icon circleIcon = new ImageIcon("src/com/tictactoe/circle.png");

    public boolean makeMove(JButton grid, boolean circleTurn) {
        if (grid.getIcon() == null) {
            if (circleTurn) {
                grid.setIcon(circleIcon);
                grid.setName("o");
                return false;
            } else {
                grid.setIcon(crossIcon);
                grid.setName("x");
                return true;
            }
        }
        return circleTurn;
    }

    public String checkWin(String input, String[][] board) {
        for (int x = 0; x < 3; x++) {
            for (int y = 0; y < 3; y++) {

                //check col
                for (int i = 0; i < n; i++) {
                    if (!board[x][i].equals(input))
                        break;
                    if (i == n - 1) {
                        return input;
                    }
                }
                //check row
                for (int i = 0; i < n; i++) {
                    if (!board[i][y].equals(input))
                        break;
                    if (i == n - 1) {
                        return input;
                    }
                }
                //check diag
                if (x == y) {
                    //check diagonal
                    for (int i = 0; i < n; i++) {
                        if (!board[i][i].equals(input))
                            break;
                        if (i == n - 1) {
                            return input;
                        }
                    }
                }

                //check anti diagonal
                if (x + y == n - 1) {
                    for (int i = 0; i < n; i++) {
                        if (!board[i][(n - 1) - i].equals(input))
                            break;
                        if (i == n - 1) {
                            return input;
                        }
                    }
                }
            }
        }
        return "";
    }
}
