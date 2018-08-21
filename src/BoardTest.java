import junit.framework.*;

import static org.junit.Assert.*;

public class BoardTest extends TestCase {
    private Board g = new Board();


    public void setUp() {
        g.initializeCells(20);
    }

    public void testInitializeCell() {
        for (int i = 0; i < 20; i++) {
            for (int j = 0; j < 20; j++) {
                assertEquals(false, g.getBlock()[i][j].isAlive());
            }
        }
    }

    public void testCountNeighbors() {
        g.setAlive(10, 10);
        assertEquals(1, g.countNeighbors(9, 9));
    }

}
