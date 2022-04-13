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
        int strikeCount = user.getStrikeCount(computer);
        int ballCount = user.getBallCount(computer);

        return new Result(strikeCount, ballCount);
    }

    public String getMessage() {
        StringBuilder sb = new StringBuilder();
        if (ballCount != 0) {
            sb.append(ballCount).append("볼 ");
        }
        if (strikeCount != 0) {
            sb.append(strikeCount).append("스트라이크 ");
        }
        return sb.deleteCharAt(sb.length() - 1).toString();
    }

}
