package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.HashSet;
import java.util.Set;

public class Team {
    private final int first;
    private final int second;
    private final int third;

    private Team(int first, int second, int third) {
        this.first = first;
        this.second = second;
        this.third = third;
    }

    public int getFirst() {
        return first;
    }

    public int getSecond() {
        return second;
    }

    public int getThird() {
        return third;
    }

    public static Team createComputer() {
        int[] computer = new int[3];
        Set<Integer> set = new HashSet<>();

        while (set.size() < 3) {
            int number = pickNumber(set);
            computer[set.size()] = number;
            set.add(number);
        }

        return new Team(computer[0], computer[1], computer[2]);
    }

    private static int pickNumber(Set<Integer> set) {
        int number = Randoms.pickNumberInRange(1, 9);
        if (set.contains(number)) {
            number = pickNumber(set);
        }
        return number;
    }

    public static Team createUser(String line) {
        NumberUtils.validInput(line, 3);
        int first = Character.getNumericValue(line.charAt(0));
        int second = Character.getNumericValue(line.charAt(1));
        int third = Character.getNumericValue(line.charAt(2));
        return new Team(first, second, third);
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
        if (result.getStrikeCount() == 0 && result.getBallCount() == 0) {
            System.out.println("낫싱");
            return;
        }
        System.out.println(result.getMessage());
    }

    public int getStrikeCount(Team computer) {
        int count = calc(this.first, computer.first);
        count += calc(this.second, computer.second);
        count += calc(this.third, computer.third);
        return count;
    }

    public int getBallCount(Team computer) {
        int count = calc(this.first, computer.second);
        count += calc(this.first, computer.third);

        count += calc(this.second, computer.first);
        count += calc(this.second, computer.third);

        count += calc(this.third, computer.first);
        count += calc(this.third, computer.second);

        return count;
    }

    private int calc(int left, int right) {
        if (left == right) {
            return 1;
        }
        return 0;
    }

    @Override
    public String toString() {
        return "Team{" + "first=" + first + ", second=" + second + ", third=" + third + '}';
    }

}
