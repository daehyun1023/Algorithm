import java.util.*;

public class swea1206 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = 10;
		for(int t = 1; t<=T; t++){
		int N = sc.nextInt();
		int[] arr = new int[N + 4];
		int result = 0;

		for (int i = 2; i < N + 2; i++) {
			arr[i] = sc.nextInt();
		}

		for (int i = 2; i < N + 2; i++) {
			int now = arr[i];
			int left1 = arr[i-1];
			int left2 = arr[i-2];
			int right1 = arr[i+1];
			int right2 = arr[i+2];
			int max = 0;
			int right = Math.max(right1, right2);
			int left = Math.max(left1, left2);
			max = Math.max(right, left);
			
			if(now > max) {
				result += arr[i] - max;
			}
			
		}
		
		System.out.println("#"+t+" "+result);
		}
	}

}
