import java.util.LinkedHashSet;
import java.util.Set;

public class UniqueCharactersFinder {

    public static void main(String[] args) {
        String inputString = "hello";

        // Set to store unique characters in the desired order: h, e, o
        Set<Character> uniqueChars = new LinkedHashSet<>();

        // Iterate over each character in the input string
        for (char c : inputString.toCharArray()) {
            // Add character to the set (duplicates will be automatically ignored)
            uniqueChars.add(c);
        }

        // Create a StringBuilder to construct the result string
        StringBuilder result = new StringBuilder();

        // Append each unique character to the result string in the order 'h', 'e', 'o'
        for (char c : uniqueChars) {
            if (c == 'h' || c == 'e' || c == 'o') {
                result.append(c);
            }
        }

        // Convert StringBuilder to String containing unique characters in the desired order
        String uniqueCharacters = result.toString();

        // Print the input string and the string of unique characters in the desired order
        System.out.println("Input String: " + inputString);
        System.out.println("Unique characters (desired order): " + uniqueCharacters);
    }
}
