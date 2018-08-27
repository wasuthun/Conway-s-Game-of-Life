package test;

import game.Cell;
import junit.framework.TestCase;

public class CellTest extends TestCase {
    private Cell cell;

    public void setUp() {
        cell = new Cell();
    }

    public void testDefaultAliveCellShouldBeDead() {
        assertEquals(false, cell.isAlive());
    }

    public void testSetCellAliveShouldBeLive() {
        cell.setAlive(true);
        assertEquals(true, cell.isAlive());
    }

    public void testSetCellDeadShouldBeDead() {
        cell.setAlive(false);
        assertEquals(false, cell.isAlive());
    }

    public void testDeadCellToNextStateShouldBeLive() {
        cell.setAlive(false);
        cell.nextState();
        assertEquals(true, cell.isAlive());
    }

    public void testLiveCellToNextStateShouldBeDead() {
        cell.setAlive(true);
        cell.nextState();
        assertEquals(false, cell.isAlive());
    }
}
