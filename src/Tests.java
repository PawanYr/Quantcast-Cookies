import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import static org.junit.Assert.assertEquals;

public class Tests {
    @Test
    public void testSingleAnswer() throws FileNotFoundException {
        String output = main.findMostFrequent(new Scanner(new File("single.csv")), "2018-12-09");
        assertEquals("\nAtY0laUfhglK3lC7", output);
    }

    @Test
    public void testMultipleAnswers() throws FileNotFoundException {
        String output = main.findMostFrequent(new Scanner(new File("single.csv")), "2018-12-08");
        assertEquals("\nfbcn5UAVanZf6UtG" +
                "\nSAZuXPGUrfbcn5UA" +
                "\n4sMM2LxV07bPJzwf", output);
    }
}
