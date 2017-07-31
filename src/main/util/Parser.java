package main.util;

import main.MowItNowException;
import main.entites.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Parser {

    public static Manager parseFile(List<String> lines) throws MowItNowException {
        checkFile(lines);
        Manager manager = new Manager();
        Lawn lawn = parseLawn(lines.get(0));
        for(int i = 1; i < lines.size(); i+=2){
            manager.addMowerAndInstructions(parseMower(lines.get(i), lawn, i+1), parseInstructions(lines.get(i+1)));
        }
        return manager;
    }

    public static Lawn parseLawn(String line) throws MowItNowException {
        String[] limit = line.split(" ");
        if(limit.length != 2){
            throw new MowItNowException("Erreur lors du parsing du fichier à la ligne 2 (description de la pelouse).");
        }
        try {
            return new Lawn(Integer.parseInt(limit[0]), Integer.parseInt(limit[1]));
        } catch(NumberFormatException  e){
            throw new MowItNowException("Erreur lors du parsing du fichier à la ligne 2 (description de la pelouse) : " + e);
        }
    }

    public static Mower parseMower(String line, Lawn lawn, int lineNumber) throws MowItNowException {
        String[] mowerProperties = line.split(" ");
        if(mowerProperties.length != 3){
            throw new MowItNowException("Erreur lors du parsing du fichier à la ligne " + lineNumber + " (Description d'une tondeuse).");
        }
        if(lawn == null){
            throw new MowItNowException("Erreur lors du parsing du fichier à la ligne " + lineNumber + " (Description d'une tondeuse) : impossible de fournir une pelouse null.");
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
        } catch(MowItNowException|NumberFormatException e){
            throw new MowItNowException("Erreur lors du parsing du fichier à la ligne " + lineNumber + " : " + e);
        }
    }

    public static List<Instruction> parseInstructions(String line){
        List<Instruction> instructions = new ArrayList<>();
        for(String inst : line.split("")){
            Optional.ofNullable(Instruction.getInstructionByValue(inst)).ifPresent(instructions::add);
        }
        return instructions;
    }

    public static void checkFile(List<String> lines) throws MowItNowException {
        if(lines.size() < 3 ||  lines.size() % 2 == 0){
            throw new MowItNowException("Erreur lors du parsing du fichier, le nombre de lignes ne correspond pas à un fichier valide.");
        }
    }
}
