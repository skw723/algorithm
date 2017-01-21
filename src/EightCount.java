import java.util.stream.IntStream;

public class EightCount {
    private static int count = 0;
    public static void main(String[] args) {
        for (int i = 1; i <= 80; i++) {
            findEight(i);
        }

        System.out.println(count);
    }

    private static void findEight(int i) {
        if (i % 10 == 8) {
            count++;
        }

        if (i > 10) {
            findEight(i / 10);
        }
    }
}
