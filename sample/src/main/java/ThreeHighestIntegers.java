import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ThreeHighestIntegers {

    public static void printThreeHighestUnique(List<Integer> numbers) {
        // Step 1: Count occurrences of each integer
        Map<Integer, Long> frequencyMap = numbers.stream()
                .collect(Collectors.groupingBy(i -> i, Collectors.counting()));

        // Step 2 & 3: Sort by frequency and limit to 3 highest
        frequencyMap.entrySet().stream()
                .sorted(Map.Entry.<Integer, Long>comparingByValue().reversed())
                .limit(3)
                .forEach(entry -> System.out.println(entry.getKey() + ": " + entry.getValue()));
    }

    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(3, 5, 2, 5, 3, 7, 8, 2, 3, 5, 8);
        System.out.println("Three highest unique integers:");
        printThreeHighestUnique(numbers);
    }
}
