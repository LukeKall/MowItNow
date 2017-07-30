package main.entites;

/**
 * Classe de coordonnées
 */
public class Coordonnees {

    private int x;
    private int y;

    /**
     * Constructeur
     * @param x
     * @param y
     */
    public Coordonnees(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void addY(int i){
        this.y += i;
    }

    public void addX(int i){
        this.x += i;
    }
}
