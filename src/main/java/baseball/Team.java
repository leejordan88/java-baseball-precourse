package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.Arrays;

public class Team {
    private final int first;
    private final int second;
    private final int third;

    public Team(int first, int second, int third) {
        this.first = first;
        this.second = second;
        this.third = third;
    }

    public static Team createComputer() {
        int index = 0;
        int[] computer = new int[3];

        while (index < 3) {
            int nextNumber = Randoms.pickNumberInRange(1, 9);
            boolean isNewNumber = Arrays.stream(computer).noneMatch(i -> i == nextNumber);

            if (isNewNumber) {
                computer[index++] = nextNumber;
            }
        }
        return new Team(computer[0], computer[1], computer[2]);
    }

    public static Team createUser(String line) {
        validInput(line);
        return new Team(
                Character.getNumericValue(line.charAt(0)),
                Character.getNumericValue(line.charAt(1)),
                Character.getNumericValue(line.charAt(2))
                );
    }

    private static void validInput(String line) {
        NumberUtils.collectNumeric(line);
        if (line.length() > 3) {
            throw new IllegalArgumentException("input length error. input=[" + line + "]");
        }
    }

    public boolean result(Team computer) {
        Result result = Result.from(this, computer);
        printMessage(result);

        if (result.getStrikeCount() == 3) {
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            return true;
        }

        return false;
    }

    private void printMessage(Result result) {
        StringBuilder sb = new StringBuilder();
        int strikeCount = result.getStrikeCount();
        int ballCount = result.getBallCount();

        if (ballCount == 0 && strikeCount == 0) sb.append("낫싱");
        if (ballCount != 0) sb.append(ballCount).append("볼");
        if (ballCount != 0 && strikeCount != 0) sb.append(" ");
        if (strikeCount != 0) sb.append(strikeCount).append("스트라이크");

        System.out.println(sb);
    }

    public int[] getArray() {
        return new int[] {first, second, third};
    }

    @Override
    public String toString() {
        return "Team{" +
                "first=" + first +
                ", second=" + second +
                ", third=" + third +
                '}';
    }

}
