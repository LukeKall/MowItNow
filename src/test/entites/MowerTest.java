package test.entites;

import main.MowItNowException;
import main.entites.*;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MowerTest {

    @Test
    public void testConstructorLock() throws MowItNowException {
        Cell cell = new Cell(new Coordonnees(1, 1));
        Mower mower = new Mower(Orientation.EAST, new Lawn(1, 1), cell);
        assertTrue(mower.getActualCell().isTaken());
    }

    @Test
    public void testConstructorErrors() throws MowItNowException {
        Cell cell = new Cell(new Coordonnees(1, 1));
        assertThrows(MowItNowException.class, () -> {new Mower(null, new Lawn(1, 1), cell);});
        assertThrows(MowItNowException.class, () -> {new Mower(Orientation.EAST, null, cell);});
        assertThrows(MowItNowException.class, () -> {new Mower(Orientation.EAST, new Lawn(1, 1), null);});
        cell.lock();
        assertThrows(MowItNowException.class, () -> {new Mower(Orientation.EAST, new Lawn(1, 1), cell);});
    }

    @Test
    public void testExecuteInstruction() throws MowItNowException {
        Cell cell = new Cell(new Coordonnees(1, 1));
        Mower mower = new Mower(Orientation.EAST, new Lawn(1, 1), cell);
        assertThrows(MowItNowException.class, () -> {mower.executeInstruction(null);});
    }
}
