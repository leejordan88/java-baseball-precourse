package baseball;

public class Result {
    private final int strikeCount;
    private final int ballCount;

    public int getStrikeCount() {
        return strikeCount;
    }

    public int getBallCount() {
        return ballCount;
    }

    public Result(int strikeCount, int ballCount) {
        this.strikeCount = strikeCount;
        this.ballCount = ballCount;
    }

    public static Result from(Team user, Team computer) {
        int strikeCount = 0;
        int ballCount = 0;

        int[] userArray = user.getArray();
        int[] computerArray = computer.getArray();


        for (int u = 0; u < userArray.length; u++) {
            for (int c = 0; c <computerArray.length; c++) {
                if (u == c && userArray[u] == computerArray[c]) {
                    strikeCount++;
                    continue;
                }

                if (userArray[u] == computerArray[c]) {
                    ballCount++;
                }
            }
        }

        return new Result(strikeCount, ballCount);
    }
}
