package baseball;


import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        // 컴퓨터 생성
        Team computer = Team.createComputer();
        System.out.println("computer: " + computer);

        while (true) {
            System.out.print("숫자를 입력해주세요:");

            // 유저 생성
            String line = Console.readLine();
            Team user = Team.createUser(line);


            // 결과
            if (user.result(computer)) {
                System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요");
                String keepGoing = Console.readLine();
                NumberUtils.collectNumeric(keepGoing);
                if (Integer.parseInt(keepGoing) == 1) {
                    computer = Team.createComputer();
                    System.out.println("computer: " + computer);
                    continue;
                }

                System.out.println("게임 종료");
                break;

            }

            // 실패 시 다시 시도
//            System.out.println("User " + user + ", Computer " + computer);
//            System.out.println("실패!");
        }



    }

}
