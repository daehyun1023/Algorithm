import java.util.ArrayList;
import java.util.Scanner;

public class swea8458원점으로집합 {

	static int T, N;

	public static void main(String[] args) {

		Scanner scann = new Scanner(System.in);
		T = scann.nextInt();
		for (int t = 1; t <= T; t++) {
			N = scann.nextInt();
			ArrayList<Integer> points = new ArrayList<>();
			for (int i = 0; i < N; i++) {
				int x = scann.nextInt();
				int y = scann.nextInt();
				points.add(Math.abs(x) + Math.abs(y));
			}
			int max = -1;
			for (int i = 0; i < N; i++) {
				max = Math.max(max, points.get(i));
			}
			if (max == 0) {
				System.out.println("#" + t + " " + 0);
			} else if (!isAll(points)) {
				System.out.println("#" + t + " " + (-1));
			} else if (isAllEven(points)) {
				int tt = val(max);
				// System.out.println(tt+"====>");
				for (int i = tt; i < 63248; i++) {
					long ss = nth(i);
					if (ss % 2 == 0) {
						tt = i;
						break;
					}
				}
				System.out.println("#" + t + " " + (tt));
			} else if (isAllOdd(points)) {
				int tt = val(max);
				// System.out.println(tt+"--->");
				for (int i = tt; i < 63248; i++) {
					long ss = nth(i);
					if (ss % 2 == 1) {
						tt = i;
						break;
					}
				}
				System.out.println("#" + t + " " + (tt));
			}
		}
	}

	static boolean isAllOdd(ArrayList<Integer> points) {
		for (int i = 0; i < points.size(); i++) {
			if (points.get(i) % 2 == 0) {
				return false;
			}
		}
		return true;
	}

	static boolean isAllEven(ArrayList<Integer> points) {
		for (int i = 0; i < points.size(); i++) {
			if (points.get(i) % 2 != 0) {
				return false;
			}
		}
		return true;
	}

	static boolean isAll(ArrayList<Integer> points) {
		boolean isS = false;
		if (isAllEven(points) || isAllOdd(points)) {
			isS = true;
		} else {
			isS = false;
		}
		return isS;
	}

	static int val(int t) {
		double x = (-1.0 + Math.sqrt(1.0 + 8.0 * t)) / 2.0;
		return (int) Math.ceil(x);
	}

	static long nth(int n) {
		return 0L + n * (n + 1L) / 2L;
	}

}
