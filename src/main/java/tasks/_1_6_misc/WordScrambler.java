package tasks._1_6_misc;

public final class WordScrambler {
    private WordScrambler() {
        throw new UnsupportedOperationException("WordScrambler is a utility class. Do not create instances of it. Use static methods instead.");
    }
    
    public static String scrambleWord(String word) {
        StringBuilder scrambledWord = new StringBuilder();
        boolean swappingPerformed = false;

        char[] characters = word.toCharArray();
        for (int index = 0; index < characters.length; index++) {
            char character = characters[index];

            if(swappingPerformed && character != 'A') {
                swappingPerformed = false;
            } else if (character == 'A' && index != characters.length - 1) {
                scrambledWord.append(characters[index + 1]);
                scrambledWord.append(character);
                swappingPerformed = true;
            } else {
                scrambledWord.append(character);
            }
        }

        return scrambledWord.toString();
    }
}
