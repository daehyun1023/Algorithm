import java.util.*;
import java.io.*;
public class BOJ15686치킨배달 {

	static int N;
	static int M;
	static int[][] arr;
	static int chickenCnt = 0;
	static int personCnt = 0;
	static int[] chickenX;
	static int[] chickenY;
	static int[] personX;
	static int[] personY;
	static int[] chickenStreet;
	static int min = Integer.MAX_VALUE;
	
	public static void calStreet(int idx) {
		for(int i=0; i<personCnt; i++) {
			chickenStreet[i] = Math.min(chickenStreet[i], Math.abs(chickenX[idx]-personX[i])+Math.abs(chickenY[idx]-personY[i]));
		}
	}
	
	public static void btr(int depth, int mask, int start) {
		if(depth == M) {
			Arrays.fill(chickenStreet, 101);
			for(int i=0; i<chickenCnt; i++) {
				if((mask & 1<<i) != 0) {
					calStreet(i);
				}
			}
			int cityStreet = 0;
			for(int i=0; i<personCnt; i++) {
				cityStreet += chickenStreet[i];
			}
			min = Math.min(min,  cityStreet);
			
			return;
		}
		
		for(int i=start; i<chickenCnt; i++) {
			if((mask & 1<<i) != 0) continue;
			btr(depth+1, mask|1<<i, i);
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N][N];
		for(int i=0; i<N; i++) {
			st =  new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if(arr[i][j] == 2) {
					chickenCnt++;
				}
				if(arr[i][j] == 1) {
					personCnt++;
				}
			}
		}
		chickenX = new int[chickenCnt];
		chickenY = new int[chickenCnt];
		personX = new int[personCnt];
		personY = new int[personCnt];
		chickenStreet = new int[personCnt];
		int chickenIdx = 0;
		int personIdx = 0;
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(arr[i][j] == 2) {
					chickenX[chickenIdx] = i;
					chickenY[chickenIdx++] = j;
				}
				if(arr[i][j] == 1) {
					personX[personIdx] = i;
					personY[personIdx++] = j;
				}
			}
		}
		btr(0, 0, 0);
		System.out.println(min);
		
	}

}
