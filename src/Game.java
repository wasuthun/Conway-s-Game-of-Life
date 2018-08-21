public class Game {

    private Board board;
    public int dimension = 20;

    public Game(int dimension) {
        this.dimension = dimension;
        board = new Board();
        board.initializeCells(dimension);
    }

    public int getCountCellAlive() {
        int count = 0;
        Cell[][] curBlock = board.getCells();
        for (int i = 0; i < dimension; i++) {
            for (int j = 0; j < dimension; j++) {
                if (curBlock[i][j].isAlive())
                    count++;
            }
        }
        return count;
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

    public void setCellAlive(int row, int col) {
        board.setCellAlive(row, col);
    }

    public void setCellDie(int row, int col) {
        board.setCellDie(row, col);
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
                if (board.getCells()[i][j].isAlive()) {
                    System.out.print("■");
                } else {
                    System.out.print("□");
                }
            }
            System.out.println();
        }
    }

}
