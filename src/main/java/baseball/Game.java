package baseball;

import camp.nextstep.edu.missionutils.Console;

public class Game {

    public boolean play(Team computer) {
        if (computer == null) {
            computer = Team.createComputer();
        }
        System.out.println(computer);
        System.out.print("숫자를 입력해주세요:");

        // 유저 생성
        String line = Console.readLine();
        Team user = Team.createUser(line);

        if (user.result(computer)) {
            return isKeepGoing();
        }

        return play(computer);
    }

    private boolean isKeepGoing() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요");

        String keepGoing = Console.readLine();
        NumberUtils.correctNumeric(keepGoing);

        return Integer.parseInt(keepGoing) == 1;
    }
}
