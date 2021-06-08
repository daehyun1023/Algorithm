package TwoPointer;
import java.util.*;
import java.io.*;
public class BOJ21921블로그 {

	static int N, X, max, cnt = 1;
	static int[] info;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());
		info = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			info[i] = Integer.parseInt(st.nextToken());
		}
		
		int[] sum = new int[N];
		sum[0] = info[0];
		for(int i=1; i<N; i++) {
			sum[i] = sum[i-1] + info[i];
		}
		
		max = sum[X-1];
		for(int i=X; i<N; i++) {
			if(max < sum[i] - sum[i-X]) {
				max = sum[i] - sum[i-X];
				cnt = 1;
			}
			else if(max == sum[i] - sum[i-X]){
				cnt += 1;
			}
		}
		
		if(max == 0) {
			System.out.println("SAD");
		}
		else {
			System.out.println(max);
			System.out.println(cnt);
		}
		
	}

}
