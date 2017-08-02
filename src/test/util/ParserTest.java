package test.util;

import main.MowItNowException;
import main.entites.*;
import main.util.Parser;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ParserTest {

    @Test
    public void testCheckFiles() throws MowItNowException {
        List<String> list = new ArrayList<>();
        list.add("1");
        assertThrows(MowItNowException.class, () -> {
            Parser.checkFile(list);
        });
        list.add("2");
        assertThrows(MowItNowException.class, () -> {
            Parser.checkFile(list);
        });
        list.add("3");
        Parser.checkFile(list);
        list.add("3");
        assertThrows(MowItNowException.class, () -> {
            Parser.checkFile(list);
        });
    }

    @Test
    public void testParseInstructions(){
        List<Instruction> instructions = Parser.parseInstructions("AGDBG");
        assertEquals(4, instructions.size());
        assertEquals(Instruction.GO, instructions.get(0));
        assertEquals(Instruction.LEFT, instructions.get(1));
        assertEquals(Instruction.RIGHT, instructions.get(2));
        assertEquals(Instruction.LEFT, instructions.get(3));
    }

    @Test
    public void parseMower() throws MowItNowException {
        Lawn lawn = new Lawn(5, 5);
        assertThrows(MowItNowException.class, () -> {
            Parser.parseMower("1 2 N N", lawn, 2);
        });
        assertThrows(MowItNowException.class, () -> {
            Parser.parseMower("1 2", lawn, 2);
        });
        assertThrows(MowItNowException.class, () -> {
            Parser.parseMower("1 2 N", null, 2);
        });
        assertThrows(MowItNowException.class, () -> {
            Parser.parseMower("N 2 N", null, 2);
        });
        assertThrows(MowItNowException.class, () -> {
            Parser.parseMower("1 N N", null, 2);
        });
        assertThrows(MowItNowException.class, () -> {
            Parser.parseMower("1 2 2", null, 2);
        });
        assertThrows(MowItNowException.class, () -> {
            Parser.parseMower("4 4 N", null, 2);
        });
        assertThrows(MowItNowException.class, () -> {
            Parser.parseMower("8 8 N", lawn, 2);
        });

        Mower mower = Parser.parseMower("1 2 N", lawn, 2);
        assertEquals(Orientation.NORTH, mower.getOrientation());
        assertEquals(new Coordonnees(1, 2), mower.getActualCell().getCoordonnees());
        assertTrue(mower.getActualCell().isTaken());
    }

    @Test
    public void testParseLawn() throws MowItNowException {
        assertThrows(MowItNowException.class, () -> {
            Parser.parseLawn("1 2 3");
        });
        assertThrows(MowItNowException.class, () -> {
            Parser.parseLawn("1");
        });
        assertThrows(MowItNowException.class, () -> {
            Parser.parseLawn("N 1");
        });
        assertThrows(MowItNowException.class, () -> {
            Parser.parseLawn("1 N");
        });
        Lawn lawn = Parser.parseLawn("2 3");
        assertEquals(2, lawn.getxLimit());
        assertEquals(3, lawn.getyLimit());
    }
}
