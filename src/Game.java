import java.util.ArrayList;
import java.util.List;

public class Game {

    private Board board;
    public int dimension = 20; // default dimension.

    public Game(int dimension) {
        this.dimension = dimension;
        board = new Board(dimension);
    }

    public int getCountCellAlive() {
        return board.getLiveCount();
    }

    public void setCellLiveAt(int row, int col) {
        board.setCellLiveAt(row, col);
    }

    public void setCellDieAt(int row, int col) {
        board.setCellDieAt(row, col);
    }

    public boolean isCellAliveAt(int row, int col) {
        return board.isCellAliveAt(row, col);
    }

    public Board getBoard() {
        return board;
    }

    public void nextGeneration() {
        List<Cell> toBeChanged = new ArrayList<>();
        for (int row = 0; row < dimension; ++row)
            for (int col = 0; col < dimension; ++col) {
                int numNeighbors = board.countNeighbors(row, col);
                Cell cell = board.getCellAt(row, col);
                if (cell.isAlive()) {
                    if (isUnderPopulation(numNeighbors) || isOverpopulation(numNeighbors))
                        toBeChanged.add(cell);
                } else {
                    if (isReproduction(numNeighbors))
                        toBeChanged.add(cell);
                }
            }
        applyTheChangeOfCells(toBeChanged);
    }

    private void applyTheChangeOfCells(List<Cell> cells) {
        for (Cell eachCell : cells)
            eachCell.nextState();
    }

    private boolean isReproduction(int numNeighbors) {
        return numNeighbors == 3;
    }

    private boolean isUnderPopulation(int numNeighbors) {
        return numNeighbors < 2;
    }

    private boolean isOverpopulation(int numNeighbors) {
        return numNeighbors > 3;
    }

    public void printGame() {
        for (int i = 0; i < dimension; i++) {
            for (int j = 0; j < dimension; j++)
                if (isCellAliveAt(i, j))
                    System.out.print("■");
                else
                    System.out.print("□");
            System.out.println();
        }
    }

}
