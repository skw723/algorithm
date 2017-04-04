
public class TwoPrinters {
	public static void main(String[] args) {
		long a = 200;
		long b = 130;
		long page = 1000000;
		/*
		 * 프린터의 페이지 출력 시간을 각각 a,b라 할 때 x/a + x/b = page 이고
		 * page <= x/a + x/b < page + 1 이므로
		 * a * b * page <= (a + b)x < a * b * (page + 1) 을 만족하는 자연수중
		 * a나 b로 나누어떨어지는 수
		 * ==> a * b * page / (a + b) <= x < a * b * (page + 1) / (a + b)
		 * */
		int min = (int)Math.ceil(a * b * page / (double)(a + b));
		int max = (int)Math.ceil(a * b * (page + 1) / (double)(a + b));

		for (int x = min; x <= max; x++) {
			if (x % a == 0 || x % b == 0) {
				System.out.print(x);
				break;
			}
		}
	}
}
