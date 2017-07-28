package entites;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by archet on 28/07/2017.
 */
public class Reader {

    public List<String> readFile(String filename) throws IOException {
        return Files.lines(Paths.get(filename), StandardCharsets.ISO_8859_1).collect(Collectors.toList());
    }
}
