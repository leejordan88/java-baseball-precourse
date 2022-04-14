package baseball;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TeamTest {

    @Test
    public void create_computer() {
        // given & when
        Team computer = Team.createComputer();

        // then
        assertTrue(computer.getFirst() > 0);
        assertTrue(computer.getSecond() > 0);
        assertTrue(computer.getThird() > 0);

        assertTrue(computer.getFirst() < 10);
        assertTrue(computer.getSecond() < 10);
        assertTrue(computer.getThird() < 10);

        assertTrue(computer.getFirst() != computer.getSecond());
        assertTrue(computer.getFirst() != computer.getThird());
        assertTrue(computer.getSecond() != computer.getFirst());
        assertTrue(computer.getSecond() != computer.getThird());
        assertTrue(computer.getThird() != computer.getFirst());
        assertTrue(computer.getThird() != computer.getSecond());
    }

    @Test
    public void create_user_ok() {
        // given
        String line = "123";

        // when
        Team user = Team.createUser(line);

        // then
        assertTrue(user.getFirst() > 0);
        assertTrue(user.getSecond() > 0);
        assertTrue(user.getThird() > 0);

        assertTrue(user.getFirst() < 10);
        assertTrue(user.getSecond() < 10);
        assertTrue(user.getThird() < 10);

        assertTrue(user.getFirst() != user.getSecond());
        assertTrue(user.getFirst() != user.getThird());
        assertTrue(user.getSecond() != user.getFirst());
        assertTrue(user.getSecond() != user.getThird());
        assertTrue(user.getThird() != user.getFirst());
        assertTrue(user.getThird() != user.getSecond());
    }

    @Test
    public void create_user_fail_length_over() {
        // given
        String line = "1234";

        // when & then
        assertThrows(IllegalArgumentException.class, () -> Team.createUser(line));
    }

    @Test
    public void create_user_fail_hangeul() {
        // given
        String line = "한글";

        // when & then
        assertThrows(IllegalArgumentException.class, () -> Team.createUser(line));
    }


}