package test;

import game.Game;
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
        g.nextGeneration();
        assertEquals(false, g.isCellAliveAt(0, 0));
    }

    public void testLiveCellOfTwoNeighborsShouldBeStill() {
        g.setCellLiveAt(0, 0);
        g.setCellLiveAt(1, 0);
        g.setCellLiveAt(0, 1);
        g.nextGeneration();
        assertEquals(true, g.isCellAliveAt(0, 0));
        assertEquals(true, g.isCellAliveAt(0, 1));
        assertEquals(true, g.isCellAliveAt(1, 0));
    }

    public void testDeadCellOfThreeNeighborsShouldBeBorn() {
        g.setCellLiveAt(0, 0);
        g.setCellLiveAt(1, 0);
        g.setCellLiveAt(0, 1);
        g.nextGeneration();
        assertEquals(true, g.isCellAliveAt(0, 0));
        assertEquals(true, g.isCellAliveAt(0, 1));
        assertEquals(true, g.isCellAliveAt(1, 0));
        assertEquals(true, g.isCellAliveAt(1, 1));
    }

    public void testLiveCellOfMoreThanThreeNeighborsShouldBeDead() {
        g.setCellLiveAt(0, 0);
        g.setCellLiveAt(1, 0);
        g.setCellLiveAt(0, 1);
        g.setCellLiveAt(1, 1);
        g.setCellLiveAt(2, 0);
        g.nextGeneration();
        assertEquals(false, g.isCellAliveAt(1, 1));
        assertEquals(false, g.isCellAliveAt(1, 0));
    }

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

    public void testBeehiveShouldBeStillLife() {
        g.setCellLiveAt(2, 4);
        g.setCellLiveAt(2, 5);
        g.setCellLiveAt(3, 3);
        g.setCellLiveAt(3, 6);
        g.setCellLiveAt(4, 4);
        g.setCellLiveAt(4, 5);
        g.nextGeneration();
        assertEquals(g.isCellAliveAt(2, 4), true);
        assertEquals(g.isCellAliveAt(2, 5), true);
        assertEquals(g.isCellAliveAt(3, 3), true);
        assertEquals(g.isCellAliveAt(3, 6), true);
        assertEquals(g.isCellAliveAt(4, 4), true);
        assertEquals(g.isCellAliveAt(4, 5), true);
        assertEquals(6, g.getCountCellAlive());
    }

    public void testLoafShouldBeStillLife() {
        g.setCellLiveAt(2, 4);
        g.setCellLiveAt(2, 5);
        g.setCellLiveAt(3, 3);
        g.setCellLiveAt(3, 6);
        g.setCellLiveAt(4, 4);
        g.setCellLiveAt(4, 6);
        g.setCellLiveAt(5, 5);
        g.nextGeneration();
        assertEquals(g.isCellAliveAt(2, 4), true);
        assertEquals(g.isCellAliveAt(2, 5), true);
        assertEquals(g.isCellAliveAt(3, 3), true);
        assertEquals(g.isCellAliveAt(3, 6), true);
        assertEquals(g.isCellAliveAt(4, 4), true);
        assertEquals(g.isCellAliveAt(5, 5), true);
        assertEquals(g.isCellAliveAt(4, 6), true);
        assertEquals(7, g.getCountCellAlive());
    }

    public void testBlinkerShouldBeOscillators() {
        g.setCellLiveAt(2, 4);
        g.setCellLiveAt(3, 4);
        g.setCellLiveAt(4, 4);
        g.nextGeneration();
        assertEquals(g.isCellAliveAt(3, 4), true);
        assertEquals(g.isCellAliveAt(3, 3), true);
        assertEquals(g.isCellAliveAt(3, 5), true);
        assertEquals(3, g.getCountCellAlive());
    }

    public void testToadShouldBeOscillators() {
        g.setCellLiveAt(2, 4);
        g.setCellLiveAt(3, 4);
        g.setCellLiveAt(3, 3);
        g.setCellLiveAt(2, 5);
        g.setCellLiveAt(3, 5);
        g.setCellLiveAt(2, 6);
        g.nextGeneration();
        assertEquals(g.isCellAliveAt(2, 6), true);
        assertEquals(g.isCellAliveAt(3, 6), true);
        assertEquals(g.isCellAliveAt(2, 6), true);
        assertEquals(g.isCellAliveAt(4, 4), true);
        assertEquals(g.isCellAliveAt(3, 3), true);
        assertEquals(g.isCellAliveAt(2, 3), true);
        assertEquals(6, g.getCountCellAlive());
    }

    public void testSpaceShipsGlider() {
        g.setCellLiveAt(2, 4);
        g.setCellLiveAt(2, 6);
        g.setCellLiveAt(3, 5);
        g.setCellLiveAt(3, 6);
        g.setCellLiveAt(1, 6);
        g.nextGeneration();
        assertEquals(g.isCellAliveAt(1, 5), true);
        assertEquals(g.isCellAliveAt(2, 7), true);
        assertEquals(g.isCellAliveAt(2, 6), true);
        assertEquals(g.isCellAliveAt(3, 5), true);
        assertEquals(g.isCellAliveAt(3, 6), true);
        assertEquals(5, g.getCountCellAlive());
    }
}