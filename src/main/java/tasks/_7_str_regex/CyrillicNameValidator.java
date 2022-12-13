package tasks._7_str_regex;

public class CyrillicNameValidator extends RegexValidator {
    public CyrillicNameValidator() {
        super("^[А-Я]{1}[а-я]{2,}$");
    }
}
