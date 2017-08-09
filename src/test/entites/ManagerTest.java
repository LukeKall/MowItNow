package test.entites;

import main.MowItNowException;
import main.entites.*;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;


public class ManagerTest {

    @Test
    public void testAddMowerAndInstructions() throws MowItNowException {
        Manager manager = new Manager();
        assertTrue(manager.getInstructionsByMower().isEmpty());
        Lawn lawn = new Lawn(2, 2);
        List<Instruction> instructionList = new ArrayList<>();
        instructionList.add(Instruction.GO);
        instructionList.add(Instruction.GO);
        Mower mower = new Mower(Orientation.EAST, lawn, lawn.getCell(new Coordonnees(1, 1)));
        manager.addMowerAndInstructions(mower, instructionList);
        assertEquals(instructionList, manager.getInstructionsByMower().get(mower));
    }

    @Test
    public void testManageMowers() throws MowItNowException {
        Manager manager = new Manager();
        Lawn lawn = new Lawn(2, 2);
        List<Instruction> instructionList = new ArrayList<>();
        instructionList.add(Instruction.GO);
        instructionList.add(Instruction.GO);
        Mower mower =spy(new Mower(Orientation.EAST, lawn, lawn.getCell(new Coordonnees(1, 1))));

        Lawn lawn2 = new Lawn(2, 2);
        List<Instruction> instructionList2 = new ArrayList<>();
        instructionList2.add(Instruction.GO);
        instructionList2.add(Instruction.GO);
        instructionList2.add(Instruction.GO);
        Mower mower2 = spy(new Mower(Orientation.EAST, lawn2, lawn2.getCell(new Coordonnees(1, 1))));

        manager.addMowerAndInstructions(mower, instructionList);
        manager.addMowerAndInstructions(mower2, instructionList2);

        manager.manageMowers();
        verify(mower, times(2)).executeInstruction(any(Instruction.class));
        verify(mower2, times(3)).executeInstruction(any(Instruction.class));
    }
}
