package main.entites;

import java.util.HashMap;
import java.util.Map;

/**
 * Enumération des orientations
 */
public enum Orientation {

    NORTH ("N", 0, 1){
        @Override
        public Orientation getRight() {
            return EAST;
        }

        @Override
        public Orientation getLeft() {
            return WEST;
        }
    },
    SOUTH ("S", 0, -1) {
        @Override
        public Orientation getRight() {
            return WEST;
        }

        @Override
        public Orientation getLeft() {
            return EAST;
        }
    },
    EAST ("E", 1, 0) {
        @Override
        public Orientation getRight() {
            return SOUTH;
        }

        @Override
        public Orientation getLeft() {
            return NORTH;
        }
    },
    WEST ("W", -1, 0) {
        @Override
        public Orientation getRight() {
            return NORTH;
        }

        @Override
        public Orientation getLeft() {
            return SOUTH;
        }
    };

    private String orientation;
    private int xDirection;
    private int yDirection;

    private static Map<String, Orientation> mapOrientations = new HashMap<>();

    static {
        for(Orientation orientation : Orientation.values()){
            mapOrientations.put(orientation.getValue(), orientation);
        }
    }

    Orientation(String orientation, int xDirection, int yDirection) {
        this.orientation = orientation;
        this.xDirection = xDirection;
        this.yDirection = yDirection;
    }

    public String getValue(){
        return orientation;
    }

    public int getxDirection() {
        return xDirection;
    }

    public int getyDirection() {
        return yDirection;
    }

    /**
     * Retourne une orientation à partir de sa valeur
     * @param value
     * @return
     */
    public static Orientation getOrientationByValue(String value){
        return mapOrientations.get(value);
    }

    /**
     * Retourne l'orientation à droite
     * @return
     */
    public abstract Orientation getRight();

    /**
     * Retourne l'orientation à gauche
     * @return
     */
    public abstract Orientation getLeft();
}
