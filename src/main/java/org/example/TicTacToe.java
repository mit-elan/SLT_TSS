package org.example;

import java.util.Scanner;

public class TicTacToe {
    private final Board board;
    private final Player playerX;
    private final Player playerO;
    private Player currentPlayer;

    public TicTacToe() {
        board = new Board();
        playerX = new Player('X');
        playerO = new Player('O');
        currentPlayer = playerX;
    }

    public void switchCurrentPlayer() {
        currentPlayer = (currentPlayer == playerX) ? playerO : playerX;
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Current Player: " + currentPlayer.getMarker());
            System.out.print("row (0-2): ");
            int row = scanner.nextInt();
            System.out.print("column (0-2): ");
            int col = scanner.nextInt();

            if (board.place(row, col, currentPlayer.getMarker())) {
                board.printBoard();

                if (board.hasWinner(currentPlayer.getMarker())) {
                    System.out.println("Player " + currentPlayer.getMarker() + " wins!");
                    break;
                }

                if (board.isFull()) {
                    System.out.println("It's a draw!");
                    break;
                }

                switchCurrentPlayer();
            } else {
                System.out.println("Invalid move, cell already taken.\n");
            }
        }

    }

}