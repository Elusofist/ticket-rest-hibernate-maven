package servlet.validation.validator;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

public class DateValidator implements Validator<Date> {
    private static DateValidator instance;

    public static DateValidator getInstance() {
        if (instance == null) {
            synchronized (DateValidator.class) {
                if (instance == null) {
                    instance = new DateValidator();
                }
            }
        }
        return instance;
    }

    private DateValidator() {
    }

    @Override
    public boolean isValid(Date flightDate) {
        return LocalDate.now().compareTo(flightDate.toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDate()) >= 0;
    }
}
