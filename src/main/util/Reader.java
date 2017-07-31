package main.util;

import main.MowItNowException;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Classe de lecture de fichiers
 */
public class Reader {

    public static List<String> readFile(String filename) throws IOException, MowItNowException {
        try {
            return Files.lines(Paths.get(filename)).collect(Collectors.toList());
        } catch (NoSuchFileException e){
            throw new MowItNowException("Fichier " + filename + "introuvable.");
        }
    }
}
