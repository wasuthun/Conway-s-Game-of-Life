public class Board {
    private Cell [][] generation;
    public void init(){
        generation=new Cell[20][20];
        for (int i = 0; i < 20; i++) {
            for (int j =0;j < 20;j++){
                generation[i][j]=new Cell();
            }
        }
    }
    public Cell[][] getBlock() {
        return generation;
    }
    public void setAlive(int row,int col){
        generation[row][col].setAlive(true);
    }
    public int countNeighbors(int row, int col) {
        int numNeighbors = 0;

        // Look NW
        if ((row - 1 >= 0) && (col - 1 >= 0)) {
            numNeighbors = generation[row - 1][col - 1].getIsAlive() ? numNeighbors + 1 : numNeighbors;
        }
        // Look W
        if ((row >= 0) && (col - 1 >= 0)) {
            numNeighbors = generation[row][col - 1].getIsAlive() ? numNeighbors + 1 : numNeighbors;
        }
        // Look SW
        if ((row + 1 < generation.length) && (col - 1 >= 0)) {
            numNeighbors = generation[row + 1][col - 1].getIsAlive() ? numNeighbors + 1 : numNeighbors;
        }
        // Look S
        if ((row + 1 < generation.length) && (col < generation[0].length)) {
            numNeighbors = generation[row + 1][col].getIsAlive() ? numNeighbors + 1 : numNeighbors;
        }
        // Look SE
        if ((row + 1 < generation.length) && (col + 1 < generation[0].length)) {
            numNeighbors = generation[row + 1][col + 1].getIsAlive() ? numNeighbors + 1 : numNeighbors;
        }
        // Look E
        if ((row < generation.length) && (col + 1 < generation[0].length)) {
            numNeighbors = generation[row][col + 1].getIsAlive() ? numNeighbors + 1 : numNeighbors;
        }
        // Look NE
        if ((row - 1 >= 0) && (col + 1 < generation[0].length)) {
            numNeighbors = generation[row - 1][col + 1].getIsAlive() ? numNeighbors + 1 : numNeighbors;
        }
        // Look N
        if ((row - 1 >= 0) && (col < generation[0].length)) {
            numNeighbors = generation[row - 1][col].getIsAlive() ? numNeighbors + 1 : numNeighbors;
        }

        return numNeighbors;
    }
}
