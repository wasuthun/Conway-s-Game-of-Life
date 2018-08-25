public class Board {

    private Cell[][] cells;
    private int dimension;
    private int neighborOffsets[][] = {{-1, -1}, {-1, 0}, {-1, 1}, {0, -1}, {0, 1}, {1, -1}, {1, 0}, {1, 1}};


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

    private boolean hasNeighbor(int row, int column) {
        return isValidPosition(row, column) && isCellAliveAt(row, column);
    }

    private boolean isValidPosition(int row, int column) {
        return (row >= 0 && column >= 0 && row < cells.length && column < cells.length);
    }

    public int countNeighbors(int row, int col) {
        int numNeighbors = 0;
        for (int i = 0; i < neighborOffsets.length; i++) {
            int rowOffset = neighborOffsets[i][0];
            int columnOffset = neighborOffsets[i][1];
            int lookupRow = row + rowOffset;
            int lookupColumn = col + columnOffset;
            if (hasNeighbor(lookupRow, lookupColumn))
                numNeighbors++;
        }
        return numNeighbors;
    }
}