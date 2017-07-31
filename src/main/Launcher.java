package main;

import main.MowItNowException;
import main.entites.Manager;
import main.entites.Parser;
import main.entites.Reader;

import java.io.IOException;
import java.util.List;

/**
 * Created by archet on 28/07/2017.
 */
public class Launcher {

    public static void main(String... args) throws IOException, MowItNowException {
        if(args.length < 1){
            System.out.println("Le programme attend un argument pour s'exécuter, celui-ci étant le chamin vers le fichier de paramétrage");
        }
        try {
            Reader reader = new Reader();
            List<String> listLines = reader.readFile(args[0]);
            Parser parser = new Parser();
            Manager manager = parser.parseFile(listLines);
            manager.manageMowers();
            manager.writePositions();
        } catch (MowItNowException e){
            System.out.println("Une erreur est survenue : " + e.getMessage());
        }
    }
}
