package add;

import java.util.*;
import java.io.*;

public class BOJ3687성냥개비 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			int n = Integer.parseInt(br.readLine());
			int[] numbers = { 1, 7, 4, 2, 0, 8 };
			String[] minDp = new String[101];
			String max = "";
			Arrays.fill(minDp, Long.toString(Long.MAX_VALUE));
			minDp[2] = "1";
			minDp[3] = "7";
			minDp[4] = "4";
			minDp[5] = "2";
			minDp[6] = "6";
			minDp[7] = "8";
			minDp[8] = "10";
			int size = n / 2;
			if (n % 2 == 0) {
				for (int i = 0; i < size; i++) {
					max += "1";
				}

			} else {
				max += "7";
				for (int i = 0; i < size - 1; i++) {
					max += "1";
				}
			}

			for (int i = 9; i <= 100; i++) {
				for (int j=0; j<6; j++) {
					minDp[i] = Long.toString(
							Math.min(Long.parseLong(minDp[i]), Long.parseLong(minDp[i - j - 2] + numbers[j])));
				}
			}

			System.out.println(minDp[n] + " " + max);

		}

	}

}
