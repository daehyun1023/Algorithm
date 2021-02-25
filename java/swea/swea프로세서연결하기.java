import java.util.*;
import java.io.*;

public class swea프로세서연결하기 {

	static int N, max, totalCnt, min, map[][];
	static int[] dx = { -1, 0, 0, 1 };
	static int[] dy = { 0, -1, 1, 0 };
	static ArrayList<int[]> list; // 고려해야하는 코어만 담고 있는 리스트(가장자리 코어는 배제)

	private static boolean isAvailable(int x, int y, int d) {
		int nx = x, ny = y;
		while (true) {
			nx += dx[d];
			ny += dy[d];
			if (nx < 0 || ny < 0 || nx >= N || ny >= N)
				break;
			if (map[nx][ny] >= 1) {
				return false;
			}
		}
		return true;
	}
	
	
	
	public static void go(int index, int cCnt) { // index: 부분집합에 고려할 코어 인덱스, cCnt: 연결된 코어 개수
		if(index == totalCnt) {
			int res = getLength();
			if(max < cCnt) {
				max = cCnt;
				min = res;
			}
			else if(max == cCnt) {
				if(res<min) {
					min = res;
				}
			}
			
			return;
			
		}
		
		// 코어 선택 전선 놓아보기(4방향으로 놓아보기)
		int[] curr = list.get(index);
		int x = curr[0], y = curr[1];
		for (int d = 0; d < 4; d++) {
			if(isAvailable(x,y,d)) {
				// 전선 놓기
				setStatus(x,y,d,2);
				// 다음코어로 넘어가기
				go(index+1, cCnt+1);
				// 놓았던 전선 되돌려 놓기
				setStatus(x,y,d,0);
			}
		}
		
		// 코어 비선택
		go(index+1, cCnt);
		
	}

	private static void setStatus(int x, int y, int d, int s) {
		int nx = x, ny = y;
		while (true) {
			nx += dx[d];
			ny += dy[d];
			if (nx < 0 || ny < 0 || nx >= N || ny >= N)
				break;
			map[nx][ny] = s;
		}
	}
	
	private static int getLength() {
		int lCnt = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(map[i][j]==2) lCnt++;
			}
		}
		return lCnt;
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());
		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(in.readLine());
			map = new int[N][N];
			list = new ArrayList();
			max = 0;
			min = Integer.MAX_VALUE;
			totalCnt = 0;

			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(in.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if (i == 0 || j == 0 || i == N - 1 || j == N - 1)
						continue;
					if (map[i][j] == 1) {
						list.add(new int[] { i, j });
						totalCnt++;
					}
				}
			}
			
//			go(0,0);
//			System.out.println("#"+tc+" "+min);
			
		}

	}

}
