package tasks._1_6_misc;

import java.util.ArrayList;
import java.util.List;

public class WordList {
    private final ArrayList<String> words;

    public WordList(String... words) {
        this.words = new ArrayList<>(List.of(words));
    }

    public void add(String word) {
        words.add(word);
    }

    public int countWordsOfLength(int length) {
        return (int) words.stream().filter(word -> word.length() == length).count();
    }

    public void removeWordsOfLength(int length) {
        words.removeIf(word -> word.length() == length);
    }
}
