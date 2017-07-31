package main.entites;

import main.MowItNowException;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Manager {

    private Map<Mower, List<Instruction>> instructionsByMower;

    public Manager() {
        this.instructionsByMower = new LinkedHashMap<>();
    }

    public Manager addMowerAndInstructions(Mower mower, List<Instruction> instructions){
        instructionsByMower.putIfAbsent(mower, instructions);
        return this;
    }

    public void manageMowers() throws MowItNowException {
        for(Map.Entry<Mower, List<Instruction>> mower : instructionsByMower.entrySet()){
            for(Instruction instruction : mower.getValue()){
                mower.getKey().executeInstruction(instruction);
            }
        }
    }

    public void writePositions(){
        for(Mower mower : instructionsByMower.keySet()){
            System.out.println(mower.toString());
        }
    }
}
