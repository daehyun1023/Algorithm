import java.util.*;
import java.io.*;

public class swea8382방향전환 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Scanner scann = new Scanner(System.in);
		int T = scann.nextInt();
		for (int i = 1; i <= T; i++) {
			int x1 = scann.nextInt();
			int y1 = scann.nextInt();
			int x2 = scann.nextInt();
			int y2 = scann.nextInt();
			int X = Math.abs(x2 - x1);
			int Y = Math.abs(y2 - y1);
            /*
             * 출발지 x1,y1 에서 목적지 x2,y2까지
             * x축 거리 X, y축 거리가 Y일 때
             * X > Y이면
             * Y축 이동도 최소 X-1만큼 이동을 해야한다
             * 이 때 평균을 구하는 이유는f
             * ]
             * Y축 이 목적지의 y좌표에 도착 이후에도 X축이 도착할 때 까지 
             * 계속 움직여야 하기 때문에 움직이고 돌아올 수 있는  y좌표가 평균값의 좌표이기 때문이다.
             * */
			int t = (X + Y) / 2;
			int val = Math.abs(t - X) + Math.abs(t - Y) + 2 * t;
			System.out.println("#" + i + " " + val);
		}
	}
}
