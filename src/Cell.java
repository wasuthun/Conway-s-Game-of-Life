public class Cell {
    private boolean aliveState;

    public Cell() {
        this.aliveState = false;
    }

    public boolean isAlive() {
        return aliveState;
    }

    public void setAlive(boolean isAlive) {
        this.aliveState = isAlive;
    }

    public void nextState() {
        this.aliveState = !this.aliveState;
    }

}
