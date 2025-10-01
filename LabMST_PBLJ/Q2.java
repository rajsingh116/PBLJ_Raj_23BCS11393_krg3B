java.util.ArrayList;
import java.util.Scanner;

public class AverageCalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> numbers = new ArrayList<>();

        System.out.println("Enter numbers (type 'done' to finish):");
        while (true) {
            String input = sc.nextLine();
            if (input.equalsIgnoreCase("done")) {
                break;
            }
            try {
                int num = Integer.parseInt(input);
                numbers.add(num);
            } catch (NumberFormatException e) {
                System.out.println("Error: Invalid input, please enter a valid integer.");
            }
        }

        try {
            if (numbers.size() == 0) {
                throw new ArithmeticException("Cannot calculate average of empty list.");
            }
            int sum = 0;
            for (int n : numbers) {
                sum += n;
            }
            double average = (double) sum / numbers.size();
            System.out.println("Average: " + average);
        } catch (ArithmeticException e) {
            System.out.println("Error: " + e.getMessage());
        }

        sc.close();
    }
}
