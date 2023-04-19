import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a word: ");
        String word = scanner.nextLine();

        HashMap<Character, Integer> chars = new HashMap<>();
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
                chars.put(c,1);

        }

        ArrayList<String> anagrams = new ArrayList<>();
        generateAnagrams(chars, "", word.length(), anagrams);


        System.out.println("Anagrams:");
        for (String anagram : anagrams) {
            System.out.println(anagram);
        }
    }

    private static void generateAnagrams(HashMap<Character, Integer> charCount, String currentAnagram, int remainingChars, ArrayList<String> anagrams) {
        if (remainingChars == 0) {
            anagrams.add(currentAnagram);
            return;
        }
        for (char c : charCount.keySet()) {
            int count = charCount.get(c);
            if (count > 0) {
                charCount.put(c, count - 1);
                generateAnagrams(charCount, currentAnagram + c, remainingChars - 1, anagrams);
                charCount.put(c, count);
            }
        }
    }
}


