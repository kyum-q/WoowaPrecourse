package oncall.model;

import oncall.constants.Week;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class MonthWeekTest {

    MonthWeek monthWeek;


    @ValueSource(ints = {4,6,9,11})
    @ParameterizedTest
    void 월에_따른_일자_확인_30(int month) {
        monthWeek = new MonthWeek(month, Week.Mon);
        int count = 1;
        while (monthWeek.next()) {
            count++;
        }

        assertThat(count).isEqualTo(30);
    }

    @ValueSource(ints = {1,3,5,7,8,10,12})
    @ParameterizedTest
    void 월에_따른_일자_확인_31(int month) {
        monthWeek = new MonthWeek(month, Week.Mon);
        int count = 1;
        while (monthWeek.next()) {
            count++;
        }

        assertThat(count).isEqualTo(31);
    }

    @Test
    void 월에_따른_일자_확인_28() {
        monthWeek = new MonthWeek(2, Week.Mon);
        int count = 1;
        while (monthWeek.next()) {
            count++;
        }

        assertThat(count).isEqualTo(28);
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