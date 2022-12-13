package tasks._1_6_misc;

import java.util.Random;
import java.util.stream.Stream;

public class NumberCube {
    private static final Random random = new Random();
    public static final int LONGEST_RUN_CANNOT_BE_FOUND = -1;
    public int toss() {
        return random.nextInt(6) + 1;
    }

    public static int[] getCubeTosses(NumberCube cube, int tossesCount) {
        return Stream
                .generate(cube::toss)
                .limit(tossesCount)
                .mapToInt(i -> i)
                .toArray();
    }

    public static int getLongestRun(int[] tosses) {
        if(tosses.length == 0) {
            return LONGEST_RUN_CANNOT_BE_FOUND;
        }

        int longestRun = Integer.MIN_VALUE;
        int currentRun = 0;
        int currentToss = tosses[0];

        for(var toss : tosses) {
            if(toss == currentToss) {
                currentRun += 1;
            } else if(currentToss > longestRun) {
                longestRun = currentRun;
            }
        }

        return longestRun;
    }
}
