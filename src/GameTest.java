import junit.framework.TestCase;

public class GameTest extends TestCase {
    private Game g;

    public void setUp() {
        g = new Game(20);
    }

    public void testNoOneAlive() {
        assertEquals(0, g.getCountCellAlive());
        assertEquals(400, g.getCountCellNotAlive());
    }

    public void testSingleCellShouldDieInNextIteration() {
        g.setAlive(0, 0);
        assertEquals(1, g.getCountCellAlive());
        g.nextGeneration();
        assertEquals(0, g.getCountCellAlive());
    }

}
