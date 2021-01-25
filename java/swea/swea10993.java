import java.util.*;

public class swea10993 {

	static int N;
	static int[][] arr;
	static ArrayList<state> states = new ArrayList();

	static class state {
		int x;
		int y;
		int s;

		state(int x, int y, int s) {
			this.x = x;
			this.y = y;
			this.s = s;
		}
	}

	public static String solve(int i) {
		float max_power = -1;
		int cnt = 0;
		int idx = 0;
		for (int j = 0; j < N; j++) {
			if (j == i)
				continue;
			int xi = states.get(i).x;
			int yi = states.get(i).y;
			int si = states.get(i).s;
			int xj = states.get(j).x;
			int yj = states.get(j).y;
			int sj = states.get(j).s;

			float power = (float) (sj / ((Math.pow((xi - xj), 2) + Math.pow((yi - yj), 2))));
			if (power > si) {
				cnt++;
				if (max_power < power) {
					max_power = power;
				}
			}
		}
		
		if (cnt == 0) {
			return "K";
		}
		
		cnt = 0;
		for (int j = 0; j < N; j++) {
			if (j == i)
				continue;
			int xi = states.get(i).x;
			int yi = states.get(i).y;
			int si = states.get(i).s;
			int xj = states.get(j).x;
			int yj = states.get(j).y;
			int sj = states.get(j).s;

			float power = (float) (sj / ((Math.pow((xi - xj), 2) + Math.pow((yi - yj), 2))));
			if (power == max_power) {
				cnt++;
				idx = j;
			}
		}
		
		
		
		if (cnt >= 2) {
			return "D";
		}

		if (cnt == 1) {
			if (solve(idx).equals("K")) {
				return Integer.toString(idx + 1);
			} else {
				return solve(idx);
			}
		}

		return "K";

	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			N = sc.nextInt();
			states.clear();
			for (int i = 0; i < N; i++) {
				int x = sc.nextInt();
				int y = sc.nextInt();
				int s = sc.nextInt();
				states.add(new state(x, y, s));
			}

			System.out.print("#" + t + " ");
			for (int i = 0; i < N; i++) {
				System.out.print(solve(i));
				System.out.print(" ");
			}
			System.out.println();
		}

	}

}
