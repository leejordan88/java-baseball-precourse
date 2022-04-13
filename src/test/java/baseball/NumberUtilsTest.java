package baseball;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NumberUtilsTest {

    @Test
    public void length_over() {
        // given
        int length = 1;
        String str = "12345";

        // when & then
        assertThrows(IllegalArgumentException.class, () -> NumberUtils.validNumberLength(str, length));
    }

    @Test
    public void length_over_message() {
        // given
        int length = 1;
        String str = "12345";

        try {
            // when
            NumberUtils.validNumberLength(str, length);
        } catch (IllegalArgumentException e) {
            // then
            assertEquals("input length error. input=[" + str + "]", e.getMessage());
        }
    }

    @Test
    public void is_not_number() {
        // given
        String str = "한글";

        // when & then
        assertThrows(IllegalArgumentException.class, () -> NumberUtils.correctNumeric(str));
    }

    @Test
    public void is_not_number_message() {
        // given
        String str = "한글";

        try {
            // when
            NumberUtils.correctNumeric(str);
        } catch (IllegalArgumentException e) {
            // then
            assertEquals("number format error. input=[" + str + "]", e.getMessage());
        }
    }


}