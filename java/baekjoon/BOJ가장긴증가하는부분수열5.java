import java.util.*;
import java.io.*;

public class BOJ가장긴증가하는부분수열5 {

	static class Pair {
		int x;
		int y;

		Pair(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	static int N;
	static int[] arr;
	static int[] dp;
	static Pair[] pair;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		arr = new int[N];

		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		dp = new int[N];
		pair = new Pair[N];
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
			pair[i] = new Pair(temp, arr[i]);
		}

		System.out.println(size);
		Stack<Integer> stack = new Stack<Integer>();

		for (int i = N - 1; i >= 0; i--) {
			if (pair[i].x == size - 1) {
				stack.add(pair[i].y);
				size--;
			}
		}
		while (!stack.isEmpty()) {
			System.out.print(stack.pop() + " ");
		}

	}

}
