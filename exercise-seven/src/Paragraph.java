import java.util.ArrayList;

public class Paragraph implements WordCharReplacer {
    private ArrayList<Sentence> sentences = new ArrayList<Sentence>();

    public Paragraph(String paragraphString) {
        String[] sentenceStrings  = paragraphString.split("\\.");
        for (int i = 0; i < sentenceStrings.length; i++) {
            Sentence sentence = new Sentence(sentenceStrings[i]);
            this.sentences.add(sentence);
        }
    }

    @Override
    public void replaceChar(int placeInWord, char replaceWith) {
        for (Sentence sentence: this.sentences)
            sentence.replaceChar(placeInWord, replaceWith);
    }
    @Override
    public String toString() {
        ArrayList<String> sentenceStrings = new ArrayList<String>();
        for (Sentence sentence: this.sentences) {
            String sentenceString = sentence.toString();
            sentenceStrings.add(sentenceString);
        }
        String paragraphString = String.join(".", sentenceStrings);
        return paragraphString;
    }
}
