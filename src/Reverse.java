import java.util.Stack;

public class Reverse {
    public static void main(String[] args) {
        String input = "abcde";

        exec(input);
    }

    private static void exec(String input) {
        if (input == null | input.length() < 0) {
            throw new IllegalArgumentException("input is null or empty");
        }
        Stack<Character> stack = new Stack<>();
        for (char ch : input.toCharArray()) {
            stack.push(ch);
        }

        while (stack.isEmpty() == false) {
            System.out.print(stack.pop());
        }
    }
}
