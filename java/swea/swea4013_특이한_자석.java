import java.util.*;
import java.io.*;

public class swea4013_특이한_자석 {

	static int T, K, ans;
	static int[] score = { 1, 2, 4, 8 }; // 자석 점수
	static int[] direction; // 좌석별로 움직여햐 하는 방향
	static int[][] gear; // 자석

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			K = Integer.parseInt(br.readLine());
			gear = new int[4][8];
			ans = 0;
			// 기어 자석
			for (int i = 0; i < 4; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < 8; j++) {
					gear[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			// K 만큼 회전
			for (int i = 0; i < K; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				// 자석 번호, 방향
				int id = Integer.parseInt(st.nextToken()) - 1; // 0 based
				int dir = Integer.parseInt(st.nextToken());
				// 움직이는 자석과 날개의 현재 값 ==> 어느 자석 어느 방향으로 움직여야할지
				check(id, dir);
				// 자석 4개를 하나씩 회전
				for (int j = 0; j < 4; j++) {
					move(j);
				}
			}
			// 점수 부여
			for (int i = 0; i < 4; i++) {
				if (gear[i][0] == 1)
					ans += score[i];
			}
			System.out.println("#" + t + " " + ans);
		}

	}

	// id 별 자석의 날개 시계 또는 반시계 움직임
	static void move(int id) {
		int temp;
		switch (direction[id]) {
		case 1: // 시계방향
			temp = gear[id][7];
			for (int i = 7; i > 0; i--) {
				gear[id][i] = gear[id][i - 1];
			}
			gear[id][0] = temp;
			break;

		case -1: // 반시계 방향
			temp = gear[id][0];
			for (int i = 0; i < 7; i++) {
				gear[id][i] = gear[id][i + 1];
			}
			gear[id][7] = temp;
			break;
		}
	}

	static void check(int id, int dir) {
		direction = new int[4];
		direction[id] = dir;
		// 오른쪽
		for (int i = id + 1; i < 4; i++) {
			if (gear[i - 1][2] != gear[i][6]) {
				direction[i] = direction[i - 1] * (-1);
			}
		}

		// 왼쪽
		for (int i = id - 1; i >= 0; i--) {
			if (gear[i][2] != gear[i + 1][6]) {
				direction[i] = direction[i + 1] * (-1);
			}
		}
	}

}
