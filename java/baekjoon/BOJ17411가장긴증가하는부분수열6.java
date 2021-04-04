import java.util.*;
import java.io.*;

public class BOJ17411가장긴증가하는부분수열6 {

	static int N;
	static int[] arr;
	static int[] dp;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		arr = new int[N];

		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		dp = new int[N];
		int size = 0;
		for (int i = 0; i < N; i++) {
			int temp = Arrays.binarySearch(dp, 0, size, arr[i]);
			if (temp < 0) {
				temp = Math.abs(temp) - 1;
			}
			dp[temp] = arr[i];
			if (temp == size) {
				size++;
			}
		}
	}

}
