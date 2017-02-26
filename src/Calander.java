import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.util.List;

/**
 * Created by sgoh on 2017-02-26.
 */
public class Calander {
    public static void main(String[] args) throws IOException {
//		List<String> readLine = Files.readAllLines(FileSystems.getDefault().getPath("A-small-practice.in"));
        List<String> readLine = Files.readAllLines(FileSystems.getDefault().getPath("A-large-practice.in"));

        long iteration = Long.parseLong(readLine.get(0));
        readLine.remove(0);

        for (long count = 1; count <= iteration; count++) {
            String line = readLine.get((int) (count - 1));
            String[] token = line.split(" ");
            long result = getCalanderLine(Long.parseLong(token[0]), Long.parseLong(token[1]), Long.parseLong(token[2]));
            System.out.println(String.format("Case #%d: %d", count, result));
        }
    }

    public static long getCalanderLine(long monthOfYear, long dayOfMonth, long dayOfWeek) {
        long defaultMonthLine = dayOfMonth / dayOfWeek;
        long remainDay = dayOfMonth % dayOfWeek;
        if (remainDay > 0) {
            defaultMonthLine++;
        } else {
            return defaultMonthLine * monthOfYear;
        }

		/*
		 * totalLine = cycle * linePerCycle + remainLine
		 * cycle은 remainDay의 합이 dayOfWeek와 unfinishedDay의 최소공배수일때 1cycle임....
		 * => cycle = lcd(dayOfWeek, remainDay) / remainDay
		 * linePerCycle은 1cycle의 전체 일수 / dayOfWeek
		 *
		 * 최소공배수 = (a * b) / 최대공약수
		 * 최대공약수 = (a * b) / 최소공배수
		 *
		 * 1. cycle, linePerCycle을 구함
		 * 2. monthOfYear / cycle * linePerCycle => 총 cycle의 라인 수
		 * 3. remainMonth의 line수 => 월별로 defaultMonthLine + (remain의 합이 dayOfWeek보다 크면 1 아니면 0)
		 * 4. 2 + 3
		 * */

        long gcd = gcd(dayOfWeek, remainDay);
        long lcd = dayOfWeek * remainDay / gcd;
        long cycle = lcd / remainDay;
        long linePerCycle = dayOfMonth * cycle / dayOfWeek + cycle - 1;

        long line = 0;
        long remain = 0;
        for (int i = 0; i < monthOfYear % cycle; i++) {
            line += defaultMonthLine;
            remain += dayOfMonth % dayOfWeek;
            if (remain > dayOfWeek) {
                line++;
                remain -= dayOfWeek;
            }
        }
        return (monthOfYear / cycle * linePerCycle) + line;
    }

    /**
     * 유클리드 알고리즘 사용
     */
    private static long gcd(long numberA, long numberB) {
        if (numberB == 0) {
            return numberA;
        }
        return gcd(numberB, numberA % numberB);
    }
}
