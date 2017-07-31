package test.entites;

import main.MowItNowException;
import main.entites.Cell;
import main.entites.Coordonnees;
import main.entites.Lawn;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class LawnTest {

    @Test
    public void testConstructor() throws MowItNowException {
        Lawn lawn = new Lawn(3, 3);
        Cell[][] grid = lawn.getGrid();
        assertEquals(4, grid.length);
        for(int i = 0; i <= 3; i++){
            assertEquals(4, grid[i].length);
        }
    }

    @Test
    public void testConstructorError() throws MowItNowException {
        assertThrows(MowItNowException.class, () -> {new Lawn(-1, 3);});
        assertThrows(MowItNowException.class, () -> {new Lawn(3, -1);});
    }

    @Test
    public void testGetCell() throws MowItNowException {
        Lawn lawn = new Lawn(3, 3);
        Coordonnees coordonnees = new Coordonnees(2, 3);
        Cell cell = lawn.getCell(coordonnees);
        assertEquals(cell.getCoordonnees(), coordonnees);

        coordonnees.setX(10);
        assertNull(lawn.getCell(coordonnees));
    }
}
