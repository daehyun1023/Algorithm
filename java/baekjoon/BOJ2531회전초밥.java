import java.util.*;
import java.io.*;

public class BOJ2531회전초밥 {

	static int N, d, k, c, cnt, max = Integer.MIN_VALUE;
	static int[] check;
	static int[] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		d = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		arr = new int[N + 1];
		check = new int[3001];
		check[c] = 1;
		for (int i = 1; i <= N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		int left = 1;
		int right = k;
		for (int i = 1; i <= k; i++) {
			check[arr[i]]++;
		}

		for(int i=1; i<=3000; i++) {
			if(check[i] > 0) {
				cnt++;
				max = cnt;
			}	
		}

		while (true) {
			if (check[arr[left]] > 0) {
				if (--check[arr[left]] == 0) {
					cnt--;
				}
			}
			
			left++;
			right++;
			if (right > N) {
				right %= N;
			}

			if(left > N) break;
			
			if (++check[arr[right]] == 1) {
				cnt++;
			}

			max = Math.max(max, cnt);
			
		}
		
		System.out.println(max);
	}

}
