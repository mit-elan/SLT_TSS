package org.example;

public class Board {
    private final char[][] grid;

    public Board() {
        grid = new char[3][3];
        // initialisieren mit leeren Feldern
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
                grid[i][j] = ' ';
    }

    public boolean isCellEmpty(int row, int col) {
        return grid[row][col] == ' ';
    }

    public boolean place(int row, int col, char marker) {
        if (isCellEmpty(row, col)) {
            grid[row][col] = marker;
            return true;
        }
        return false;
    }

    public boolean hasWinner(char marker) {
        // Zeilen und Spalten
        for (int i = 0; i < 3; i++) {
            if (grid[i][0] == marker && grid[i][1] == marker && grid[i][2] == marker) return true;
            if (grid[0][i] == marker && grid[1][i] == marker && grid[2][i] == marker) return true;
        }
        // Diagonalen
        if (grid[0][0] == marker && grid[1][1] == marker && grid[2][2] == marker) return true;
        if (grid[0][2] == marker && grid[1][1] == marker && grid[2][0] == marker) return true;

        return false;
    }

    public boolean isFull() {
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
                if (grid[i][j] == ' ') return false;
        return true;
    }

    public char[][] getGrid() {
        return grid;
    }

    public void printBoard() {
        System.out.println("╔═══╦═══╦═══╗");
        for (int i = 0; i < 3; i++) {
            System.out.print("║ ");
            for (int j = 0; j < 3; j++) {
                System.out.print(grid[i][j]);
                System.out.print(" ║ ");
            }
            System.out.println();
            if (i < 2) System.out.println("╠═══╬═══╬═══╣");
        }
        System.out.println("╚═══╩═══╩═══╝");
    }

}