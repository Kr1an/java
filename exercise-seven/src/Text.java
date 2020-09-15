import java.util.ArrayList;
import java.util.Arrays;

public class Text implements WordCharReplacer {
    private ArrayList<Paragraph> paragraphs = new ArrayList<Paragraph>();
    public Text(ArrayList<String> paragraphStrings) {
        for (int i = 0; i < paragraphStrings.size(); i++) {
            Paragraph paragraph = new Paragraph(paragraphStrings.get(i));
            this.paragraphs.add(paragraph);
        }
    }
    public Text(String[] paragraphStrings) {
        this(new ArrayList<String>(Arrays.asList(paragraphStrings)));
    }
    public Text(String textString) {
        this(textString.split(System.getProperty("line.separator")));
    }
    @Override
    public void replaceChar(int placeInWord, char replaceWith) {
        for (Paragraph paragraph: this.paragraphs)
            paragraph.replaceChar(placeInWord, replaceWith);
    }
    @Override
    public String toString() {
        ArrayList<String> paragraphStrings = this.toArrayList();
        String textString = String.join("\n", paragraphStrings);
        return textString;
    }
    public ArrayList<String> toArrayList() {
        ArrayList<String> paragraphStrings = new ArrayList<String>();
        for (Paragraph paragraph: this.paragraphs) {
            String paragraphString = paragraph.toString();
            paragraphStrings.add(paragraphString);
        }
        return paragraphStrings;
    }
}
