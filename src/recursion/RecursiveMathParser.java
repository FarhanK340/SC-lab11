package recursion;

public class RecursiveMathParser {
    public static double evaluateExpression(String expression) throws IllegalArgumentException {
        expression = expression.replaceAll("\\s", ""); // Remove spaces

        if (expression.isEmpty()) {
            throw new IllegalArgumentException("Expression cannot be empty.");
        }

        return parseExpression(expression, new int[]{0});
    }

    private static double parseExpression(String expression, int[] index) throws IllegalArgumentException {
        double result = parseTerm(expression, index);

        while (index[0] < expression.length()) {
            char operator = expression.charAt(index[0]);

            if (operator == '+' || operator == '-') {
                index[0]++; // Move past the operator
                double rightOperand = parseTerm(expression, index);
                result = (operator == '+') ? result + rightOperand : result - rightOperand;
            } else {
                break; // Stop if no more + or -
            }
        }

        return result;
    }

    private static double parseTerm(String expression, int[] index) throws IllegalArgumentException {
        double result = parseFactor(expression, index);

        while (index[0] < expression.length()) {
            char operator = expression.charAt(index[0]);

            if (operator == '*' || operator == '/') {
                index[0]++; // Move past the operator
                double rightOperand = parseFactor(expression, index);
                result = (operator == '*') ? result * rightOperand : result / rightOperand;
            } else {
                break; // Stop if no more * or /
            }
        }

        return result;
    }

    private static double parseFactor(String expression, int[] index) throws IllegalArgumentException {
        char currentChar = expression.charAt(index[0]);

        if (currentChar == '(') {
            index[0]++; // Move past the '('
            double value = parseExpression(expression, index);
            if (index[0] >= expression.length() || expression.charAt(index[0]) != ')') {
                throw new IllegalArgumentException("Unmatched parentheses.");
            }
            index[0]++; // Move past the ')'
            return value;
        } else {
            return parseNumber(expression, index);
        }
    }

    private static double parseNumber(String expression, int[] index) throws IllegalArgumentException {
        StringBuilder numberStr = new StringBuilder();

        while (index[0] < expression.length()) {
            char c = expression.charAt(index[0]);

            if (Character.isDigit(c) || c == '.' || (c == '-' && numberStr.length() == 0)) {
                numberStr.append(c);
                index[0]++; // Move past the current character
            } else {
                break; // Stop when encountering a non-numeric character
            }
        }

        if (numberStr.isEmpty()) {
            throw new IllegalArgumentException("Expected a number but found: " + expression);
        }

        try {
            return Double.parseDouble(numberStr.toString());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Invalid number format: " + numberStr);
        }
    }
}
