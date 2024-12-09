package recursion;

public class RecursiveSumOfDigits {

    /**
     * Recursively calculates the sum of digits of a given integer.
     *
     * @param number The integer whose sum of digits needs to be calculated.
     *               Negative numbers are converted to positive.
     * @return The sum of the digits.
     */
    public static int sumOfDigits(int number) {
        // Handle negative numbers by converting to positive
        if (number < 0) {
            number = -number;
        }

        // Base case: If the number is 0, the sum of digits is 0
        if (number == 0) {
            return 0;
        }

        // Recursive step: Sum the last digit and recurse on the rest
        return number % 10 + sumOfDigits(number / 10);
    }
}
