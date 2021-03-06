import java.util.*;
import java.io.*;

public class BOJ2931가스관 {

	static int N, M, sx, sy, ex, ey;
	static char[][] arr;
	static boolean check = false;
	static int resultX;
	static int resultY;
	static char resultD;
	static int[] dx = { 0, 1, 0, -1 };
	static int[] dy = { -1, 0, 1, 0 };
	static char[] pipe = { '|', '-', '1', '2', '3', '4', '+' };
	static int usePipe;
	
	public static void go(int x, int y, int d, int cnt) {
		if (x == ex && y == ey && usePipe+1 < cnt) {
			check = true;
			return;
		}

		if (x < 0 || y < 0 || x >= N || y >= M || arr[x][y] == '.') {
			return;
		}


		switch (arr[x][y]) {
		case '|':
			if(d == 0 || d == 2) return;
			break;
		case '+':
			break;
		case '-':
			if(d == 1 || d == 3) return;
			
			break;
		case '1':
			if(d == 0) {
				d = 1;
			}
			else if(d == 3) {
				d = 2;
			}
			else {
				return;
			}
			break;
		case '2':
			if(d == 0) {
				d = 3;
			}
			else if(d== 1) {
				d = 2;
			}
			else return;
			break;
		case '3':
			if(d == 1) {
				d = 0;
			}
			else if(d==2) {
				d = 3;
			}
			else return;
			break;
		case '4':
			if (d==2) {
				d = 1;
			}
			else if(d == 3) {
				d = 0;
			}
			else return;
			break;
		}
		

		int nx = x + dx[d];
		int ny = y + dy[d];

		go(nx, ny, d, cnt+1);

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new char[N][M];

		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < M; j++) {
				arr[i][j] = str.charAt(j);
				if (arr[i][j] == 'M') {
					sx = i;
					sy = j;
				}
				else if (arr[i][j] == 'Z') {
					ex = i;
					ey = j;
				}
				else if (arr[i][j] != '.') {
					usePipe++;
				}
			}
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (arr[i][j] == '.') {
					for (int k = 0; k < 7; k++) {
						arr[i][j] = pipe[k];
						for (int d = 0; d < 4; d++) {
							go(sx, sy, d, 0);
							if(check) {
								resultX = i+1;
								resultY = j+1;
								resultD = arr[i][j];
								break;
							}
						}
						arr[i][j] = '.';
						if(check) break;
					}
				}
				if(check) break;
			}
			if(check) break;
		}
		
		System.out.println(resultX+" "+resultY+" "+resultD);
		
	}

}
