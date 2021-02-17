import java.util.*;
import java.io.*;
public class BOJ1992쿼드트리 {

	static int[][] arr;
	static StringBuilder sb;
	
	public static int isZip(int N, int r, int c) {
		int temp = arr[r][c];
		for (int i = r; i < N + r; i++) {
			for (int j = c; j < N + c; j++) {
				if(temp != arr[i][j]) return -1;
			}
		}
		return temp;
	}
	
	public static void solve(int N, int r, int c) {
		if(N==1) {
			sb.append(isZip(N, r, c));
			return;
		}
		
		if(isZip(N, r, c) == -1) {
			sb.append('(');
			solve(N/2, r, c);
			solve(N/2, r, c+N/2);
			solve(N/2, r+N/2, c);
			solve(N/2, r+N/2, c+N/2);
			sb.append(')');
			return;
		}
		
		sb.append(isZip(N,r,c));
		return;
		
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int r = 0;
		int c = 0;
		arr = new int[N][N];
		for(int i=0; i<N; i++) {
			String str = br.readLine();
			for(int j=0; j<N; j++) {
				arr[i][j] = str.charAt(j) - '0';
			}
		}
		sb = new StringBuilder();
		solve(N, 0 , 0);
		System.out.println(sb.toString());
	}
}
