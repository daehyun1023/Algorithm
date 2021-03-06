import java.util.*;
import java.io.*;

public class BOJ1938통나무옮기기 {

	static class Pair {
		int x;
		int y;
		int d;
		int s;

		Pair(int x, int y, int d, int s) {
			this.x = x;
			this.y = y;
			this.d = d;
			this.s = s;
		}
	}

	static int N, result, sx, sy, ex, ey;
	static int stateB = 1;
	static int stateE = 1;
	static char[][] arr;
	static int[] dx = { -1, 0, 0, 1 };
	static int[] dy = { 0, -1, 1, 0 };
	static boolean[][][] check;
	static Queue<Pair> q = new LinkedList();

	public static boolean isChangeState(int x, int y, int state) {
		for (int i = -1; i < 2; i++) {
			for (int j = -1; j < 2; j++) {
				int nx = x + i;
				int ny = y + j;
				if (nx < 0 || ny < 0 || nx >= N || ny >= N)
					return false;
				if (arr[nx][ny] == '1') {
					return false;
				}
			}
		}

		return true;

	}

	public static void bfs() {
		while (!q.isEmpty()) {
			Pair curr = q.poll();
			if (curr.x == ex && curr.y == ey && curr.s == stateE) {
				result = curr.d;
				return;
			}

			if (isChangeState(curr.x, curr.y, curr.s) && check[curr.x][curr.y][(curr.s + 1) % 2] == false) {
				check[curr.x][curr.y][(curr.s + 1) % 2] = true;
				q.add(new Pair(curr.x, curr.y, curr.d + 1, (curr.s + 1) % 2));
			}
			
			for (int i = 0; i < 4; i++) {
				int nx = curr.x + dx[i];
				int ny = curr.y + dy[i];

				if (curr.s == 1) {
					if(nx-1 <0 || nx+1 >=N || ny<0 || ny>=N) continue;
					if(arr[nx][ny] == '1' || arr[nx-1][ny] == '1' || arr[nx+1][ny] == '1' || check[nx][ny][curr.s]==true) continue;
					check[nx][ny][curr.s]=true;
					q.add(new Pair(nx,ny,curr.d+1,curr.s));
				}

				else {
					if(nx <0 || nx >=N || ny-1<0 || ny+1>=N) continue;
					if(arr[nx][ny] == '1' || arr[nx][ny-1] == '1' || arr[nx][ny+1] == '1' || check[nx][ny][curr.s]==true) continue;
					check[nx][ny][curr.s]=true;
					q.add(new Pair(nx,ny,curr.d+1,curr.s));
				}
			}

		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		String str;
		arr = new char[N][N];
		check = new boolean[N][N][2];
		for (int i = 0; i < N; i++) {
			str = br.readLine();
			for (int j = 0; j < N; j++) {
				arr[i][j] = str.charAt(j);
				if (arr[i][j] == 'B') {
					sx = i;
					sy = j;
					if (j - 1 >= 0 && arr[i][j - 1] == 'B') {
						stateB = 0;
						sy--;
					} else {
						sx--;
					}
				} else if (arr[i][j] == 'E') {
					ex = i;
					ey = j;
					if (j - 1 >= 0 && arr[i][j - 1] == 'E') {
						stateE = 0;
						ey--;
					} else {
						ex--;
					}
				}
			}
		}

		q.add(new Pair(sx, sy, 0, stateB));
		check[sx][sy][stateB] = true;

		bfs();

		System.out.println(result);

	}

}
