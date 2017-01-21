
public class Compress {
    public static void main(String[] args) {
        String input = "abbbbbbbbbbca";

        String result  = exec(input);
        System.out.println(result);
    }

    private static String exec(String input) {
        if (input == null | input.length() < 0) {
            throw new IllegalArgumentException("input is null or empty");
        }
        StringBuilder compress = new StringBuilder(input.length());
        char[] inputChars = input.toCharArray();
        char buffer = inputChars[0];
        int count = 1;

        for (int i = 1; i < inputChars.length; i++) {
            if (buffer == inputChars[i]) {
                count++;
            } else {
                compress.append(buffer);
                compress.append(count);
                buffer = inputChars[i];
                count = 1;
            }
        }

        compress.append(buffer);
        compress.append(count);

        if (compress.length() >= input.length()) {
            return input;
        } else {
            return compress.toString();
        }
    }
}
