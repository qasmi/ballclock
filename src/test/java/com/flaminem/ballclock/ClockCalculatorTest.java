package test.java.com.flaminem.ballclock;

import main.java.com.flaminem.ballclock.ClockCalculator;
import main.java.com.flaminem.ballclock.InvalidInitialBallsNumberException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;



class ClockCalculatorTest {

    @Test
    public void clock_calculator_should_return_day_which_elapse_before_initialisation() throws Exception {

        ClockCalculator clockCalculator = new ClockCalculator();
        Assertions.assertEquals("30 balls cycle after 15.0 days.", clockCalculator.computeTimeBeforeRepetition(30));
        Assertions.assertEquals("45 balls cycle after 378.0 days.", clockCalculator.computeTimeBeforeRepetition(45));
    }

    @Test
    public void clock_calculator_should_throw_InvalideInitialBallsNumberException() {
        ClockCalculator clockCalculator = new ClockCalculator();
        Assertions.assertThrows(InvalidInitialBallsNumberException.class,
                () -> clockCalculator.computeTimeBeforeRepetition(2),
                "Bas balls number : Valid numbers are in the range 27 to 127.");
    }

    @Test
    public void clock_calculator_should_report_the_state() throws Exception {

        String result = "{\"Min\":[],\"FiveMin\":[22, 13, 25, 3, 7],\"Hour\":[6, 12, 17, 4, 15],\"Main\"\n"+
                        "  [11, 5, 26, 18, 2, 30, 19, 8, 24, 10, 29, 20, 16, 21, 28, 1, 23, 14, 27, 9]}";

        ClockCalculator clockCalculator = new ClockCalculator();
        Assertions.assertEquals(result, clockCalculator.computeTimeBeforeRepetition(30, 325));
    }

}