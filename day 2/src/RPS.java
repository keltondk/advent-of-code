import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class RPS {
    public static void main(String[] args) {

    }

    public static Integer calcScore(String data) throws IOException {
        String contents = Files.readString(Paths.get(data));
        String[] splitConts = contents.split("\r\n");
        Integer score = 0;
        for (String turn : splitConts) {
            String[] moves  = turn.split(" ");
            String yourMove = moves[1];
            String theirMove = moves[0];
            switch (theirMove) {

            }
        }
        return null;
    }
}
