package main.entites;

import main.MowItNowException;

import java.util.ArrayList;
import java.util.List;

public class Parser {

    public Manager parseFile(List<String> lines) throws MowItNowException {
        checkFile(lines);
        Manager manager = new Manager();
        Lawn lawn = parseLawn(lines.get(0));
        for(int i = 1; i < lines.size(); i+=2){
            manager.addMowerAndInstructions(parseMower(lines.get(i), lawn), parseInstructions(lines.get(i+1)));
        }
        return manager;
    }

    public Lawn parseLawn(String line) throws MowItNowException {
        String[] limit = line.split(" ");
        if(limit.length > 2){
            throw new MowItNowException();
        }
        return new Lawn(Integer.parseInt(limit[0]), Integer.parseInt(limit[1]));
    }

    public Mower parseMower(String line, Lawn lawn) throws MowItNowException {
        String[] mowerProperties = line.split(" ");
        if(mowerProperties.length > 3){
            throw new MowItNowException();
        }
        try {
            return new Mower(Orientation.getOrientationByValue(mowerProperties[2]),
                    lawn,
                    lawn.getCell(
                            new Coordonnees(
                                    Integer.parseInt(mowerProperties[0]),
                                    Integer.parseInt(mowerProperties[1])
                            )
                    )
            );
        } catch(MowItNowException e){
            throw new MowItNowException();
        }
    }

    public List<Instruction> parseInstructions(String line){
        List<Instruction> instructions = new ArrayList<>();
        for(String inst : line.split("")){
            instructions.add(Instruction.getInstructionByValue(inst));
        }
        return instructions;
    }

    public void checkFile(List<String> lines) throws MowItNowException {
        if(lines.size() < 3 ||  lines.size() % 2 ==0){
            throw new MowItNowException();
        }
    }
}
