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

    public void testCellOfTwoNeighbors() {
        g.setAlive(0, 0);
        g.setAlive(1, 0);
        g.setAlive(0, 1);
        assertEquals(3, g.getCountCellAlive());
        g.nextGeneration();
        assertEquals(4, g.getCountCellAlive());
    }

    public void testCellOfThreeNeighbors() {
        g.setAlive(0, 0);
        g.setAlive(1, 0);
        g.setAlive(0, 1);
        g.setAlive(1, 1);
        assertEquals(4, g.getCountCellAlive());
        g.nextGeneration();
        assertEquals(4, g.getCountCellAlive());
    }

    public void testCellOfMoreThanThreeNeighbors() {
        g.setAlive(0, 0);
        g.setAlive(1, 0);
        g.setAlive(0, 1);
        g.setAlive(1, 1);
        g.setAlive(2, 0);
        assertEquals(5, g.getCountCellAlive());
        g.nextGeneration();
        assertEquals(3, g.getCountCellAlive());
    }

}
