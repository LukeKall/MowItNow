package main.entites;


import main.MowItNowException;

/**
 * Tondeuse
 */
public class Mower {

    private Orientation orientation;
    private Lawn lawn;
    private Cell actualCell;

    /**
     * Constructeur
     * @param orientation
     * @param lawn
     * @param actualCell
     * @throws MowItNowException
     */
    public Mower(Orientation orientation, Lawn lawn, Cell actualCell) throws MowItNowException {
        if(orientation == null || lawn == null || actualCell == null){
            throw new MowItNowException("Une tondeuse ne pas être crée sans orientation, pelouse ou cellule de départ.");
        }
        if(actualCell.isTaken()){
            throw new MowItNowException("Une tondeuse ne pas être placée sur une cellule déjà prise.");
        }
        this.orientation = orientation;
        this.lawn = lawn;
        this.actualCell = actualCell.lock();
    }

    public Orientation getOrientation() {
        return orientation;
    }

    public Lawn getLawn() {
        return lawn;
    }

    public Cell getActualCell() {
        return actualCell;
    }

    /**
     * Exécute une instruction
     * @param instruction
     * @throws MowItNowException
     */
    public void executeInstruction(Instruction instruction) throws MowItNowException {
        if(instruction == null){
            throw new MowItNowException("Impossible d'exécuter une instruction null");
        }
        switch(instruction){
            case GO:
                move();
                break;
            case RIGHT:
                setOrientation(orientation.getRight());
                break;
            case LEFT:
                setOrientation(orientation.getLeft());
                break;
        }
    }

    /**
     * Effectue un mouvement
     */
    public void move(){
        Cell newCell = lawn.getNextFreeCell(actualCell, orientation);
        actualCell.unlock();
        actualCell = newCell.lock();
    }

    /**
     * Change l'orienration
     * @param orientation
     */
    public void setOrientation(Orientation orientation){
        this.orientation = orientation;
    }

    @Override
    public String toString(){
        return actualCell.getCoordonnees().getX() + " " + actualCell.getCoordonnees().getY() + " " + orientation.getValue();
    }
}
