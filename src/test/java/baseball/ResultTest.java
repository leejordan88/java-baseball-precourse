package baseball;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ResultTest {

    @Test
    public void two_ball_one_strike() {
        // given
        Team computer = Team.createComputer();
        String line = new StringBuffer()
                .append(computer.getFirst())
                .append(computer.getThird())
                .append(computer.getSecond())
                .toString();
        Team user = Team.createUser(line);

        // when
        Result result = Result.from(user, computer);

        // then
        assertEquals(2, result.getBallCount());
        assertEquals(1, result.getStrikeCount());
    }

    @Test
    public void three_ball() {
        // given
        Team computer = Team.createComputer();
        String line = new StringBuffer()
                .append(computer.getSecond())
                .append(computer.getThird())
                .append(computer.getFirst())
                .toString();
        Team user = Team.createUser(line);

        // when
        Result result = Result.from(user, computer);

        // then
        assertEquals(3, result.getBallCount());
        assertEquals(0, result.getStrikeCount());
    }

    @Test
    public void three_strike() {
        // given
        Team computer = Team.createComputer();
        String line = new StringBuffer()
                .append(computer.getFirst())
                .append(computer.getSecond())
                .append(computer.getThird())
                .toString();
        Team user = Team.createUser(line);

        // when
        Result result = Result.from(user, computer);

        // then
        assertEquals(0, result.getBallCount());
        assertEquals(3, result.getStrikeCount());
    }

}