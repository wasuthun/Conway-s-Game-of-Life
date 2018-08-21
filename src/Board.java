public class Board {

    private Cell[][] cells;

    public int getLiveCount() {
        int count = 0;
        for (int i = 0; i < cells.length; i++)
            for (int j = 0; j < cells.length; j++)
                if (cells[i][j].isAlive())
                    count++;
        return count;
    }

    public void initializeCells(int dimension) {
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

    public Cell getCell(int row, int col) {
        return this.cells[row][col];
    }


    public void setCellLive(int row, int col) {
        cells[row][col].setAlive(true);
    }

    public void setCellDie(int row, int col) {
        cells[row][col].setAlive(false);
    }

    public void nextGeneration() {
        // Decide the fate of each cell
        for (int row = 0; row < cells.length; ++row) {
            for (int col = 0; col < cells[row].length; ++col) {
                final int numNeighbors = countNeighbors(row, col);
                // If under-populated or over-populated, cell dies
                if ((numNeighbors < 2) || (numNeighbors > 3)) {
                    setCellDie(row, col);
                }
                // No change
                if (numNeighbors == 2) {
                }
                // Cell stays alive, or a new cell is born
                if (numNeighbors == 3) {
                    setCellLive(row, col);
                }
            }
        }
    }


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
