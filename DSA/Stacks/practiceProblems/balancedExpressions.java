import java.util.Stack;

public class balancedExpressions {

    public static void main(String[] args) {
        String expression = "{[23e^2 + (pi * 71e)]/(2x^2 + 13x + 7)}";
        System.out.println("\nIs Balanced: " + isBalanced(expression).toString());
    }

    static Boolean isBalanced(String expression) {
        Stack<Character> stack = new Stack<>();
        for (char ch : expression.toCharArray()) {
            if (isOpening(ch)) {
                stack.push(findClosingPair(ch));
            } else if (isClosing(ch)) {
                if (stack.isEmpty() || ch != stack.pop()) {
                    return false;
                }
            }

        }
        return true;
    }

    static Boolean isOpening(char ch) {
        return switch (ch) {
            case '{', '[', '(', '<' -> true;
            default -> false;
        };
    }

    static Boolean isClosing(char ch) {
        return switch(ch){
            case '}', ']', ')', '>' -> true;
            default -> false;
        };
    }

    static Character findClosingPair(char ch) {
        switch (ch) {
            case '{' -> {
                return '}';
            }
            case '[' -> {
                return ']';
            }
            case '<' -> {
                return '>';
            }
            case '(' -> {
                return ')';
            }
            default ->
                throw new AssertionError();
        }
    }

}
