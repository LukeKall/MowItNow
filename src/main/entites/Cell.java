package main.entites;


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

    public Cell lock(){
        isTaken = true;
        return this;
    }

    public Cell unlock(){
        isTaken = false;
        return this;
    }

    public Coordonnees getCoordonnees() {
        return coordonnees;
    }
}
