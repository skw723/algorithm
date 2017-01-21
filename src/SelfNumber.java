
public class SelfNumber {
    public static void main(String[] args) {
        int limit = 5000;

		/*
		 * D(n) = n + j(자릿수 합) = i
		 * 1 ~ limit 중에 i로 나올 수 없는 수(self number)
		 * */
        for (int i = 1; i <= limit; i++) {
			/*
			 * 자릿수 합의 최대값은 pow_dec(i) * 9
			 *
			 * */
            int jMax = pow_dec(i) * 9;
            boolean find = false;
            for (int j = 1; j <= jMax; j++) {
                int n = i - j;
                //n은 1 ~ limit 이므로
                if (n < 1 || n > limit) {
                    break;
                }
                if (valid(n, j)) {
                    find = true;
                    break;
                }
            }

            if (find) {
                //self number가 아니다
            } else {
                //self number이다.
                System.out.println(i);
            }
        }
    }

    private static boolean valid(int n, int currentJ) {
        int j = 0;
        while (n > 9) {
            j += n % 10;
            n /= 10;
        }
        j+=n;

        if (j == currentJ) {
            return true;
        } else {
            return false;
        }
    }

    public static int pow_dec(int num) {
        int i = 1;

        while (num > 9) {
            num /= 10;
            i++;
        }

        return i;
    }
}
