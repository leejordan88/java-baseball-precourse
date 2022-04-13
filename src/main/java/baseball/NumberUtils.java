package baseball;

public class NumberUtils {

    public static void correctNumeric(String str) {
        try {
            Integer.parseInt(str);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("number format error. input=[" + str + "]");
        }
    }

    public static void validNumberLength(String str, int length) {
        if (str.length() > length) {
            throw new IllegalArgumentException("input length error. input=[" + str + "]");
        }
    }

    public static void validInput(String str, int length) {
        correctNumeric(str);
        validNumberLength(str, length);
    }

}
