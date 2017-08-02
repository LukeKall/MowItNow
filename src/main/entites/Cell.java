package main.entites;

/**
 * Cellule d'une pelouse
 */
public class Cell {

    private Coordonnees coordonnees;
    private boolean isTaken;

    public Cell(Coordonnees coordonnees) {
        this.coordonnees = coordonnees;
    }

    public boolean isTaken() {
        return isTaken;
    }

    public void setTaken(boolean isTaken){
        this.isTaken = isTaken;
    }

    /**
     * Lock une cellule
     * @return
     */
    public Cell lock(){
        isTaken = true;
        return this;
    }

    /**
     * Delock une cellule
     * @return
     */
    public Cell unlock(){
        isTaken = false;
        return this;
    }

    public Coordonnees getCoordonnees() {
        return coordonnees;
    }
}
