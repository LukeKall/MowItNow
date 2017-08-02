package main;

import main.entites.Manager;
import main.util.Parser;
import main.util.Reader;

import java.io.IOException;
import java.util.List;

/**
 * Launcher
 */
public class Launcher {

    public static void main(String... args) throws IOException, MowItNowException {
        if(args.length < 1){
            System.out.println("Le programme attend un argument pour s'exécuter, celui-ci étant le chamin vers le fichier de paramétrage");
        }
        try {
            List<String> listLines = Reader.readFile(args[0]);
            Manager manager = Parser.parseFile(listLines);
            manager.manageMowers();
            manager.writePositions();
        } catch (MowItNowException e){
            System.out.println("Une erreur est survenue : " + e.getMessage());
        }
    }
}
