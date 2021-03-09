import java.util.*;
import java.io.*;

public class BOJ2003수들의합2 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[] arr = new int[N+1];
		int cnt = 0;
		int start = 0;
		int end = 0;
		int sum = 0;
		st = new StringTokenizer(br.readLine());

		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		while(end <= N) {
			if(sum >= M) {
				sum -= arr[start++];
			}
			else {
				sum += arr[end++];
			}
			
			if(sum == M) {
				cnt++;
			}
			
		}
		
		System.out.println(cnt);

	}

}
