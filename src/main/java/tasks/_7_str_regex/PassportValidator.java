package tasks._7_str_regex;

public class PassportValidator extends RegexValidator {

    public PassportValidator() {
        super("^[0-9]{4} [0-9]{6}$");
    }
}
