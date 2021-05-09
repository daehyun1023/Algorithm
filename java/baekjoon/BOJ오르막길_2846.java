package add;
import java.util.*;
import java.io.*;
public class BOJ오르막길_2846 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int start = arr[0];
		int prev = arr[0];
		int max = 0;
		for (int i = 1; i < N; i++) {
			if(arr[i] > prev) {
				max = Math.max(max, arr[i] - start);
			}
			else {
				start = arr[i];
			}
			prev = arr[i];
		}
		
		System.out.println(max);	
	}
}
