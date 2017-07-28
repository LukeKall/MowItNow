package entites;

import java.io.IOException;
import java.util.List;

/**
 * Created by archet on 28/07/2017.
 */
public class Launcher {

    public static void main(String... args) throws IOException {
        Reader reader = new Reader();
        List<String> listLines = reader.readFile("D:\\Personal_Unsaved\\doc\\filetest.txt");
        for(String line : listLines){
            System.out.println(line);
        }
    }
}
