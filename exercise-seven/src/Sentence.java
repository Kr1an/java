import java.util.ArrayList;

public class Sentence implements WordCharReplacer {
    private ArrayList<Word> words = new ArrayList<Word>();
    public Sentence(String sentenceString) {
        String[] wordStrings = sentenceString.split(" ");
        for (int i = 0; i < wordStrings.length; i++) {
            Word word = new Word(wordStrings[i]);
            this.words.add(word);
        }
    }

    @Override
    public void replaceChar(int placeInWord, char replaceWith) {
        for (Word word: this.words)
            word.replaceChar(placeInWord, replaceWith);
    }

    @Override
    public String toString() {
        ArrayList<String> wordStrings = new ArrayList<String>();
        for (Word word: this.words) {
            String wordString = word.toString();
            wordStrings.add(wordString);
        }
        String sentenceString = String.join(" ", wordStrings);
        return sentenceString;
    }
}
