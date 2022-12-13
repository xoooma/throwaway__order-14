package tasks._7_str_regex;

public class PostalNumberValidator extends RegexValidator {
    public PostalNumberValidator() {
        super("^[0-9]{6}$");
    }
}
