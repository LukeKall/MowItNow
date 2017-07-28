package entites;

/**
 * Enumération des orientations
 */
public enum Orientation {

    NORTH ("N"),
    SOUTH ("S"),
    EAST ("E"),
    WEST ("W");

    private String orientation;

    Orientation(String orientation) {
        this.orientation = orientation;
    }
}
