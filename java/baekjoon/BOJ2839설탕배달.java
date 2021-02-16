import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ2839설탕배달 {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N+1];
		for(int i=0; i<N+1; i++) {
			arr[i] = 50000;
		}
		if(N>=5) {		
			arr[N-5] = 1;
		}
		arr[N-3] = 1;
		for(int i=N-3; i>=3; i--) {
			if(arr[i] != 0) {
				if(i>=5) {
					arr[i-5] = Math.min(arr[i-5], arr[i] + 1);					
				}
				if(i>=3) {
					arr[i-3] = Math.min(arr[i-3], arr[i] + 1);					
				}
			}
		}
		
		System.out.println(arr[0]!=50000 ? arr[0] : -1);
	}

}
