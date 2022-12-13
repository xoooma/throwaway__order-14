package tasks._7_str_regex;

public class ArticleValidator extends RegexValidator {

    public ArticleValidator() {
        super("^[А-Я]{1}[а-я]{2,} [А-Я]{1}[а-я]{2,} [А-Я]{1}[а-я]{2,} \\\"[А-Я]{1}[а-я]{2,}\\\" \\\"[А-Я]{1}[а-я]{2,}\\\" [0-9]{1,3} [1-2]{0,1}[0-9]{3} [1-9]{1}[0-9]{1,3}$");
    }
}
