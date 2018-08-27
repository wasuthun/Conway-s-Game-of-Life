package test;

import game.Board;
import junit.framework.*;

public class BoardTest extends TestCase {
    private Board board;

    public void setUp() {
        board = new Board(20);
    }

    public void testInitializeCellsShouldBeAllDead() {
        for (int i = 0; i < 20; i++) {
            for (int j = 0; j < 20; j++) {
                assertEquals(false, board.isCellAliveAt(i, j));
            }
        }
    }

    public void testSingleCellShouldHaveZeroNeighbor() {
        board.setCellLiveAt(10, 10);
        assertEquals(0, board.countNeighbors(10, 10));
    }

    public void testCellInTheMiddleOf3x3ShouldHaveEightNeighbors() {
        board.setCellLiveAt(9, 9);
        board.setCellLiveAt(9, 10);
        board.setCellLiveAt(9, 11);
        board.setCellLiveAt(10, 9);
        board.setCellLiveAt(10, 10);
        board.setCellLiveAt(10, 11);
        board.setCellLiveAt(11, 9);
        board.setCellLiveAt(11, 10);
        board.setCellLiveAt(11, 11);
        assertEquals(8, board.countNeighbors(10, 10));
    }

    public void testSimpleCountNeighbors() {
        board.setCellLiveAt(9, 9);
        board.setCellLiveAt(9, 10);
        board.setCellLiveAt(9, 11);
        board.setCellLiveAt(10, 9);
        assertEquals(4, board.countNeighbors(10, 10));
        assertEquals(2, board.countNeighbors(10, 9));
        assertEquals(2, board.countNeighbors(9, 9));
        assertEquals(3, board.countNeighbors(9, 10));
    }

}
