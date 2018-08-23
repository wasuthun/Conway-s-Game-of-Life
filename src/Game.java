public class Game {

    private Board board;
    public int dimension = 20; // default dimension

    public Game(int dimension) {
        this.dimension = dimension;
        board = new Board(dimension);
    }

    public int getCountCellAlive() {
        return board.getLiveCount();
    }

    public void setCellLive(int row, int col) {
        board.setCellLive(row, col);
    }

    public void setCellDie(int row, int col) {
        board.setCellDie(row, col);
    }

    public boolean isCellAlive(int row, int col) {
        return board.getCells()[row][col].isAlive();
    }

    public Board getBoard() {
        return board;
    }

    public void nextGeneration() {
        board.nextGeneration();
    }

    public void printGame() {
        for (int i = 0; i < dimension; i++) {
            for (int j = 0; j < dimension; j++) {
                if (isCellAlive(i, j)) {
                    System.out.print("■");
                } else {
                    System.out.print("□");
                }
            }
            System.out.println();
        }
    }

}
