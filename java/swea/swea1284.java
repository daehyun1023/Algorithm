import java.util.*;

public class swea1284 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for (int t = 1; t <= T; t++) {
			int p = sc.nextInt();
			int q = sc.nextInt();
			int r = sc.nextInt();
			int s = sc.nextInt();
			int w = sc.nextInt();

			int A = w * p;
			int B = 0;
			if (w <= r) {
				B = q;
			} else {
				B = q + (w - r) * s;
			}

			int result = Math.min(A, B);

			System.out.println("#"+t+" "+result);
		}
	}

}
