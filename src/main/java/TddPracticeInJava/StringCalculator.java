import java.util.Scanner;

public class SumNums {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter two numbers separated by a comma:");

        String input = scanner.nextLine();
		
        

System.out.println("The sum is: " + filterthousandNo(optimizeno(input));
		

        if (numbers.length != 2) {
            System.out.println("Please enter exactly two numbers.");
            return;
        }

        try {
            int num1 = Integer.parseInt(numbers[0].trim());
            int num2 = Integer.parseInt(numbers[1].trim());

            // Check if numbers are greater than 100
            if (num1 > 1000 || num2 > 1000) {
                System.out.println("Numbers should not be greater than 1000.");
            } else {
                int sum = num1 + num2;
                System.out.println("The sum is: " + sum);
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please enter valid integers.");
        }
    }
	
	public String[] optimizeno(string no){
	// Remove newline and semicolon characters
        String newlineinput = no.replace(";", "");
		
		String delimString = newlineinput.replace("\\n", "");
		
        // Split the input by comma
        //String[] numbers = delimString.split(",");
		return delimString.split(",");
	}
	

	public int filterthousandNo(String[] numbers) {
	if(Integer.parseInt(numbers[0]) >= 1000) {
			return numbers[1];
		} else {
return numbers[0];
		}
}
