package oncall.model;

import oncall.constants.Week;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class MonthWeekTest {

    MonthWeek monthWeek;


    @ParameterizedTest
    @CsvSource({"1, 31", "2, 28", "3, 31", "4, 30", "5, 31", "6, 30", "7, 31", "8, 31", "9, 30", "10, 31", "11, 30", "12, 31"})
    void 월에_따른_일자_확인(int month, int dayCount) {
        monthWeek = new MonthWeek(month, Week.Mon);
        int count = 1;
        while (monthWeek.next()) {
            count++;
        }

        assertThat(count).isEqualTo(dayCount);
    }
    
    @Test
    void 휴일_토_체크() {
        monthWeek = new MonthWeek(1, Week.Sat);
        boolean result = monthWeek.checkHoliday();
        assertThat(result).isEqualTo(true);
    }

    @Test
    void 휴일_일_체크() {
        monthWeek = new MonthWeek(1, Week.Sun);
        boolean result = monthWeek.checkHoliday();
        assertThat(result).isEqualTo(true);
    }
}