import java.util.Random;

public class Main {
    public static void main(String[] arg) {
        Game g = new Game(20);
        // g.printGame();
        Random rand = new Random();

        for (int i = 0; i < 20; i++) {
            for (int j = 0; j < 20; j++) {
                g.getBoard().getBlock()[i][j].setAlive(rand.nextBoolean());
            }
        }
        g.printGame();
        System.out.println("====================================");
        for (int i = 1; i < 30; i++) {
            g.nextGeneration();
            g.printGame();
            System.out.println("====================================");
        }


    }

}
