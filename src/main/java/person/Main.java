package person;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by Julien Smeets (jsmeets@quintor.nl) on 8-9-16.
 */
public class Main {
    public static void main (String[] args) {
        try (BufferedReader reader = new BufferedReader(new FileReader(new File("src/main/resources/list-of-names.txt")))){

            // This is what it's about: a file is used as a source for a Stream
            // using the lines() method. The file contains a list of names.
            // Intermediate operations are use to print the first three names in
            // alphabetical order that don't start with an A.
            reader.lines()
                    .sorted()
                    .filter(s -> !s.startsWith("A"))
                    .limit(3)
                    .forEach(s -> System.out.println(s));

        } catch (IOException e){
            System.out.println("File does not exist. Exiting.");
        }
    }
}