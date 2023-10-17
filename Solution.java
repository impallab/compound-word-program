import java.io.*;
import java.util.*;
class Trie {
    Map<Character, Trie> child = new HashMap<>();
    boolean wordEnd = false;
}
public class Solution {
    static Trie root = new Trie();
    public static void main(String[] args) throws IOException {
        List<String> files = Arrays.asList("input_01.txt", "input_02.txt");
        for (String f : files) {
            long begin = System.nanoTime();
            List<String> w = new ArrayList<>();
            try (BufferedReader br = new BufferedReader(new FileReader(f))) {
                String line;
                while ((line = br.readLine())!= null) {
                    w.add(line);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            w.sort(Comparator.comparing(String::length));
            String top = "";
            String topTwo = "";
            for (String word : w) {
                if (compoundOrNot(word)) {
                    if (word.length() > top.length()) {
                        topTwo = top;
                        top = word;
                    } else if (word.length() > topTwo.length()) {
                        topTwo = word;
                    }
                }
                appendWord(word);
            }
            long finish = System.nanoTime();
            System.out.println("File:=> " + f);
            System.out.println("Longest compound word is :=> " + top);
            System.out.println("Second longest compound word is :=> " + topTwo);
            System.out.println("Time taken :=> " + (finish - begin) / 1e9 + " sec");
        }
    }
    private static void appendWord(String word) {
        Trie node = root;
        for (char letter : word.toCharArray()) {
            node.child.putIfAbsent(letter, new Trie());
            node = node.child.get(letter);
        }
        node.wordEnd = true;
    }
    private static boolean compoundOrNot(String word) {
        return compoundOrNot(root, word, 0, 0);
    }
    private static boolean compoundOrNot(Trie node, String word, int i, int count) {
        if (i == word.length())  return count > 1 && node.wordEnd;
        char letter = word.charAt(i);
        if (!node.child.containsKey(letter)) return false;
        if (node.child.get(letter).wordEnd) {
            if (compoundOrNot(root, word, i + 1, count + 1))return true;
        }return compoundOrNot(node.child.get(letter), word, i + 1, count);
    }
}
