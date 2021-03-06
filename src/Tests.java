import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import static org.junit.Assert.assertEquals;

public class Tests {
    @Test
    public void testSingleAnswer() throws FileNotFoundException {
        String output = main.findMostFrequent(new Scanner(new File("sample1.csv")), "2018-12-09");
        assertEquals("\nAtY0laUfhglK3lC7", output);
    }

    @Test
    public void testMultipleAnswers() throws FileNotFoundException {
        String output = main.findMostFrequent(new Scanner(new File("sample1.csv")), "2018-12-08");
        assertEquals("\nfbcn5UAVanZf6UtG" +
                "\nSAZuXPGUrfbcn5UA" +
                "\n4sMM2LxV07bPJzwf", output);
    }

    @Test
    public void testNotPresent() throws FileNotFoundException {
        String output = main.findMostFrequent(new Scanner(new File("sample1.csv")), "2018-12-12");
        assertEquals("", output);
    }

    @Test
    public void testEmptyFile() throws FileNotFoundException {
        String output = main.findMostFrequent(new Scanner(new File("empty.csv")), "2018-12-09");
        assertEquals("", output);
    }
}
