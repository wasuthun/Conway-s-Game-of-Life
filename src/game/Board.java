package game;

public class Board {

    private Cell[][] cells;
    private int dimension;

    public int getLiveCount() {
        int count = 0;
        for (int row = 0; row < dimension; row++)
            for (int col = 0; col < dimension; col++)
                if (isCellAliveAt(row, col))
                    count++;
        return count;
    }

    public Board(int dimension) {
        this.dimension = dimension;
        cells = new Cell[dimension][dimension];
        initializeCells();
    }

    public void initializeCells() {
        cells = new Cell[dimension][dimension];
        for (int i = 0; i < dimension; i++)
            for (int j = 0; j < dimension; j++)
                cells[i][j] = new Cell();
    }

    public Cell[][] getCells() {
        return cells;
    }

    public Cell getCellAt(int row, int col) {
        return cells[row][col];
    }

    public boolean isCellAliveAt(int row, int column) {
        return cells[row][column].isAlive();
    }

    public void setCellLiveAt(int row, int column) {
        cells[row][column].setAlive(true);
    }

    public void setCellDieAt(int row, int column) {
        cells[row][column].setAlive(false);
    }

    private boolean hasNeighborAt(int row, int column) {
        return isNotOutOfBound(row, column) && isCellAliveAt(row, column);
    }

    private boolean isNotOutOfBound(int row, int column) {
        return (row >= 0 && column >= 0 && row < cells.length && column < cells.length);
    }

    private boolean isOffsetNotLocationItself(int offsetRow, int offsetColumn) {
        return (offsetRow != 0 || offsetColumn != 0);
    }

    public int countNeighbors(int row, int col) {
        int numNeighbors = 0;
        // check all directions around.
        for (int rowOffset = -1; rowOffset <= 1; rowOffset++)
            for (int columnOffset = -1; columnOffset <= 1; columnOffset++)
                if (isOffsetNotLocationItself(rowOffset, columnOffset) && hasNeighborAt(row + rowOffset, col + columnOffset))
                    numNeighbors++;
        return numNeighbors;
    }
}

