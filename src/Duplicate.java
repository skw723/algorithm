public class Duplicate {
    public static void main(String[] args) {
        String input = "abcad";

        if (exec(input)) {
            System.out.println("Pass");
        } else {
            System.out.println("Failure");
        }
    }

    private static boolean exec(String input) {
        if (input == null || input.length() > 128) {
            return false;
        }

        boolean[] hash = new boolean[128];

        for (int c : input.toCharArray()) {
            if (hash[c] == true) {
                return false;
            } else {
                hash[c] = true;
            }
        }

        return true;
    }
}
