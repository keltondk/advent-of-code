import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;

public class countCals {
    public static void main(String[] args) throws IOException{
        System.out.println(maxCals(args[0]));
    }
    public static Integer maxCals(String filePath) throws IOException {
        String contents = Files.readString(Paths.get(filePath));
        String[] brokenContents = contents.split("\r\n\r\n");

        int maxCal = 0;
        for (String elf : brokenContents) {
            int currCal = 0;
            String[] foodItems = elf.split("\r\n");
            for (String foodItem : foodItems) {
                currCal += Integer.parseInt(foodItem);
            }
            if (currCal > maxCal) {
                maxCal = currCal;
            }
        }
        return maxCal;
    }
}
