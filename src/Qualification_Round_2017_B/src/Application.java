package Qualification_Round_2017_B.src;

import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class Application {
    public static void main(String[] args) throws IOException {
        String filename = "src/Qualification_Round_2017_B/B-large-practice.in";
        PrintStream o = new PrintStream(new File(filename.replace(".in", ".out")));
        System.setOut(o);
        List<String> lines = Files.readAllLines(Paths.get(filename));
        int j = 1;
        for (int i = 1; i < lines.size(); i++) {
            System.out.println("Case #" + j++ + ": " + new TidyNumbers().findTidyNumber(lines.get(i)));
        }
    }
}
