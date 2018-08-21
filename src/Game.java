public class Game {

    private Board board;
    public int dimension = 20;

    public Game(int dimension) {
        this.dimension = dimension;
        board = new Board();
        board.initializeCells(dimension);
    }

    public int getCountCellAlive() {
        return board.getLiveCount();
    }

    public int getCountCellNotAlive() {
        int count = 0;
        Cell[][] currentBlock = board.getCells();
        for (int i = 0; i < 20; i++) {
            for (int j = 0; j < 20; j++) {
                if (!currentBlock[i][j].isAlive())
                    count++;
            }
        }
        return count;
    }

    public void toggleCellAlive(int row, int col) {
        if (isCellAlive(row, col))
            board.setCellDie(row, col);
        else
            board.setCellLive(row, col);
    }

    private boolean isCellAlive(int row, int col) {
        return board.getCell(row, col).isAlive();
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
