package UnitTests;

import org.example.Board;
import org.junit.Test;

import static org.junit.Assert.*;

public class BoardTest {
    @Test
    public void testPlaceOnEmptyCell() {
        Board board = new Board();
        boolean success = board.place(0, 0, 'X');
        assertTrue(success);
        assertEquals('X', board.getGrid()[0][0]);
    }

    @Test
    public void testPlaceOnTakenCell() {
        Board board = new Board();
        board.place(0, 0, 'X');
        boolean success = board.place(0, 0, 'O');
        assertFalse(success);
        assertEquals('X', board.getGrid()[0][0]); // Wert bleibt 'X'
    }

    @Test
    public void testPrintBoardAfterMove() {
        Board board = new Board();
        board.place(1, 1, 'X');
        try {
            board.printBoard();
        } catch (Exception e) {
            fail("printBoard() should not throw exception, but threw: " + e.getMessage());
        }
    }

    @Test
    public void testWinRow() {
        Board board = new Board();
        board.place(0, 0, 'X');
        board.place(0, 1, 'X');
        board.place(0, 2, 'X');
        assertTrue(board.hasWinner('X'));
    }

    @Test
    public void testWinDiagonal() {
        Board board = new Board();
        board.place(0, 0, 'O');
        board.place(1, 1, 'O');
        board.place(2, 2, 'O');
        assertTrue(board.hasWinner('O'));
    }

    @Test
    public void testDraw() {
        Board board = new Board();
        char[][] filled = {
                {'X','O','X'},
                {'X','O','O'},
                {'O','X','X'}
        };
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
                board.place(i, j, filled[i][j]);

        assertTrue(board.isFull());
        assertFalse(board.hasWinner('X'));
        assertFalse(board.hasWinner('O'));
    }



}
