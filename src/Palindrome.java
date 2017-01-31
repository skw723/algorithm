/*
* 각 자리수에서 해당하는 숫자의 개수
* 자릿수 : n
* 10^(n/2-1)*9 * 10^(n%2) ==> 1자리는 9가 나오는데 0이 포함되지 않았음
* 숫자를 2등분 했을 때 앞뒤의 숫자는 같은 숫자에 순서만 다르므로
* n/2자리에 올 수 있는 숫자의 개수임...(1자리:1~9까지 9개, 2자리:10~99까지 90개, 3자리:100~999까지 900개 ......)
* 자리수가 홀수인 경우에는 가운데에는 10가지(0~9까지) 숫자가 올 수 있으므로 10을 곱해줌
* */
public class Palindrome {
    public static void main(String[] args) {
        int input = 1000000000;

        System.out.println(getResult(input));
    }

    // 1에서 10까지는 0~9이므로 입력-1로 출력하고
    // 11부터는 위의 각 자라수별 식을 사용해서 범위를 결정 ==> 결과가 몇 자리냐...
    // ex) 3자리라면 입력값 - 2자리까지 개수를 뺀 나머지 횟수만큼 진행되어야 하므로
    // 남은 횟수만 계산하면 됨....
    // 짝수인경우 해당 자리수의 시작값에 차이값만큰 더해주고
    // 차이값의 일의자리를 가운데숫자에, 나머지 숫자를 시작값에 더해줌
    private static String getResult(int input) {
        if (input <= 10) {
            return String.valueOf(input - 1);
        }

        // 1자리 범위
        int totalRange = 10;
        int unit = 1;

        int range = 0;
        while (totalRange < input) {
            unit++;
            range = (int) Math.pow(10, unit / 2 - 1) * 9;
            if (unit % 2 == 1) {
                range *= 10;
            }
            totalRange += range;
        }

        // 차이만큼 계산, 이전 자릿수 최대값->다음 자릿수 시작값(-1)
        int distance = input - (totalRange - range) - 1;
        int mid = 0;
        // 숫자를 2등분 했을 때 좌측 시작값
        int start = (int) Math.pow(10, unit / 2 - 1);

        // 홀수인 경우 distance의 일의자리가 mid로 나머지는 start값에 +
        // 짝수인 경우에는 start값에 +
        if (unit % 2 == 1) {
            start += distance / 10;
            mid = distance % 10;
        } else {
            start += distance;
        }

        String num = String.valueOf(start);
        if (unit % 2 == 1) {
            num = num + mid + new StringBuilder(num).reverse().toString();
        } else {
            num = num + new StringBuilder(num).reverse().toString();
        }

        return num;
    }
}
