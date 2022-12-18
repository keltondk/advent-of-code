import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class RPS {

    /**
     * prints score from given strategy to the terminal
     * @param args the filepath to the data
     * @throws IOException thrown by calcScore
     */
    public static void main(String[] args) throws IOException{
        System.out.println(calcScore(args[0]));
    }

    /**
     * calculates score given properly formatted strategy document
     * @param data filepath to data
     * @return the score from the given strategy
     * @throws IOException thrown by file reader
     */
    public static Integer calcScore(String data) throws IOException {
        // read contents of file
        String contents = Files.readString(Paths.get(data));
        String[] splitConts = contents.split("\r\n");

        // calculate score iteratively
        Integer score = 0;
        for (String turn : splitConts) {
            String[] moves  = turn.split(" ");
            char yourMove = moves[1].charAt(0);
            char theirMove = moves[0].charAt(0);

            int asciiYM = yourMove;
            int asciiTM = theirMove;

            // calculate score by offset from ascii value
            score += asciiYM - 87;

            int scoreDif = (asciiYM - 23) - asciiTM;
            System.out.println(scoreDif + " relates to " + yourMove + theirMove);

            if (scoreDif == -2 || scoreDif == 1) { // win
                score += 6;
            } else if (scoreDif == 0) { // tie
                score += 3;
            }
        }
        return score;
    }
}
