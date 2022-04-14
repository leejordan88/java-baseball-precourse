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

    @Override
    public String toString() {
        return "Team{" + "first=" + first + ", second=" + second + ", third=" + third + '}';
    }

}
