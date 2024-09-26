package TddPracticeInJava;

import java.util.ArrayList;
import java.util.List;
public class StringCalculator {
    
    // Main method to add numbers from a given string input
    public int add(String numbers) {
        // Handle empty string case
        if (numbers.isEmpty()) {
            return 0;
        }
        
        String[] numberList = parseNumbers(numbers);
        return calculateSum(numberList);
    }

    // Method to parse numbers by handling custom delimiters
    private String[] parseNumbers(String numbers) {
        String delimiter = ",|\n";  // Default delimiters: comma and newline

        // Check for custom delimiter
        if (numbers.startsWith("//")) {
            delimiter = extractDelimiter(numbers);
            numbers = numbers.substring(numbers.indexOf('\n') + 1);  // Remove the delimiter line
        }

        // Split numbers based on the delimiter
        return numbers.split(delimiter);
    }

    // Method to extract the custom delimiter from the input
    private String extractDelimiter(String numbers) {
        // Get the line containing the delimiter
        String delimiterLine = numbers.substring(2, numbers.indexOf('\n'));
        return delimiterLine.replaceAll("\\[", "").replaceAll("\\]", "");  // Handle delimiters like //[] and others
    }

    // Method to calculate the sum of the parsed numbers
    private int calculateSum(String[] numberList) {
        List<Integer> negatives = new ArrayList<>();
        int total = 0;

        for (String num : numberList) {
            if (!num.isEmpty()) {
                int n = Integer.parseInt(num);
                checkNegative(n, negatives); // Check for negatives
                total += addValidNumber(n);   // Add valid numbers to total
            }
        }

        // Raise exception if there are negatives
        handleNegatives(negatives);

        return total;
    }

     // Method to check if the number is negative and collect them
    private void checkNegative(int number, List<Integer> negatives) {
        if (number < 0) {
            negatives.add(number);  // Collect negatives
        }
    }

    // Method to handle negative numbers and throw an exception if needed
    private void handleNegatives(List<Integer> negatives) {
        if (!negatives.isEmpty()) {
            throw new IllegalArgumentException("negatives not allowed: " + negatives);
        }
    }

    // Method to add a valid number (ignore if greater than 1000)
    private int addValidNumber(int number) {
        return (number <= 1000) ? number : 0;
    }
}
