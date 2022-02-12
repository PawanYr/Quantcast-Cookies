import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class main {
    public static void main(String[] args) throws FileNotFoundException {
        HashMap<String, Integer> cookies = new HashMap<>();
        Scanner input = new Scanner(new File(args[0]));

        while (input.hasNextLine()) {
            String currentLine = input.nextLine();
            String[] cookie = currentLine.split(",");
            String[] dateAndTime = cookie[1].split("T");

            if (dateAndTime[0] == args[2]) {
                cookies.put(cookie[0], cookies.getOrDefault(cookie[0], 1)+1);
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
        System.out.print(output);
    }
}
