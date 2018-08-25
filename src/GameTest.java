import junit.framework.TestCase;

public class GameTest extends TestCase {
    private Game g;

    public void setUp() {
        g = new Game(20);
    }

    public void testNoOneAlive() {
        assertEquals(0, g.getCountCellAlive());
    }

    public void testSingleCellShouldDieInNextIteration() {
        g.setCellLiveAt(0, 0);
        assertEquals(1, g.getCountCellAlive());
        g.nextGeneration();
        assertEquals(0, g.getCountCellAlive());
    }

    public void testCellOfTwoNeighbors() {
        g.setCellLiveAt(0, 0);
        g.setCellLiveAt(1, 0);
        g.setCellLiveAt(0, 1);
        assertEquals(3, g.getCountCellAlive());
        g.nextGeneration();
        assertEquals(4, g.getCountCellAlive());
    }

    public void testCellOfThreeNeighbors() {
        g.setCellLiveAt(0, 0);
        g.setCellLiveAt(1, 0);
        g.setCellLiveAt(0, 1);
        g.setCellLiveAt(1, 1);
        assertEquals(4, g.getCountCellAlive());
        g.nextGeneration();
        assertEquals(4, g.getCountCellAlive());
    }

//    public void testCellOfMoreThanThreeNeighbors() {
//        g.setCellLiveAt(0, 0);
//        g.setCellLiveAt(1, 0);
//        g.setCellLiveAt(0, 1);
//        g.setCellLiveAt(1, 1);
//        g.setCellLiveAt(2, 0);
//        g.printGame();
//        assertEquals(5, g.getCountCellAlive());
//        System.out.println("******************************");
//        g.nextGeneration();
//        g.printGame();
//        assertEquals(3, g.getCountCellAlive());
//    }

    public void testBlinkerShouldBeOscillator() {
        g.setCellLiveAt(3, 5);
        g.setCellLiveAt(4, 5);
        g.setCellLiveAt(5, 5);
        g.nextGeneration();
        assertEquals(g.isCellAliveAt(4, 4), true);
        assertEquals(g.isCellAliveAt(4, 4), true);
        assertEquals(g.isCellAliveAt(4, 6), true);
        assertEquals(3, g.getCountCellAlive());
    }

    public void testBlockShouldBeStillLife() {
        g.setCellLiveAt(2, 4);
        g.setCellLiveAt(2, 5);
        g.setCellLiveAt(3, 4);
        g.setCellLiveAt(3, 5);
        g.nextGeneration();
        assertEquals(g.isCellAliveAt(2, 4), true);
        assertEquals(g.isCellAliveAt(2, 5), true);
        assertEquals(g.isCellAliveAt(3, 4), true);
        assertEquals(g.isCellAliveAt(3, 5), true);
        assertEquals(4, g.getCountCellAlive());
    }
}