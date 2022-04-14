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

    private Result(Team user, Team computer) {
        this.strikeCount = getStrikeCount(user, computer);
        this.ballCount = getBallCount(user, computer);
    }

    public static Result from(Team user, Team computer) {
        return new Result(user, computer);
    }

    public boolean result() {
        printMessage();

        if (strikeCount == 3) {
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            return true;
        }

        return false;
    }

    private int getStrikeCount(Team user, Team computer) {
        int count = calc(user.getFirst(), computer.getFirst());
        count += calc(user.getSecond(), computer.getSecond());
        count += calc(user.getThird(), computer.getThird());
        return count;
    }

    private int getBallCount(Team user, Team computer) {
        int count = calc(user.getFirst(), computer.getSecond());
        count += calc(user.getFirst(), computer.getThird());

        count += calc(user.getSecond(), computer.getFirst());
        count += calc(user.getSecond(), computer.getThird());

        count += calc(user.getThird(), computer.getFirst());
        count += calc(user.getThird(), computer.getSecond());

        return count;
    }

    private int calc(int left, int right) {
        if (left == right) {
            return 1;
        }
        return 0;
    }

    private void printMessage() {
        if (strikeCount == 0 && ballCount == 0) {
            System.out.println("낫싱");
            return;
        }
        System.out.println(getMessage());
    }

    private String getMessage() {
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
