import java.util.*;
import java.io.*;

public class BOJ11053가장긴증가하는부분수열 {

	static int N;
	static int[] arr;
	static int[] LIS;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N];
		LIS = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		int size = 0;
		for (int i = 0; i < N; i++) {
			int temp = Arrays.binarySearch(LIS, 0, size, arr[i]);
			if (temp < 0) {
				temp = Math.abs(temp) - 1;
			}

			LIS[temp] = arr[i];
			if (temp == size) {
				size++;
			}
		}
		
		
		
	}

}
