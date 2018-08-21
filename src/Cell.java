public class Cell {
    private boolean alive;

    public Cell() {
        this.alive = false;
    }

    public boolean isAlive() {
        return alive;
    }

    public void setAlive(boolean isAlive) {
        this.alive = isAlive;
    }
}
