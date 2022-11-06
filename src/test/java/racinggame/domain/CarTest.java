package racinggame.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {

    @Test
    void 초기_이동값() {
        Car car = new Car("자동차1", 3);
        assertThat(car.getPosition()).isEqualTo(new Position(3));
    }

    @Test
    void name() {
        assertThat(new Car("자동차1").getCarName().toString()).isEqualTo("자동차1");
    }

    @Test
    void go() {
        Car car = new Car("자동차", 0, () -> true);
        car.moveForward();
        assertThat(car.getPosition()).isEqualTo(new Position(1));
    }

    @Test
    void stop() {
        Car car = new Car("자동차", 0, () -> false);
        car.moveForward();
        assertThat(car.getPosition()).isEqualTo(new Position(0));
    }
}
