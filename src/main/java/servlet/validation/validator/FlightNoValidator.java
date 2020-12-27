package servlet.validation.validator;

import java.sql.Date;
import java.time.LocalDate;
import java.time.ZoneId;

public class FlightNoValidator implements Validator<Integer> {
    private static FlightNoValidator instance;

    public static FlightNoValidator getInstance() {
        if (instance == null) {
            synchronized (FlightNoValidator.class) {
                if (instance == null) {
                    instance = new FlightNoValidator();
                }
            }
        }
        return instance;
    }

    private FlightNoValidator() {
    }

    @Override
    public boolean isValid(Integer flightNo) {
        return flightNo >= 100
                && flightNo <= 999;
    }
}
