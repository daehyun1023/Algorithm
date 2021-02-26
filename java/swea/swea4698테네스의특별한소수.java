import java.util.*;
import java.io.*;

public class swea4698테네스의특별한소수 {

	static int D, A, B;
	static boolean check[];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			D = Integer.parseInt(st.nextToken());
			A = Integer.parseInt(st.nextToken());
			B = Integer.parseInt(st.nextToken());
			check = new boolean[B + 1];
			for (int i = 2; i <= B; i++) {
				check[i] = true;
			}

			for (int i = 2; i <= Math.sqrt(B); i++) {
				int j = 2;
				while (i * j <= B) {
					check[i * j] = false;
					j++;
				}
			}
			int result = 0;
			for (int i = A; i <= B; i++) {
				if (!check[i])
					continue;
				String num = Integer.toString(i);
				String d = Integer.toString(D);
				if (num.contains(d)) {
					result++;
				}
			}
			System.out.println("#"+t+" "+result);
		}
	}
}
