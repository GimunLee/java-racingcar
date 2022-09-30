package calculator;

import java.util.Objects;

public class PositiveNumber {

    private final int number;

    public PositiveNumber(String value) {
        this(parsePositiveInt(value));
    }

    public PositiveNumber(int number) {
        if (number < 0) {
            throw new RuntimeException("음수 값이 들어올 수 없습니다.");
        }
        this.number = number;
    }

    public PositiveNumber plus(int number) {
        return new PositiveNumber(this.number + number); // 인스턴스화는 immutable을 위함
    }

    public PositiveNumber plus(PositiveNumber number) {
        return new PositiveNumber(this.number + number.number);
    }

    public int getNumber() {
        return this.number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PositiveNumber positive = (PositiveNumber) o;
        return number == positive.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }

    private static int parsePositiveInt(String value) {
        int number;
        try {
            number = Integer.parseInt(value);
        } catch (IllegalArgumentException e) {
            throw new RuntimeException("숫자가 아닙니다.");
        }
        return number;
    }
}
