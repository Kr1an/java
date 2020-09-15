import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;


public class Main {

    public static void main(String[] args) {
        ArrayList<String> words = new ArrayList<>();
        ArrayList<Integer> counts = new ArrayList<>();
        if (!words.contains("word1")) {
            words.add("word1");
            counts.add(0);
        }
        int index = words.indexOf("word1");
        counts.set(index, counts.get(index) + 1);
    }

    public static String getOneLiner() {
        String text = "first paragraph first sentence. first paragraph second sentence\n" +
                "second paragraph first sentence. second paragraph second sentence\n" +
                "third paragraph first sentence. third paragraph second sentence\n";
        return text;
    }
    public static ArrayList<String> getText() {
        ArrayList<String> input = new ArrayList<String>();
        input.add("first paragraph first sentence. first paragraph second sentence");
        input.add("second paragraph first sentence. second paragraph second sentence");
        input.add("third paragraph first sentence. third paragraph second sentence");
        return input;
    }
    public static int askPlaceInWord() {
        System.out.println("Enter numeric position of the character that should be replaced in each word:");
        Scanner scan = new Scanner(System.in);
        int position = scan.nextInt();
        return position;
    }
    public static char askReplacerChar() {
        System.out.println("Enter Replacer character:");
        Scanner scan = new Scanner(System.in);
        String str = scan.nextLine();
        if (str.length() < 1) return '%';
        return str.charAt(0);
    }
    public static ArrayList<String> readText() {
        System.out.println("Enter text. Each line is a new paragraph. Sentences are separated by a dot '.' and word - by a space ' '");
        ArrayList<String> lines = new ArrayList<String>();
        Scanner scan = new Scanner(System.in);
        for(int i = 0; true; i++) {
            String line = scan.nextLine();
            if (line.length() == 0)
                break;
            lines.add(line);
        }
        return lines;
    }

}