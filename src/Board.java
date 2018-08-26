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

    private boolean hasNeighborAt(int row, int column) {
        return isValidPositionAt(row, column) && isCellAliveAt(row, column);
    }

    private boolean isValidPositionAt(int row, int column) {
        return (row >= 0 && column >= 0 && row < cells.length && column < cells.length);
    }

    public int countNeighbors(int row, int col) {
        int numNeighbors = 0;
        // check all directions around.
        for (Direction direction : Direction.values()) {
            int lookupRow = row + direction.rowOffset;
            int lookupColumn = col + direction.columnOffset;
            if (hasNeighborAt(lookupRow, lookupColumn))
                numNeighbors++;
        }
        return numNeighbors;
    }

    enum Direction {
        NORTHWEST(-1, -1),
        NORTH(0, -1),
        NORTHEAST(1, -1),
        EAST(1, 0),
        SOUTHEAST(1, 1),
        SOUTH(0, 1),
        SOUTHWEST(-1, 1),
        WEST(-1, 0);

        final int rowOffset;
        final int columnOffset;

        Direction(int rowOffset, int columnOffset) {
            this.rowOffset = rowOffset;
            this.columnOffset = columnOffset;
        }
    }
}

