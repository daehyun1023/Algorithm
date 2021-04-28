package add;
import java.util.*;
import java.io.*;
public class BOJ11728배열합치기 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[] A = new int[N+1];
		int[] B = new int[M+1];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++) {
			B[i] = Integer.parseInt(st.nextToken());
		}
		
		A[N] = Integer.MAX_VALUE;
		B[M] = Integer.MAX_VALUE;
		
		int aIndex = 0;
		int bIndex = 0;
		
		StringBuilder sb = new StringBuilder();
		
		while(aIndex < N || bIndex < M) {
			if(A[aIndex] <= B[bIndex]) {
				sb.append(A[aIndex]+" ");
				aIndex++;
			}
			else {
				sb.append(B[bIndex]+" ");
				bIndex++;
			}
		}
		
		sb.setLength(sb.length()-1);
		System.out.println(sb);
	}

}
