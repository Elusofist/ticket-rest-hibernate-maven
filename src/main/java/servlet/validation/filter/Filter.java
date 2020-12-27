package servlet.validation.filter;

import servlet.validation.validator.Validator;
import servlet.validation.validator.ValidatorFactory;

public abstract class Filter {
    private Validator validator;

    public Validator getValidator() {
        try {
            validator = ValidatorFactory.getValidator(this);
        } catch (IllegalAccessException e) {
            System.out.println(e.getMessage());
        }
        return validator;
    }
}
