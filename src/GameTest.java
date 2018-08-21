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

}
