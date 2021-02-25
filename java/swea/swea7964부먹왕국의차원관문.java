import java.util.*;
import java.io.*;

public class swea7964부먹왕국의차원관문 {

	static int N, D, arr[], result;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			D = Integer.parseInt(st.nextToken());
			result = 0;

			arr = new int[N];
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}

			for (int i = 0; i < N - D; i++) {
				if (arr[i] == 0) {
					boolean isCity = false;
					int idx = 0;
					for (int j = 1; j < D; j++) {
						if (arr[i + j] == 1) {
							isCity = true;
							idx = i + j;
						}
					}
					if (isCity) {
						i = idx -1;
					} else {
						arr[i] = 1;
						result++;
						i = i + D - 2;
					}

				}

				else {
					boolean isCity = false;
					int idx = 0;
					for (int j = 1; j <= D; j++) {
						if (arr[i + j] == 1) {
							isCity = true;
							idx = i + j;
						}
					}
					if (isCity) {
						i = idx-1;
					} else {
						arr[i + D] = 1;
						result++;
						i = i + D -1;
					}
				}

			}

			System.out.println("#"+t+" "+result);
		}
	}
}
