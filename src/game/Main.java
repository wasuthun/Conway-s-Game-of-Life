package game;

public class Main {
    public static void main(String[] arg) {
        Game g = new Game(20);
        g.randomBoard();
        g.printGame();
        System.out.println("====================================");
        for (int i = 0; i < 30; i++) {
            g.nextGeneration();
            g.printGame();
            System.out.println("====================================");
        }
    }
}
