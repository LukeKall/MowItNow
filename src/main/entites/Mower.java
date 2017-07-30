package main.entites;


import main.MowItNowException;

public class Mower {

    private Orientation orientation;
    private Lawn lawn;
    private Cell actualCell;

    public Mower(Orientation orientation, Lawn lawn, Cell actualCell) throws MowItNowException {
        if(orientation == null || lawn == null || actualCell == null){
            throw new MowItNowException();
        }
        if(actualCell.isTaken()){
            throw new MowItNowException();
        }
        this.orientation = orientation;
        this.lawn = lawn;
        this.actualCell = actualCell.lock();
    }

    public void executeInstruction(Instruction instruction){
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

    public void move(){
        Cell newCell = lawn.getNextFreeCell(actualCell, orientation);
        actualCell.unlock();
        actualCell = newCell.lock();
    }

    public void setOrientation(Orientation orientation){
        this.orientation = orientation;
    }

    @Override
    public String toString(){
        return actualCell.getCoordonnees().getX() + " " + actualCell.getCoordonnees().getY() + " " + orientation.getValue();
    }
}
