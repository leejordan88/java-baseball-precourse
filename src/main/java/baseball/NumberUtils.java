package baseball;

public class NumberUtils {
    public static void collectNumeric(String str) {
        try {
            Integer.parseInt(str);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("number format error. input=[" + str + "]");
        }
    }
}
