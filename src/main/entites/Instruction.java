package main.entites;

import java.util.HashMap;
import java.util.Map;

public enum Instruction {
    LEFT("G"),
    RIGHT("D"),
    GO("A");

    private String instruction;

    private static Map<String, Instruction> mapInstructions = new HashMap<>();

    static {
        for(Instruction instruction : Instruction.values()){
            mapInstructions.put(instruction.getValue(), instruction);
        }
    }

    Instruction(String instruction) {
        this.instruction = instruction;
    }

    public String getValue() {
        return instruction;
    }

    public static Instruction getInstructionByValue(String value){
        return mapInstructions.get(value);
    }
}
