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
    public void testPrintBoardAfterMove_JUnit4() {
        Board board = new Board();
        board.place(1, 1, 'X');
        try {
            board.printBoard();
        } catch (Exception e) {
            fail("printBoard() should not throw exception, but threw: " + e.getMessage());
        }
    }

}
