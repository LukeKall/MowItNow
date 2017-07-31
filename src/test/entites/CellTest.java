package test.entites;

import main.entites.Cell;
import main.entites.Coordonnees;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class CellTest {

    @Test
    public void testLock(){
        Cell cell = new Cell(new Coordonnees(1, 1));
        assertFalse(cell.isTaken());
        cell.lock();
        assertTrue(cell.isTaken());
    }

    @Test
    public void testUnLock(){
        Cell cell = new Cell(new Coordonnees(1, 1));
        cell.setTaken(true);
        assertTrue(cell.isTaken());
        cell.unlock();
        assertFalse(cell.isTaken());
    }
}
