import java.util.*;

class Pairs {
	int x;
	int y;
	int t;

	Pairs(int x, int y, int t) {
		this.x = x;
		this.y = y;
		this.t = t;
	}
}

public class Main {

	static int N;
	static int M;
	static String[][] arr;
	static int[] dx = { -1, 0, 0, 1 };
	static int[] dy = { 0, -1, 1, 0 };
	static Queue<Pairs> q;
	static boolean[][] check;
	
	public static void bfs() {
		while (!q.isEmpty()) {
			Pairs curr = q.poll();
			for (int i = 0; i < 4; i++) {
				int nx = curr.x + dx[i];
				int ny = curr.y + dy[i];

				if (arr[curr.x][curr.y].equals("@")) {
					if (nx < 0 || ny < 0 || nx >= N || ny >= M) {
						System.out.println(curr.t + 1);
						return;
					}

					if (arr[nx][ny].equals("*") || arr[nx][ny].equals("#"))
						continue;
					if (arr[nx][ny].equals(".")) {
						arr[nx][ny] = "@";
						check[nx][ny]=true;
						check[curr.x][curr.y]=false;
						q.add(new Pairs(nx, ny, curr.t + 1));
					}

				} else if (arr[curr.x][curr.y].equals("*")) {
					if (nx < 0 || ny < 0 || nx >= N || ny >= M) {
						continue;
					}
					if (arr[nx][ny].equals("#")) {
						continue;
					}

					if (arr[nx][ny].equals(".")) {
						arr[nx][ny] = "*";
						q.add(new Pairs(nx, ny, 0));
					}
					if(arr[nx][ny].equals("@")) {
						if(check[nx][ny]==false) {
							arr[nx][ny]="*";
							q.add(new Pairs(nx,ny,0));
						}
					}
				}

			}

		}

		System.out.println("IMPOSSIBLE");
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int t = 0; t < T; t++) {
			M = sc.nextInt();
			N = sc.nextInt();
			arr = new String[N][M];
			check=new boolean[N][M];
			q=new LinkedList<>();
			for (int i = 0; i < N; i++) {
				String str = sc.next();
				for (int j = 0; j < M; j++) {
					arr[i][j] = str.substring(j, j + 1);
					if (arr[i][j].equals("*")) {
						q.add(new Pairs(i, j, 0));
					}
				}
			}

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (arr[i][j].equals("@")) {
						check[i][j]=true;
						q.add(new Pairs(i, j, 0));
					}
				}
			}

			bfs();
		}
	}

}
