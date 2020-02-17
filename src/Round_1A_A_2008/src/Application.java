package Round_1A_A_2008.src;

import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

public class Application {
    public static void main(String[] args) throws IOException {
        String filename = "src/Round_1A_A_2008/A-small-practice.in";
        PrintStream o = new PrintStream(new File(filename.replace(".in", ".out")));
        System.setOut(o);
        List<String> lines = Files.readAllLines(Paths.get(filename));
        int j = 1;
        for (int i = 1; i < lines.size(); i += 3) {
            int[] listOne = Arrays.stream(lines.get(i + 1).split(" ")).mapToInt(Integer::parseInt).toArray();
            int[] listTwo = Arrays.stream(lines.get(i + 2).split(" ")).mapToInt(Integer::parseInt).toArray();
            System.out.println("Case #" + j++ + ": " + new MinimumScalarProduct().findMinimumScalarProduct(listOne, listTwo));
        }
    }
}
