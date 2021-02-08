import java.util.*;

public class swea9229 {

	static int N;
	static int M;
	static int[] snack;
	static boolean[] check;
	static int max;

	public static void comb(int depth, int x) {
		if (depth == 2) {
			int snack_sum = 0;
			for (int i = 0; i < check.length; i++) {
				if (check[i] == true) {
					snack_sum += snack[i];
				}
			}

			if(snack_sum > M) {
				return;
			}
			
			max = Math.max(max, snack_sum);
			return;
		}

		for (int i = x; i < check.length; i++) {
			if (check[i] == false) {
				check[i] = true;
				comb(depth + 1, i);
				check[i] = false;
			}
		}

	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			N = sc.nextInt();
			M = sc.nextInt();
			snack = new int[N];
			check = new boolean[N];
			for (int i = 0; i < snack.length; i++) {
				snack[i] = sc.nextInt();
			}
			max = -1;

			comb(0, 0);

			System.out.println("#" + t + " " + max);
		}
	}

}
