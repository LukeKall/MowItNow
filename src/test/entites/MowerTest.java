package test.entites;

import main.MowItNowException;
import main.entites.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.when;

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

        Lawn lawn = spy(new Lawn(5, 5));
        Cell newCell = new Cell(new Coordonnees(1, 3));
        when(lawn.getNextFreeCell(cell, Orientation.EAST)).thenReturn(newCell);

        Mower mower = new Mower(Orientation.EAST, lawn, cell);
        assertThrows(MowItNowException.class, () -> {mower.executeInstruction(null);});

        mower.executeInstruction(Instruction.GO);
        assertEquals(newCell, mower.getActualCell());
        assertEquals(Orientation.EAST, mower.getOrientation());

        mower.executeInstruction(Instruction.LEFT);
        assertEquals(newCell, mower.getActualCell());
        assertEquals(Orientation.NORTH, mower.getOrientation());

        mower.executeInstruction(Instruction.RIGHT);
        assertEquals(newCell, mower.getActualCell());
        assertEquals(Orientation.EAST, mower.getOrientation());
    }

    @Test
    public void testMove() throws MowItNowException {
        Cell cell = new Cell(new Coordonnees(1, 1));
        Lawn lawn = spy(new Lawn(5, 5));
        Cell newCell = new Cell(new Coordonnees(1, 3));
        when(lawn.getNextFreeCell(cell, Orientation.EAST)).thenReturn(newCell);
        Mower mower = new Mower(Orientation.EAST, lawn, cell);
        mower.move();
        assertEquals(Orientation.EAST, mower.getOrientation());
        assertEquals(newCell, mower.getActualCell());
    }
}
