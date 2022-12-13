package tasks._7_str_regex;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class DateValidator extends Validator {
    private final String format;

    public DateValidator(String format) {
        this.format = format;
    }

    public String getFormat() {
        return format;
    }

    @Override
    public boolean isCorrect(String string) {
        try {
            var simpleDateFormat = new SimpleDateFormat(format);
            simpleDateFormat.parse(string);

            return true;
        } catch(ParseException exception) {
            return false;
        }
    }
}
