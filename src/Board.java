public class Board {

    private Cell[][] cells;
    private int liveCount = 0;
    private int dimension;

    public int getLiveCount() {
        return this.liveCount;
    }

    public Board(int dimension) {
        this.dimension = dimension;
        initializeCells();
    }

    public void initializeCells() {
        cells = new Cell[dimension][dimension];
        for (int i = 0; i < dimension; i++) {
            for (int j = 0; j < dimension; j++) {
                cells[i][j] = new Cell();
            }
        }
    }

    public Cell[][] getCells() {
        return cells;
    }

    private boolean isCellAlive(int row, int column) {
        return this.getCells()[row][column].isAlive();
    }


    public void setCellLive(int row, int column) {
        cells[row][column].setAlive(true);
        liveCount++;
    }

    public void setCellDie(int row, int column) {
        cells[row][column].setAlive(false);
        liveCount--;
    }

    public void nextGeneration() {
        // Decide the fate of each cell
        for (int row = 0; row < dimension; ++row) {
            for (int col = 0; col < dimension; ++col) {
                final int numNeighbors = countNeighbors(row, col);
                // If under-populated or over-populated, cell dies.
                if (isCellAlive(row, col)) {
                    if ((numNeighbors < 2) || (numNeighbors > 3))
                        setCellDie(row, col);
                } else {
                    if (numNeighbors == 3)
                        setCellLive(row, col);
                }
            }
        }
    }

//    private boolean isWestOutOfBound(int col) {
//        return (col - 1 >= 0);
//    }
//
//    private boolean isNorthOutOfBound(int row) {
//        return (row - 1 >= 0);
//    }
//
//    private boolean isSouthOutOfBound(int row) {
//        return (row + 1 < dimension);
//    }
//
//    private boolean isEastOutOfBound(int col) {
//        return (col + 1 < dimension);
//    }

    public int countNeighbors(int row, int col) {
        int numNeighbors = 0;
        // Look NW
        if ((row - 1 >= 0) && (col - 1 >= 0)) {
            numNeighbors = cells[row - 1][col - 1].isAlive() ? numNeighbors + 1 : numNeighbors;
        }
        // Look W
        if ((row >= 0) && (col - 1 >= 0)) {
            numNeighbors = cells[row][col - 1].isAlive() ? numNeighbors + 1 : numNeighbors;
        }
        // Look SW
        if ((row + 1 < cells.length) && (col - 1 >= 0)) {
            numNeighbors = cells[row + 1][col - 1].isAlive() ? numNeighbors + 1 : numNeighbors;
        }
        // Look S
        if ((row + 1 < cells.length) && (col < cells[0].length)) {
            numNeighbors = cells[row + 1][col].isAlive() ? numNeighbors + 1 : numNeighbors;
        }
        // Look SE
        if ((row + 1 < cells.length) && (col + 1 < cells[0].length)) {
            numNeighbors = cells[row + 1][col + 1].isAlive() ? numNeighbors + 1 : numNeighbors;
        }
        // Look E
        if ((row < cells.length) && (col + 1 < cells[0].length)) {
            numNeighbors = cells[row][col + 1].isAlive() ? numNeighbors + 1 : numNeighbors;
        }
        // Look NE
        if ((row - 1 >= 0) && (col + 1 < cells[0].length)) {
            numNeighbors = cells[row - 1][col + 1].isAlive() ? numNeighbors + 1 : numNeighbors;
        }
        // Look N
        if ((row - 1 >= 0) && (col < cells[0].length)) {
            numNeighbors = cells[row - 1][col].isAlive() ? numNeighbors + 1 : numNeighbors;
        }

        return numNeighbors;
    }
}
