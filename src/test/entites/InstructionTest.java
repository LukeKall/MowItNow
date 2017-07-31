package test.entites;

import main.entites.Instruction;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class InstructionTest {

    @Test
    public void testGetInstructionByValue(){
        for(Instruction instruction : Instruction.values()){
            assertEquals(instruction, Instruction.getInstructionByValue(instruction.getValue()));
        }
    }
}
