package tasks._15_lambda;

import java.util.List;
import java.util.function.BiFunction;

public final class LambdaTest {
    private LambdaTest() {
        throw new RuntimeException("This constructor MUST NOT be used.");
    }

    private static long countVowels(String string) {
        return string
                .chars()
                .boxed()
                .filter(character -> List.of('a', 'i', 'u', 'e', 'o').contains((char) Character.toLowerCase(character)))
                .count();
    }

    private static long countCapitalLetters(String string) {
        return string
                .chars()
                .boxed()
                .filter(Character::isUpperCase)
                .count();
    }

    public static void test() {
        BiFunction<String, String, String> longestString = (a, b) -> a.length() > b.length() ? a : b;
        BiFunction<String, String, String> mostCapitalLetters = (a, b) -> countCapitalLetters(a) > countCapitalLetters(b) ? a : b;
        BiFunction<String, String, String> mostVowels = (a, b) -> countVowels(a) > countVowels(b) ? a : b;

        System.out.println(longestString.apply("a", "aaa")); // aaa
        System.out.println(longestString.apply("bbb", "b")); // bbb

        System.out.println(mostCapitalLetters.apply("Aaa", "AAa")); // AAa
        System.out.println(mostCapitalLetters.apply("AaAA", "BBBB")); // BBBB

        System.out.println(mostVowels.apply("AOAOAO", "HKHKHK")); // AOAOAO
        System.out.println(mostVowels.apply("TOTOTO", "OTOTOTO")); // OTOTOTO
    }
}
