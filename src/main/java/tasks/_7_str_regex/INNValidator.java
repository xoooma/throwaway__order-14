package tasks._7_str_regex;

public class INNValidator extends RegexValidator {

    public INNValidator() {
        super("^[0-9]{10}$");
    }
}
