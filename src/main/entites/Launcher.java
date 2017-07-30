package main.entites;

import main.MowItNowException;

import java.io.IOException;
import java.util.List;

/**
 * Created by archet on 28/07/2017.
 */
public class Launcher {

    public static void main(String... args) throws IOException, MowItNowException {
        Reader reader = new Reader();
        List<String> listLines = reader.readFile("D:\\Developpement\\Tests\\test.txt");
        Parser parser = new Parser();
        Manager manager = parser.parseFile(listLines);
        manager.manageMowers();
        manager.writePositions();
    }
}
