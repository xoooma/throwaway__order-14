package tasks._7_str_regex;

import java.util.Locale;

public class CountryValidator extends Validator {

    @Override
    public boolean isCorrect(String string) {
        for (var countryCode : Locale.getISOCountries()) {
            Locale locale = new Locale("", countryCode);

            if(string.equalsIgnoreCase(locale.getDisplayCountry())) {
                return true;
            }
        }

        return false;
    }
}
