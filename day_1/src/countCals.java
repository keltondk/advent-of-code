import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class countCals {
    public static void main(String[] args) throws IOException{
        System.out.println(maxCals(args[0]));
    }
    public static Integer maxCals(String filePath) throws IOException {
        String contents = Files.readString(Paths.get(filePath));
        String[] brokenContents = contents.split("\r\n\r\n");

        List<Integer> maxCals = new ArrayList<>();
        int minMaxCal = 0;

        for (String elf : brokenContents) {
            int currCal = 0;
            String[] foodItems = elf.split("\r\n");
            for (String foodItem : foodItems) {
                currCal += Integer.parseInt(foodItem);
            }
            if (maxCals.size() < 3 || currCal > maxCals.get(minMaxCal)) {
                if (maxCals.size() < 3) {
                    maxCals.add(currCal);
                } else {
                    maxCals.remove(minMaxCal);
                    maxCals.add(currCal);
                    minMaxCal = 0;
                    for (int i = 0; i < maxCals.size(); i++) {
                        if (maxCals.get(i) < maxCals.get(minMaxCal)) {
                            minMaxCal = i;
                        }
                    }
                }
            }
        }
        Integer finalSum = 0;
        for (Integer cal : maxCals) {
            finalSum += cal;
        }
        return finalSum;
    }
}
