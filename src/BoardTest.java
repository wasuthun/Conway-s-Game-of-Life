import junit.framework.*;
import static org.junit.Assert.*;

public class BoardTest extends TestCase {
    private Board g=new Board();

    public void setUp(){
        g.init();
    }

    public void testInitialize(){
        Cell [][] blank=new Cell[20][20];
        for (int i = 0; i < 20; i++) {
            for (int j = 0; j < 20; j++) {
                blank[i][j]=new Cell();
                assertEquals(g.getBlock()[i][j].getIsAlive(),blank[i][j].getIsAlive());
            }
        }
    }
    public void testCountNeighbors(){
        g.setAlive(10,10);
        assertEquals(1,g.countNeighbors(9,9));
    }

}
