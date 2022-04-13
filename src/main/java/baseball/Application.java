package baseball;

public class Application {
    public static void main(String[] args) {
        // game 생성
        Game game = new Game();

        // game 시작
        while (game.play(null));
    }

}
