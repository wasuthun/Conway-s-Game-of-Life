import junit.framework.*;

public class BoardTest extends TestCase {
    private Board board;


    public void setUp() {
        board = new Board(20);
    }

    public void testInitializeCells() {
        for (int i = 0; i < 20; i++) {
            for (int j = 0; j < 20; j++) {
                assertEquals(false, board.getCells()[i][j].isAlive());
            }
        }
    }

    public void testCountNeighbors() {
        board.setCellLive(10, 10);
        assertEquals(1, board.countNeighbors(9, 9));
    }

}