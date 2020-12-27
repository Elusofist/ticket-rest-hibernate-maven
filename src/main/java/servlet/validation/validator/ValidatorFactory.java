package servlet.validation.validator;

import servlet.validation.filter.DateFilter;
import servlet.validation.filter.DestinationFilter;
import servlet.validation.filter.Filter;
import servlet.validation.filter.FlightNoFilter;

public abstract class ValidatorFactory {
    public static Validator getValidator(Filter filter) throws IllegalAccessException {
        if (filter.getClass().equals(DateFilter.class)) {
            return DestinationValidator.getInstance();
        } else if (filter.getClass().equals(DestinationFilter.class)) {
            return DestinationValidator.getInstance();
        } else if (filter.getClass().equals(FlightNoFilter.class)) {
            return FlightNoValidator.getInstance();
        } else throw new IllegalAccessException();
    }
}
