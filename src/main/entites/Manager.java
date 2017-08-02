package main.entites;

import main.MowItNowException;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Manager des tondeuses
 */
public class Manager {

    private Map<Mower, List<Instruction>> instructionsByMower;

    public Manager() {
        this.instructionsByMower = new LinkedHashMap<>();
    }

    /**
     * Ajout une tondeuse avec ses instructions
     * @param mower
     * @param instructions
     * @return
     */
    public Manager addMowerAndInstructions(Mower mower, List<Instruction> instructions){
        instructionsByMower.putIfAbsent(mower, instructions);
        return this;
    }

    /**
     * Exécute les instructions de toutes les tondeuses
     * @throws MowItNowException
     */
    public void manageMowers() throws MowItNowException {
        for(Map.Entry<Mower, List<Instruction>> mower : instructionsByMower.entrySet()){
            for(Instruction instruction : mower.getValue()){
                mower.getKey().executeInstruction(instruction);
//                System.out.println(mower.getKey().toString());
            }
        }
    }

    /**
     * Ecrit les positions de toutes les tondeuses
     */
    public void writePositions(){
        for(Mower mower : instructionsByMower.keySet()){
            System.out.println(mower.toString());
        }
    }
}
