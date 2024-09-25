import java.util.Scanner;

public class StringCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter two numbers separated by a comma: ");
        
        String input = scanner.nextLine().replace("\n", "").replace(";", "").trim();
        String[] numbers = input.split(",");

         System.out.println("The sum is: " + printNumber());

        scanner.close();
    }

    private static int getValidNumber(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please enter a valid number.");
            return -1; // Return an invalid number
        }
    }

    private void printNumber() {
        if (numbers.length != 2) {
            System.out.println("Please enter exactly two numbers.");
        } else {
            int num1 = getValidNumber(numbers[0].trim());
            int num2 = getValidNumber(numbers[1].trim());

            return printSum(numbers[0], numbers[1]);
            //System.out.println("The sum is: " + printSum(numbers[0], numbers[1]));
        }

        private printSum(int num1, int num2){
            if (num1 <= 1000 && num2 <= 1000) {
                int sum = num1 + num2;
                return sum;
                //System.out.println("The sum is: " + sum);
            }
        }
}
