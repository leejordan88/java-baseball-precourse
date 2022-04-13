package baseball;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TeamTest {

    @Test
    public void three_strike() {
        // given
        Team compareA = Team.createComputer();
        Team compareB = compareA;

        // when
        boolean result = compareA.result(compareB);

        // then
        assertTrue(result);
    }

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
        boolean result = user.result(computer);

        // then
        assertFalse(result);
    }



}