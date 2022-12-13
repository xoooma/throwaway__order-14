package tasks._7_str_regex;

import java.util.Objects;

public class RegexValidator extends Validator {
    private final String regex;

    public RegexValidator(String regex) {
        Objects.requireNonNull(regex, "Regex in RegexValidator must be present.");

        this.regex = regex;
    }

    public String getRegex() {
        return regex;
    }

    @Override
    public boolean isCorrect(String string) {
        return string.matches(regex);
    }
}
