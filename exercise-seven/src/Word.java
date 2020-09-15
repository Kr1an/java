public class Word implements WordCharReplacer {
    private String value;
    public Word(String wordString) {
        this.value = wordString;
    }

    @Override
    public void replaceChar(int placeInWord, char replaceWith) {
        if (placeInWord < 1 || placeInWord > this.value.length()) {
            // place is out of bound
            return;
        }
        char[] chars = this.value.toCharArray();
        chars[placeInWord - 1] = replaceWith;
        this.value = String.valueOf(chars);
    }

    @Override
    public String toString() {
        return this.value;
    }
}
