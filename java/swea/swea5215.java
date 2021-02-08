import java.util.*;

public class swea5215 {

	static int N;
	static int L;
	static int[] score;
	static int[] kal;
	static boolean[] check;
	static int max;

	public static void comb(int x, int depth, int n) {
		if (depth == n) {
			int sumScore = 0;
			int sumKal = 0;
			for (int i = 0; i < N; i++) {
				if (check[i] == false)
					continue;
				sumScore += score[i];
				sumKal += kal[i];
				if (sumKal > L) {
					return;
				}
			}
			max = Math.max(sumScore, max);
			return;

		}

		for (int i = x; i < N; i++) {
			if (check[i] == false) {
				check[i] = true;
				comb(i, depth + 1, n);
				check[i] = false;
			}
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			N = sc.nextInt();
			L = sc.nextInt();
			score = new int[N];
			kal = new int[N];
			check = new boolean[N];
			max = Integer.MIN_VALUE;
			for (int i = 0; i < N; i++) {
				score[i] = sc.nextInt();
				kal[i] = sc.nextInt();
			}

			for (int i = 1; i <= N; i++) {
				comb(0, 0, i);
			}

			System.out.println("#" + t + " " + max);
		}
	}
}
