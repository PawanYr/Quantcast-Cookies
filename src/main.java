import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class main {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner input = new Scanner(new File(args[0]));
        String output = findMostFrequent(input, args[2]);
    }

    public static String findMostFrequent(Scanner input, String date) {
        HashMap<String, Integer> cookies = new HashMap<>();

        while (input.hasNextLine()) {
            String currentLine = input.nextLine();
            String[] cookie = currentLine.split(",");
            String[] dateAndTime = cookie[1].split("T");

            if (dateAndTime[0] == date) {
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
                output = cookie + "\n";
            } else if (frequency == max) {
                output += cookie + "\n";
            }
        }
        return output;
    }
}
