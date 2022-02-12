import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        if (args.length < 3) {
            System.out.println("You must provide a filename, and a date flagged with '-d'!");
            System.exit(0);
        }

        try {
            Scanner input = new Scanner(new File(args[0]));
            input.nextLine();
            String output = findMostFrequent(input, args[2]);
            System.out.println(output);
        } catch(FileNotFoundException f) {
            System.out.println("Please enter a valid filename!");
        }

    }

    public static String findMostFrequent(Scanner input, String date) {
        HashMap<String, Integer> cookies = new HashMap<>();

        while (input.hasNextLine()) {
            String currentLine = input.nextLine();
            String[] cookie = currentLine.split(",");
            String[] dateAndTime = cookie[1].split("T");

            if (dateAndTime[0].equals(date)) {
                cookies.put(cookie[0], cookies.getOrDefault(cookie[0], 1) + 1);
            }
        }

        int max = 0;
        String output = "";

        for (Map.Entry<String, Integer> entry : cookies.entrySet()) {
            String cookie = entry.getKey();
            int frequency = entry.getValue();
            if (frequency > max) {
                max = entry.getValue();
                output = "\n" + cookie;
            } else if (frequency == max) {
                output += "\n" + cookie;
            }
        }
        return output;
    }
}
