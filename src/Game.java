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
        Cell[][] curBlock = board.getBlock();
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
        Cell[][] curBlock = board.getBlock();
        for (int i = 0; i < 20; i++) {
            for (int j = 0; j < 20; j++) {
                if (!curBlock[i][j].isAlive())
                    count++;
            }
        }
        return count;
    }

    public void setAlive(int row, int col) {
        board.setAlive(row, col);
    }

    public Board getBoard() {
        return board;
    }

    public Cell[][] nextGeneration() {
        final Cell[][] nextGeneration = cloneGeneration(board.getBlock());
        // Decide the fate of each cell
        for (int row = 0; row < board.getBlock().length; ++row) {
            for (int col = 0; col < board.getBlock()[row].length; ++col) {
                final int numNeighbors = board.countNeighbors(row, col);
                // If under-populated or over-populated, cell dies
                if ((numNeighbors < 2) || (numNeighbors > 3)) {
                    nextGeneration[row][col].setAlive(false);
                }
                // No change
                if (numNeighbors == 2) {
                }
                // Cell stays alive, or a new cell is born
                if (numNeighbors == 3) {
                    nextGeneration[row][col].setAlive(true);
                }
            }
        }
        return nextGeneration;
    }

    private Cell[][] cloneGeneration(Cell originalGeneration[][]) {
        Cell[][] newGeneration = new Cell[dimension][dimension];
        for (int row = 0; row < originalGeneration.length; row++) {
            for (int col = 0; col < originalGeneration.length; col++) {
                newGeneration[row][col] = originalGeneration[row][col];
            }
        }
        return newGeneration;
    }

    public void printGame() {
        for (int i = 0; i < dimension; i++) {
            for (int j = 0; j < dimension; j++) {
                if (board.getBlock()[i][j].isAlive()) {
                    System.out.print("x");
                } else {
                    System.out.print("-");
                }
            }
            System.out.println();
        }
    }

}
