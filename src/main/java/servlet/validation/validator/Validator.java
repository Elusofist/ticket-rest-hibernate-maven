package servlet.validation.validator;

public interface Validator<T> {
    boolean isValid(T t);
}
