package add;

import java.util.*;

public class BOJ9663N_Queen {

	static int N, ans;
	static int[] col;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		col = new int[N + 1];

		setQueen(0);

		System.out.println(ans);
	}

	private static boolean setQueen(int rowNo) {
		if(!isAvailable(rowNo)) {
			return false;
		}
		
		if(rowNo == N) {
			ans++;
			return true;
		}
		
		for (int i = 1; i <= N; i++) {
			col[rowNo+1] = i;
			if(setQueen(rowNo+1)) {
				continue;
			}
		}
		return false;
	}

	private static boolean isAvailable(int rowNo) {
		for(int i=1; i<rowNo; i++) {
			if(col[rowNo] == col[i] || Math.abs(col[rowNo] - col[i]) == rowNo - i) {
				return false;
			}
		}
		
		return true;
	}

}
