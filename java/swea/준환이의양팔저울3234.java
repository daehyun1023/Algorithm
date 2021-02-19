package sw;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SW_준환이의양팔저울_3234_2 {

	static int T, N, ans;
	static int[] src;
	static boolean[] select;
	
	static int[] facto;
	static int[] pow;
	static int total;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			
			N = Integer.parseInt(br.readLine());
			src = new int[N];
			select = new boolean[N];
			
			facto = new int[N+1];
			pow = new int[N+1];
			facto[0] = facto[1] = pow[0] = 1;
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				src[i] = Integer.parseInt(st.nextToken());
				facto[i+1] = facto[i]*(i+1);
				pow[i+1] = pow[i]*2;
				total += src[i];
			}
			
			
			
			ans = 0;
			
			perm(0, 0, 0, total);
			
			System.out.println("#" + t + " " + ans);
		}

	}
	// totalRemain : 남은 추의 무게
	static void perm(int tgtIdx, int leftSum, int rightSum, int totalRemain) {
		
		if(  totalRemain + rightSum <= leftSum ) {
			// 남은 개수 : N - tgtIdx ==> 3개 남았다. pow[3]*facto[3]
			ans += pow[N-tgtIdx]*facto[N-tgtIdx];
			return;
			
		}
		
		//if( rightSum > leftSum ) return; // 가지치기
		
		// 기저조건
		if(tgtIdx == N) {
			ans++;
			return;
		}
		
		for (int i = 0; i < N; i++) {
			if( select[i] ) continue;
			
			select[i] = true;
			
			perm( tgtIdx+1, leftSum + src[i], rightSum, totalRemain - src[i] ); // 왼쪽 추에 담는 경우
			
			if( leftSum >= rightSum + src[i] ) {
				perm( tgtIdx+1, leftSum, rightSum + src[i], totalRemain - src[i] ); // 오른쪽 추에 담는 경우
			}
			select[i] = false;
		}
	}
}












