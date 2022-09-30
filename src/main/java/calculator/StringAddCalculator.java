package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {
    public static final String DELIMITER = ",|:";
    private static final Pattern pattern = Pattern.compile("//(.)\n(.*)");

    public static int splitAndSum(String text) {
        if (isBlank(text)) {
            return 0;
        }
        return sum(toPositives(split(text)));
    }

    private static String[] split(String text) {
        Matcher m = pattern.matcher(text);
        if (pattern.matcher(text).find()) {
            String customDelimiter = m.group(1);
            return m.group(2).split(customDelimiter);
        }
        return text.split(DELIMITER);
    }

    private static boolean isBlank(String text) {
        return text == null || text.isBlank();
    }

    private static PositiveNumber[] toPositives(String[] values) {
        int size = values.length;
        PositiveNumber[] numbers = new PositiveNumber[size];
        for (int i = 0; i < size; i++) {
            PositiveNumber number = new PositiveNumber(values[i]);
            numbers[i] = number;
        }
        return numbers;
    }

    private static int sum(PositiveNumber[] numbers) {
        PositiveNumber result = new PositiveNumber(0);
        for (PositiveNumber number : numbers) {
            result = result.plus(number);
        }
        return result.getNumber();
    }

}
