

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.List;

public class BribeThePrisoners {
	private static int[][] memory;

	public static void main(String[] args) throws IOException {
//		List<String> readLine = Files.readAllLines(FileSystems.getDefault().getPath("C-small-practice.in"));
				List<String> readLine = Files.readAllLines(FileSystems.getDefault().getPath("C-large-practice.in"));

		int count = Integer.parseInt(readLine.get(0));
		readLine.remove(0);

		int readLineCount = 0;
		for (int i = 0; i < count; i++) {
			String[] token = readLine.get(readLineCount++).split(" ");
			int P = Integer.parseInt(token[0]);
			int Q = Integer.parseInt(token[1]);

			token = readLine.get(readLineCount++).split(" ");
			int[] A = new int[Q];
			for (int index = 0; index < Q; index++) {
				A[index] = Integer.parseInt(token[index]);
			}

			memory = new int[P + 1][P + 1];
			for (int j = 0; j < P + 1; j++) {
				Arrays.fill(memory[j], -1);
			}
			System.out.println(String.format("Case #%d: %d", i + 1, solve(1, P, A)));
		}
	}

	public static int solve(int start, int end, int[] prisoners) {
		if (start > end) {
			return 0;
		}

		if (memory[start][end] != -1) {
			return memory[start][end];
		}

		int minimumGold = 0;
		for (int i = 0; i < prisoners.length; i++) {
			int prisoner = prisoners[i];
			if (start > prisoner || end < prisoner) {
				continue;
			}

			int[] otherPrisoner = Arrays.stream(prisoners).filter(n -> n != prisoner).toArray();
			int gold = (end - start) + solve(start, prisoner - 1, otherPrisoner) + solve(prisoner + 1, end, otherPrisoner);

			if (minimumGold > gold || minimumGold == 0) {
				minimumGold = gold;
			}
		}
		memory[start][end] = minimumGold;
		return minimumGold;
	}
}
