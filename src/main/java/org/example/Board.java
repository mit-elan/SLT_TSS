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

    public char[][] getGrid() {
        return grid;
    }

}
