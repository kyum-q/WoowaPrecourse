package oncall.constants;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class HolidayTest {

    @ParameterizedTest
    @CsvSource({"1, 1", "3, 1", "5, 5", "6, 6","8, 15","10, 3","10, 9", "12, 25"})
    void isHoliday(int month, int day) {
        boolean result = Holiday.isHoliday(month,day);

        assertThat(result).isEqualTo(true);
    }
}