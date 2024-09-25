package TddPracticeInJava;

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
        int total = 0;
        List<Integer> negatives = new ArrayList<>();

        for (String num : numberList) {
            if (!num.isEmpty()) {  // Skip empty strings
                int n = Integer.parseInt(num);
                if (n < 0) {
                    negatives.add(n);  // Collect negatives
                } else if (n <= 1000) {
                    total += n;  // Sum numbers less than or equal to 1000
                }
            }
        }

        // Raise exception if there are negatives
        if (!negatives.isEmpty()) {
            throw new IllegalArgumentException("negatives not allowed: " + negatives);
        }

        return total;
    }
}
