package MatrixRotator;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.jupiter.api.Assertions.*;

class MatrixRotatorTest {

    @Test
    void checkPassingNullArgument() {
        try {
            MatrixRotator.rotateCounterClockwise(null);
            fail("Exception should be thrown");
        } catch (Exception e) {
            assertThat(e.getClass(), equalTo(IllegalArgumentException.class));
        }
    }
}