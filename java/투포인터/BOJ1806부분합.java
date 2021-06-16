package TwoPointer;
import java.util.*;
import java.io.*;
public class BOJ1806부분합 {

	static int N, S, sum;
	static int[] arr;
	static int result = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		arr = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int start = 0;
		int end = 0;
		sum = arr[0];
		int cnt = 1;
		
		while(true) {
			
			if(end == N) {
				break;
			}
			if(sum >= S) {
				result = Math.min(result, cnt);
				cnt--;
				sum -= arr[start];
				start++;				
			}
			
			else if(sum < S) {
				end++;
				cnt++;
				if(end <= N-1) {					
					sum += arr[end];
				}
			}
			
		}
		
		System.out.println(result == Integer.MAX_VALUE ? 0 : result);
		
	}

}
