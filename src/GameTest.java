import junit.framework.TestCase;

public class GameTest extends TestCase {
  private Game g;
   public void setUp(){
        g=new Game();
    }
    public void testNoOneAlive(){
       assertEquals(0,g.getCellAlive());
       assertEquals(400,g.getCellNotAlive());
    }
    public void testNextGenerationWithDie(){
       g.setAlive(0,0);
       assertEquals(1,g.getCellAlive());
       g.nextGeneration();
       assertEquals(0,g.getCellAlive());
    }
    public void testCellOfTwoNeighbors(){
        g.setAlive(0,0);
        g.setAlive(1,0);
        g.setAlive(0,1);
        assertEquals(3,g.getCellAlive());
        g.nextGeneration();
        assertEquals(4,g.getCellAlive());
    }
    public void testCellOfThreeNeighbors(){
        g.setAlive(0,0);
        g.setAlive(1,0);
        g.setAlive(0,1);
        g.setAlive(1,1);
        assertEquals(4,g.getCellAlive());
        g.nextGeneration();
        assertEquals(4,g.getCellAlive());
    }
    public void testCellOfMoreThanThreeNeighbors(){
        g.setAlive(0,0);
        g.setAlive(1,0);
        g.setAlive(0,1);
        g.setAlive(1,1);
        g.setAlive(2,0);
        assertEquals(5,g.getCellAlive());
        g.nextGeneration();
        assertEquals(3,g.getCellAlive());
    }

}
