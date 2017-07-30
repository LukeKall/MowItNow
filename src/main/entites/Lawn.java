package main.entites;

import main.MowItNowException;

/**
 * Created by archet on 28/07/2017.
 */
public class Lawn {

    private Cell[][] grid;
    private int xLimit;
    private int yLimit;

    public Lawn(int xLimit, int yLimit) throws MowItNowException {
        if(xLimit < 0 || yLimit < 0){
            throw new MowItNowException();
        }
        this.xLimit = xLimit;
        this.yLimit = yLimit;
        buildGrid();
    }

    private void buildGrid(){
        grid = new Cell[xLimit + 1][yLimit + 1];
        for(int i = 0; i <= xLimit; i++){
            for(int j = 0; j <= yLimit; j++){
                grid[i][j] = new Cell(new Coordonnees(i, j));
            }
        }
    }

    public Cell getCell(Coordonnees coordonnees){
        try {
            return grid[coordonnees.getX()][coordonnees.getY()];
        } catch(IndexOutOfBoundsException e){
            return null;
        }
    }

    public Cell getNextFreeCell(Cell cell, Orientation orientation){
        try {
            Cell newCell = grid[cell.getCoordonnees().getX() + orientation.getxDirection()][cell.getCoordonnees().getY() + orientation.getyDirection()];
            return newCell.isTaken() ? cell : newCell;
        } catch(IndexOutOfBoundsException e){
            return cell;
        }
    }
}
