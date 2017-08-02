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
            throw new MowItNowException("Les limites de la pelouse ne peuvent pas être négatives.");
        }
        this.xLimit = xLimit;
        this.yLimit = yLimit;
        buildGrid();
    }

    public Cell[][] getGrid() {
        return grid;
    }

    public int getxLimit() {
        return xLimit;
    }

    public int getyLimit() {
        return yLimit;
    }

    /**
     * Crée le tableau de cellules
     */
    private void buildGrid(){
        grid = new Cell[xLimit + 1][yLimit + 1];
        for(int i = 0; i <= xLimit; i++){
            for(int j = 0; j <= yLimit; j++){
                grid[i][j] = new Cell(new Coordonnees(i, j));
            }
        }
    }

    /**
     * Renvoie la cellule aux coordonnées demandées
     * @param coordonnees
     * @return
     */
    public Cell getCell(Coordonnees coordonnees){
        try {
            return grid[coordonnees.getX()][coordonnees.getY()];
        } catch(IndexOutOfBoundsException e){
            return null;
        }
    }

    /**
     * Renvoie la prochaine cellule libre en fonction de l'orientation
     * @param cell
     * @param orientation
     * @return
     */
    public Cell getNextFreeCell(Cell cell, Orientation orientation){
        try {
            Cell newCell = grid[cell.getCoordonnees().getX() + orientation.getxDirection()][cell.getCoordonnees().getY() + orientation.getyDirection()];
            return newCell.isTaken() ? cell : newCell;
        } catch(IndexOutOfBoundsException e){
            return cell;
        }
    }
}
